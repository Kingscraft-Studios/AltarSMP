#!/usr/bin/env bash
# Concat repair loop: apply what the tools can prove, recompile, re-audit, repeat.
# Stops when a full pass changes nothing.
set -u
ROOT=/Projects/AltarSMP
TOOLS=$ROOT/tools
CP=$(cat /tmp/opencode/allcp.txt)
MVN=/opt/idea-2026.2.2/plugins/maven-plugin/lib/maven3/bin/mvn
WORK=/tmp/opencode

audit() {
  java -Xss256m -cp "/tmp/opencode/scan:$CP" ConcatTruth "$WORK/decoded.tsv" \
      --orig /home/kingscrafts/Documents/AltarSMP.jar --new "$ROOT/target/classes" \
      > "$WORK/truth.tsv" 2>&1 || return 1
  local m
  m=$(grep -n '^#NEW' "$WORK/truth.tsv" | cut -d: -f1)
  sed -n "2,$((m-1))p" "$WORK/truth.tsv" > "$WORK/truth_orig.tsv"
  awk 'f{print} /^#NEW$/{f=1}' "$WORK/truth.tsv" > "$WORK/truth_new.tsv"
  python3 "$WORK/classify.py" "$WORK/truth_orig.tsv" "$WORK/truth_new.tsv" | head -1
}

for i in $(seq 1 "${1:-6}"); do
  before=$(md5sum "$ROOT"/src/main/java/pl/*.java | md5sum | cut -d' ' -f1)
  a=$(cd "$TOOLS" && python3 concatfix.py   "$WORK/truth_orig.tsv" "$WORK/truth_new.tsv" --apply 2>/dev/null | grep -oP '^APPLIED replacements: \K[0-9]+')
  b=$(cd "$TOOLS" && python3 concatmerge.py "$WORK/truth_orig.tsv" "$WORK/truth_new.tsv" --apply 2>/dev/null | grep -oP '^APPLIED merged: \K[0-9]+')
  after=$(md5sum "$ROOT"/src/main/java/pl/*.java | md5sum | cut -d' ' -f1)
  if [ "$before" = "$after" ]; then echo "round $i: no change - converged"; break; fi
  echo "round $i: concatfix=$a concatmerge=$b"
  (cd "$ROOT" && "$MVN" -o -q -DskipTests -Dmaven.compiler.debug=true \
       -Dmaven.compiler.debuglevel=lines,vars,source compile 2>&1 | grep -E '^\[ERROR\].*\.java' | head -5)
  audit
done
