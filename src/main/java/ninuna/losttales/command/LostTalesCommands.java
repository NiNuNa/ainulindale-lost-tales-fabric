package ninuna.losttales.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import ninuna.losttales.LostTales;

public class LostTalesCommands {

    public static void initialize(){
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing commands");

        CommandRegistrationCallback.EVENT.register(LostTalesCommandTest::register);
        CommandRegistrationCallback.EVENT.register(LostTalesCommandQuest::register);
    }
}