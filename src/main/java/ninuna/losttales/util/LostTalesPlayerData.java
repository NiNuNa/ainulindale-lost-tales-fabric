package ninuna.losttales.util;

import java.util.ArrayList;
import java.util.List;

public class LostTalesPlayerData {
    public static String NBT_KEY_PLAYER_DATA = "players";
    public static String NBT_KEY_ACTIVE_QUESTS = "activeQuests";
    public static String NBT_KEY_COMPLETED_QUESTS = "completedQuests";

    public List<Integer> activeQuests = new ArrayList<>();
    public List<Integer> completedQuests = new ArrayList<>();
}