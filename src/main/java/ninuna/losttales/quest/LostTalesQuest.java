package ninuna.losttales.quest;

import net.minecraft.text.MutableText;

public abstract class LostTalesQuest {
    private final int questID;
    private final MutableText questName;
    private final QuestType questType;

    public enum QuestType {
        //Main character quest
        MAIN,

        //Big lore & story quests
        STORY,

        //Faction quests
        FACTION,

        //Race quests
        RACE,

        //Side quests
        DUNGEON,
        BOUNTY,
        MISCELLANEOUS
    }

    public LostTalesQuest(int questID, MutableText questName, QuestType questType) {
        this.questID = questID;
        this.questName = questName;
        this.questType = questType;
    }

    public int getQuestID() {
        return questID;
    }

    public MutableText getQuestName() {
        return questName;
    }

    public QuestType getQuestType() {
        return questType;
    }
}