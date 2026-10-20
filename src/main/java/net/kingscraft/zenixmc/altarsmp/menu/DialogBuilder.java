package net.kingscraft.zenixmc.altarsmp.menu;

import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.dialog.DialogResponseView;
import io.papermc.paper.registry.RegistryBuilderFactory;
import io.papermc.paper.registry.data.dialog.ActionButton;
import io.papermc.paper.registry.data.dialog.DialogBase;
import io.papermc.paper.registry.data.dialog.DialogRegistryEntry;
import io.papermc.paper.registry.data.dialog.action.DialogAction;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.input.DialogInput;
import io.papermc.paper.registry.data.dialog.input.SingleOptionDialogInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickCallback;
import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class DialogBuilder {
  public final DialogType dialogType;

  public final String inputKey;

  private final String inputName;

  private Component title = Component.text("Dialog");

  private Component description = Component.text("-");

  private Component body = Component.empty();

  private String initialText = "";

  private boolean initialBoolean = false;

  private float initialNumber = 0.0F;

  private float minimumNumber = 0.0F;

  private float maximumNumber = 100.0F;

  private float numberStep = 1.0F;

  private boolean useTextInput = false;

  private boolean useFloatInput = false;

  private final List<SingleOptionDialogInput.OptionEntry> options = new ArrayList<>();

  private final List<ActionButton> actionButtons = new ArrayList<>();

  public BiConsumer<Player, String> onTextSubmit;

  public BiConsumer<Player, Integer> onIntegerSubmit;

  public BiConsumer<Player, Float> onFloatSubmit;

  public BiConsumer<Player, Boolean> onBooleanSubmit;

  public BiConsumer<Player, String> onOptionSubmit;

  public BiConsumer<Player, Boolean> onConfirmationSubmit;

  public DialogBuilder(DialogType dialogType, String paramString) {
    this.dialogType = dialogType;
    this.inputKey = paramString;
    this.inputName = sanitizeInputName(paramString);
  }

  private static String sanitizeInputName(String paramString) {
    if (paramString == null) {
      return "input";
    }
    String lower = paramString.toLowerCase(java.util.Locale.ROOT);
    StringBuilder builder = new StringBuilder(lower.length());
    for (int i = 0; i < lower.length(); i++) {
      char c = lower.charAt(i);
      boolean valid = (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_';
      builder.append(valid && !(i == 0 && (c >= '0' && c <= '9')) ? c : '_');
    }
    String result = builder.toString();
    return result.isEmpty() ? "input" : result;
  }

  public static DialogBuilder text(String paramString) {
    return new DialogBuilder(DialogType.TEXT, paramString);
  }

  public static DialogBuilder number(String paramString) {
    return new DialogBuilder(DialogType.NUMBER, paramString);
  }

  public static DialogBuilder bool(String paramString) {
    return new DialogBuilder(DialogType.BOOL, paramString);
  }

  public static DialogBuilder singleOption(String paramString) {
    return new DialogBuilder(DialogType.SINGLE_OPTION, paramString);
  }

  public static DialogBuilder confirmation() {
    return new DialogBuilder(DialogType.CONFIRMATION, null);
  }

  public static DialogBuilder multiAction() {
    return new DialogBuilder(DialogType.MULTI_ACTION, null);
  }

  public DialogBuilder title(Component paramComponent) {
    this.title = paramComponent;
    return this;
  }

  public DialogBuilder title(String paramString) {
    this.title = (Component)Component.text(paramString);
    return this;
  }

  public DialogBuilder description(Component paramComponent) {
    this.description = paramComponent;
    return this;
  }

  public DialogBuilder description(String paramString) {
    this.description = (Component)Component.text(paramString);
    return this;
  }

  public DialogBuilder body(Component paramComponent) {
    this.body = paramComponent;
    return this;
  }

  public DialogBuilder body(String paramString) {
    this.body = (Component)Component.text(paramString);
    return this;
  }

  public DialogBuilder initialText(String paramString) {
    this.initialText = paramString;
    return this;
  }

  public DialogBuilder initialBoolean(boolean paramBoolean) {
    this.initialBoolean = paramBoolean;
    return this;
  }

  public DialogBuilder initialNumber(float paramFloat) {
    this.initialNumber = paramFloat;
    return this;
  }

  public DialogBuilder minimumNumber(float paramFloat) {
    this.minimumNumber = paramFloat;
    return this;
  }

  public DialogBuilder maximumNumber(float paramFloat) {
    this.maximumNumber = paramFloat;
    return this;
  }

  public DialogBuilder setMinMaxNumber(float paramFloat1, float paramFloat2) {
    this.minimumNumber = paramFloat1;
    this.maximumNumber = paramFloat2;
    return this;
  }

  public DialogBuilder numberStep(float paramFloat) {
    this.numberStep = paramFloat;
    return this;
  }

  public DialogBuilder useFloatInput(float paramFloat) {
    this.numberStep = paramFloat;
    this.useFloatInput = true;
    return this;
  }

  public DialogBuilder useTextInput() {
    this.useTextInput = true;
    return this;
  }

  public DialogBuilder addOption(String paramString, Component paramComponent) {
    this.options.add(SingleOptionDialogInput.OptionEntry.create(paramString, paramComponent, this.options.isEmpty()));
    return this;
  }

  public DialogBuilder addOption(String paramString1, String paramString2) {
    return addOption(paramString1, (Component)Component.text(paramString2));
  }

  public DialogBuilder addActionButton(Component paramComponent, Consumer<Player> paramConsumer) {
    this.actionButtons.add(createActionButton(paramComponent, paramConsumer));
    return this;
  }

  public DialogBuilder addActionButton(String paramString, Consumer<Player> paramConsumer) {
    return addActionButton((Component)Component.text(paramString), paramConsumer);
  }

  public DialogBuilder onTextSubmit(BiConsumer<Player, String> paramBiConsumer) {
    this.onTextSubmit = paramBiConsumer;
    return this;
  }

  public DialogBuilder onIntegerSubmit(BiConsumer<Player, Integer> paramBiConsumer) {
    this.onIntegerSubmit = paramBiConsumer;
    return this;
  }

  public DialogBuilder onFloatSubmit(BiConsumer<Player, Float> paramBiConsumer) {
    this.onFloatSubmit = paramBiConsumer;
    return this;
  }

  public DialogBuilder onBooleanSubmit(BiConsumer<Player, Boolean> paramBiConsumer) {
    this.onBooleanSubmit = paramBiConsumer;
    return this;
  }

  public DialogBuilder onOptionSubmit(BiConsumer<Player, String> paramBiConsumer) {
    this.onOptionSubmit = paramBiConsumer;
    return this;
  }

  public DialogBuilder onConfirmationSubmit(BiConsumer<Player, Boolean> paramBiConsumer) {
    this.onConfirmationSubmit = paramBiConsumer;
    return this;
  }

  public Dialog build() {
    switch (this.dialogType.ordinal()) {
      case 0:
        return Dialog.create(this::buildTextDialog);
      case 1:
        return Dialog.create(this::buildNumberDialog);
      case 2:
        return Dialog.create(this::buildBooleanDialog);
      case 3:
        return Dialog.create(this::buildSingleOptionDialog);
      case 4:
        return Dialog.create(this::buildConfirmationDialog);
      case 5: {
        List list = new ArrayList(this.actionButtons);
        return Dialog.create(f -> buildMultiActionDialog(list, f));
      }
      default:
        throw new MatchException(null, (Throwable)null);
    }
  }

  public void show(Player paramPlayer) {
    paramPlayer.showDialog(build());
  }

  public ActionButton createConfirmButton(BiConsumer<DialogResponseView, Player> paramBiConsumer) {
    return ActionButton.create((Component)Component.text("Confirm"), null, 100, (DialogAction)DialogAction.customClick((paramResp1, paramAud1) -> handleConfirmButtonClick(paramBiConsumer, paramResp1, paramAud1), (ClickCallback.Options)ClickCallback.Options.builder().uses(1).build()));
  }

  public ActionButton createActionButton(Component paramComponent, Consumer<Player> paramConsumer) {
    return ActionButton.create(paramComponent, null, 200, (DialogAction)DialogAction.customClick((paramResp2, paramAud2) -> handleActionButtonClick(paramConsumer, paramResp2, paramAud2), (ClickCallback.Options)ClickCallback.Options.builder().uses(1).build()));
  }

  public static void handleActionButtonClick(Consumer<Player> paramConsumer, DialogResponseView paramDialogResponseView, Audience paramAudience) {
    Player player;
    if (paramAudience instanceof Player) {
      player = (Player)paramAudience;
    } else {
      return;
    } 
    paramConsumer.accept(player);
  }

  public static void handleConfirmButtonClick(BiConsumer<DialogResponseView, Player> paramBiConsumer, DialogResponseView paramDialogResponseView, Audience paramAudience) {
    Player player;
    if (paramAudience instanceof Player) {
      player = (Player)paramAudience;
    } else {
      return;
    } 
    paramBiConsumer.accept(paramDialogResponseView, player);
  }

  public void buildMultiActionDialog(List paramList, RegistryBuilderFactory paramRegistryBuilderFactory) {
    ((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.multiAction(paramList).columns(1).build());
  }

  public void buildConfirmationDialog(RegistryBuilderFactory paramRegistryBuilderFactory) {
    ((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).body(List.of(DialogBody.plainMessage(this.body))).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.confirmation(createActionButton((Component)Component.text("Confirm"), this::handleConfirm), createActionButton((Component)Component.text("Cancel"), this::handleCancel)));
  }

  public void handleCancel(Player paramPlayer) {
    {
      if (this.onConfirmationSubmit != null)
        this.onConfirmationSubmit.accept(paramPlayer, Boolean.valueOf(false));
    }}

  public void handleConfirm(Player paramPlayer) {
    {
      if (this.onConfirmationSubmit != null)
        this.onConfirmationSubmit.accept(paramPlayer, Boolean.valueOf(true));
    }}

  public void buildSingleOptionDialog(RegistryBuilderFactory paramRegistryBuilderFactory) {
    ((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).inputs(List.of(DialogInput.singleOption(this.inputName, this.description, this.options).build())).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.notice(createConfirmButton(this::handleOptionSubmit)));
  }

  public void handleOptionSubmit(DialogResponseView paramDialogResponseView, Player paramPlayer) {
    {
      if (this.onOptionSubmit != null)
        this.onOptionSubmit.accept(paramPlayer, paramDialogResponseView.getText(this.inputName));
    }}

  public void buildBooleanDialog(RegistryBuilderFactory paramRegistryBuilderFactory) {
    ((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).inputs(List.of(DialogInput.bool(this.inputName, this.description).initial(this.initialBoolean).build())).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.notice(createConfirmButton(this::handleBooleanSubmit)));
  }

  public void handleBooleanSubmit(DialogResponseView paramDialogResponseView, Player paramPlayer) {
    {
      if (this.onBooleanSubmit != null)
        this.onBooleanSubmit.accept(paramPlayer, paramDialogResponseView.getBoolean(this.inputName));
    }}

  public void buildNumberDialog(RegistryBuilderFactory paramRegistryBuilderFactory) {
    {
      {

      }}((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).inputs(List.of(this.useTextInput ? DialogInput.text(this.inputName, this.description).initial(String.valueOf(this.useFloatInput ? this.initialNumber : (int)this.initialNumber)).build() : DialogInput.numberRange(this.inputName, this.description, this.minimumNumber, this.maximumNumber).initial(Float.valueOf(Math.clamp(this.initialNumber, this.minimumNumber, this.maximumNumber))).step(Float.valueOf(this.numberStep)).width(500).build())).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.notice(createConfirmButton(this::handleNumberSubmit)));
  }

  public void handleNumberSubmit(DialogResponseView paramDialogResponseView, Player paramPlayer) {
    {
      if (this.useFloatInput) {
        if (this.onFloatSubmit != null)
          try {
            {

            }float f = this.useTextInput ? Float.parseFloat(paramDialogResponseView.getText(this.inputName).trim()) : paramDialogResponseView.getFloat(this.inputName).floatValue();
            this.onFloatSubmit.accept(paramPlayer, Float.valueOf(f));
          } catch (NumberFormatException numberFormatException) {} 
      } else if (this.onIntegerSubmit != null) {
        try {
          {

          }int i = this.useTextInput ? Integer.parseInt(paramDialogResponseView.getText(this.inputName).trim()) : Math.round(paramDialogResponseView.getFloat(this.inputName).floatValue());
          this.onIntegerSubmit.accept(paramPlayer, Integer.valueOf(i));
        } catch (NumberFormatException numberFormatException) {}
      } 
    }}

  public void buildTextDialog(RegistryBuilderFactory paramRegistryBuilderFactory) {
    ((DialogRegistryEntry.Builder)paramRegistryBuilderFactory.empty()).base(DialogBase.builder(this.title).inputs(List.of(DialogInput.text(this.inputName, this.description).initial(this.initialText).build())).build()).type((io.papermc.paper.registry.data.dialog.type.DialogType) io.papermc.paper.registry.data.dialog.type.DialogType.notice(createConfirmButton(this::handleTextSubmit)));
  }

  public void handleTextSubmit(DialogResponseView paramDialogResponseView, Player paramPlayer) {
    {
      if (this.onTextSubmit != null)
        this.onTextSubmit.accept(paramPlayer, paramDialogResponseView.getText(this.inputName).trim());
    }}


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */