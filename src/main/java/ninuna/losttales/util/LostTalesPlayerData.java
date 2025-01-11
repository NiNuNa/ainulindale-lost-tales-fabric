package ninuna.losttales.util;

import java.util.ArrayList;
import java.util.List;

public class LostTalesPlayerData {
    public static String KEY_PLAYER_DATA = "players";
    public static String KEY_ACTIVE_QUESTS = "activeQuests";
    public static String KEY_COMPLETED_QUESTS = "completedQuests";

    public List<Integer> activeQuests = new ArrayList<Integer>();
    public List<Integer> completedQuests = new ArrayList<Integer>();
}