package ninuna.losttales.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import ninuna.losttales.LostTales;
import ninuna.losttales.screen.LostTalesScreenQuestJournal;
import org.lwjgl.glfw.GLFW;

public class LostTalesKeyInputHandler {
    public static final String KEY_CATEGORY_LOSTTALES = "key.category.losttales.losttales";
    public static final String KEY_QUEST_JOURNAL = "key.losttales.quest.journal";

    public static KeyBinding questJournalKey;

    public LostTalesKeyInputHandler() {
    }

    public static void registerKeyBinds() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": registering keybinds");

        questJournalKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_QUEST_JOURNAL, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_J, KEY_CATEGORY_LOSTTALES));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (questJournalKey.wasPressed()) {
                client.setScreen(new LostTalesScreenQuestJournal(client.currentScreen));
            }
        });
    }
}