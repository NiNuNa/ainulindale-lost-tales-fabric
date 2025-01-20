package ninuna.losttales.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.event.LostTalesKeyInputHandler;
import ninuna.losttales.screen.widget.LostTalesWidgetQuestJournalQuestInfo;
import ninuna.losttales.screen.widget.LostTalesWidgetQuestJournalQuestList;

@Environment(EnvType.CLIENT)
public class LostTalesScreenQuestJournal extends Screen {
    public static final Text QUEST_JOURNAL_TITLE_TEXT = Text.translatable("ui.losttales.quest.journal.title");
    public static final Identifier QUEST_JOURNAL_SCREEN_TEXTURES = Identifier.of(LostTales.MOD_ID, "textures/gui/quest_journal.png");

    private final int textMargin = 3;
    private final int widgetMargin = 5;
    private final int color = 0xFFFFFFFF;
    private final int header_Y = 25;
    private final int headerText_X = 32;
    private final int questList_Y = this.header_Y + this.widgetMargin;
    private final int questInfoHeader_Y = questList_Y + 45;
    private final int questInfoHeader_X = 28;
    private final int questInfo_Y = this.questInfoHeader_Y + this.widgetMargin;
    private final int questObjectivesHeader_Y = 25;

    //Todo: List of active quests.

    private LostTalesWidgetQuestJournalQuestList questListWidget;
    private LostTalesWidgetQuestJournalQuestInfo questInfoWidget;
    private final Screen parentScreen;

    public LostTalesScreenQuestJournal(Screen parentScreen) {
        super(QUEST_JOURNAL_TITLE_TEXT);
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        this.questListWidget = new LostTalesWidgetQuestJournalQuestList(client, this.width / 3, this.height - this.questList_Y - this.widgetMargin + 1, this.questList_Y, 30);
        this.questInfoWidget = new LostTalesWidgetQuestJournalQuestInfo(this.width / 3 + this.questInfoHeader_X, this.questInfo_Y, this.width * 2 / 3 - this.questInfoHeader_X, this.height / 7 * 3 - this.questInfo_Y, Text.translatable("test"), this.textRenderer);

        this.addDrawableChild(this.questListWidget);
        this.addDrawableChild(this.questInfoWidget);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (LostTalesKeyInputHandler.questJournalKey.matchesKey(keyCode, scanCode)) {
            this.client.setScreen(null);
            this.client.mouse.lockCursor();
            return true;
        } else {
            return super.keyPressed(keyCode, scanCode, modifiers);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawText(this.textRenderer, QUEST_JOURNAL_TITLE_TEXT, this.headerText_X, this.header_Y - this.textRenderer.fontHeight - this.textMargin, this.color, false);
        //Todo: Get selected quest and adjust content with the new data.
        context.drawText(this.textRenderer, Text.translatable("Quest Name"), this.width / 3 + this.questInfoHeader_X + this.headerText_X, this.questInfoHeader_Y - this.textRenderer.fontHeight - this.textMargin, this.color, false);
        context.drawText(this.textRenderer, Text.translatable("Objectives"), this.width / 3 + this.questInfoHeader_X + this.headerText_X, this.height / 7 * 3 + this.questObjectivesHeader_Y - this.textRenderer.fontHeight - this.textMargin, this.color, false);
        context.drawHorizontalLine(0, this.width, this.header_Y, this.color);
        context.drawHorizontalLine(this.width / 3 + this.questInfoHeader_X, this.width, this.questInfoHeader_Y, this.color);
        context.drawHorizontalLine(this.width / 3 + this.questInfoHeader_X, this.width, this.height / 7 * 3 + this.questObjectivesHeader_Y, this.color);
    }

    @Override
    public void close() {
        this.client.setScreen(this.parentScreen);
    }
}