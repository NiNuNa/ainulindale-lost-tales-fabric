package ninuna.losttales.quest;

public abstract class LostTalesQuest {
    private final int questID;
    private final String questName;

    public LostTalesQuest(int questID, String questName) {
        this.questID = questID;
        this.questName = questName;
    }

    public int getQuestID() {
        return questID;
    }

    public String getQuestName() {
        return questName;
    }
}