package ninuna.losttales.quest;

import ninuna.losttales.LostTales;

import java.util.HashMap;

public abstract class LostTalesQuests {
    public static HashMap<Integer, LostTalesQuest> quests = new HashMap<Integer, LostTalesQuest>();
    public static LostTalesQuest TEST_QUEST;

    private LostTalesQuests() {
    }

    public static void registerQuests() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": registering quests");
    }
}