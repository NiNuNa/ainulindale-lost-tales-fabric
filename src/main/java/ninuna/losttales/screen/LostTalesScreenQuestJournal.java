package ninuna.losttales.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import ninuna.losttales.util.LostTalesPlayerData;
import ninuna.losttales.util.LostTalesStateSaverAndLoader;

@Environment(EnvType.CLIENT)
public class LostTalesScreenQuestJournal extends Screen {
    private static final Text QUEST_JOURNAL_TITLE_TEXT = Text.translatable("ui.losttales.quest.journal.title");
    private final Screen parentScreen;

    public LostTalesScreenQuestJournal(Screen parentScreen) {
        super(QUEST_JOURNAL_TITLE_TEXT);
        this.parentScreen = parentScreen;
    }

    public ButtonWidget button1;
    public ButtonWidget button2;

    @Override
    protected void init() {
        LostTalesPlayerData playerData = LostTalesStateSaverAndLoader.getPlayerState(client.getServer().getPlayerManager().getPlayer(client.player.getUuid()));
        if (playerData.activeQuests.isEmpty() && playerData.completedQuests.isEmpty()) {
            playerData.activeQuests.add(1);
        } else {
            button1 = ButtonWidget.builder(Text.literal("Button 1"), button -> {
                        System.out.println("You clicked button1!");
                    })
                    .dimensions(width / 2 - 205, 20, 200, 20)
                    .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                    .build();
            button2 = ButtonWidget.builder(Text.literal("Button 2"), button -> {
                        System.out.println("You clicked button2!");
                    })
                    .dimensions(width / 2 + 5, 20, 200, 20)
                    .tooltip(Tooltip.of(Text.literal("Tooltip of button2")))
                    .build();

            addDrawableChild(button1);
            addDrawableChild(button2);
        }
    }

    @Override
    public void close() {
        this.client.setScreen(this.parentScreen);
    }
}