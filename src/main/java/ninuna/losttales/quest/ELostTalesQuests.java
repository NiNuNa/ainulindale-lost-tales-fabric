package ninuna.losttales.quest;

import net.minecraft.text.Text;
import ninuna.losttales.LostTales;

import java.util.HashMap;

public enum ELostTalesQuests {
    QUEST_AWAKENING(new LostTalesQuestMain(0, Text.translatable("quest.losttales.main.awakening.name"), LostTalesQuest.QuestType.MAIN));

    private final static HashMap<Integer, LostTalesQuest> quests = new HashMap<Integer, LostTalesQuest>();
    private final LostTalesQuest quest;


    ELostTalesQuests(LostTalesQuest quest) {
        this.quest = quest;
    }

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing quests");

        for (ELostTalesQuests q : ELostTalesQuests.values()) {
            quests.put(q.getQuest().getQuestID(), q.getQuest());
        }
    }

    public LostTalesQuest getQuest() {
        return quest;
    }

    public static HashMap<Integer, LostTalesQuest> getQuests() {
        return quests;
    }
}