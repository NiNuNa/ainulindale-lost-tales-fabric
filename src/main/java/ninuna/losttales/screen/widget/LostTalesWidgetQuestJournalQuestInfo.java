package ninuna.losttales.screen.widget;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ScrollableTextWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class LostTalesWidgetQuestJournalQuestInfo extends ScrollableTextWidget {
    public LostTalesWidgetQuestJournalQuestInfo(int x, int y, int width, int height, Text message, TextRenderer textRenderer) {
        super(x, y, width, height, message, textRenderer);
    }

    @Override
    protected void drawBox(DrawContext context) {
    }
}