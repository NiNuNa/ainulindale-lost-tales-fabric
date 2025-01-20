package ninuna.losttales.screen.widget;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ElementListWidget;
import net.minecraft.text.Text;

import java.util.List;

@Environment(EnvType.CLIENT)
public class LostTalesWidgetQuestJournalQuestList extends ElementListWidget<LostTalesWidgetQuestJournalQuestList.QuestEntry> {
    private int[] questsTest = {1, 5, 2, 3, 3, 5, 2, 1, 2, 3, 2, 2, 2, 2, 2, 2, 2, 3, 4, 1};

    public LostTalesWidgetQuestJournalQuestList(MinecraftClient minecraftClient, int i, int j, int k, int l) {
        super(minecraftClient, i, j, k, l);
        for (int quest : questsTest) {
            addEntry(new QuestEntry(quest));
        }
    }

    @Override
    protected boolean isSelectedEntry(int index) {
        return true;
    }

    @Override
    protected void drawSelectionHighlight(DrawContext context, int y, int entryWidth, int entryHeight, int borderColor, int fillColor) {
        int i = this.getX() + (this.width - entryWidth) / 2;
        int j = this.getX() + (this.width + entryWidth) / 2;
        context.fill(i, y - 2, j, y + entryHeight + 2, borderColor);
        context.fill(i + 1, y - 1, j - 1, y + entryHeight + 1, fillColor);
    }

    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        setSelected(getHoveredEntry());
        super.renderWidget(context, mouseX, mouseY, delta);
    }

    @Override
    protected int getScrollbarX() {
        return - 50;
    }

    @Override
    protected void drawMenuListBackground(DrawContext context) {
    }

    @Override
    protected void drawHeaderAndFooterSeparators(DrawContext context) {
    }

    @Environment(EnvType.CLIENT)
    protected static class QuestEntry extends ElementListWidget.Entry<LostTalesWidgetQuestJournalQuestList.QuestEntry> {
        private final ButtonWidget questButton;

        public QuestEntry(int quest) {
            this.questButton = ButtonWidget.builder(Text.literal("Quest: " + quest), button -> {System.out.println("You clicked button1!");})
                    .dimensions( 0, 0, 50, 20)
                    .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                    .build();
        }

        @Override
        public List<? extends Selectable> selectableChildren() {
            return List.of(questButton);
        }

        @Override
        public List<? extends Element> children() {
            return List.of(questButton);
        }

        @Override
        public void render(DrawContext context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            questButton.setPosition(x, y);
            questButton.render(context, mouseX, mouseY, tickDelta);
        }
    }
}