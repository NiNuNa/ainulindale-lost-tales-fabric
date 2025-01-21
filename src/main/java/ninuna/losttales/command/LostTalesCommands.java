package ninuna.losttales.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import ninuna.losttales.LostTales;

public class LostTalesCommands {

    public static void registerCommands(){
        LostTales.LOGGER.info(LostTales.MOD_ID + ": registering commands");

        CommandRegistrationCallback.EVENT.register(LostTalesCommandTest::register);
        CommandRegistrationCallback.EVENT.register(LostTalesCommandQuest::register);
    }
}