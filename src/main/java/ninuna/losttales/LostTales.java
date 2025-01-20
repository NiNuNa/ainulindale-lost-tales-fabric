package ninuna.losttales;

import net.fabricmc.api.ModInitializer;

import ninuna.losttales.command.LostTalesCommands;
import ninuna.losttales.item.LostTalesItemGroups;
import ninuna.losttales.item.LostTalesItems;
import ninuna.losttales.quest.ELostTalesQuests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostTales implements ModInitializer {
	public static final String MOD_ID = "losttales";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + ": initialising mod");

		ELostTalesQuests.registerQuests();
		LostTalesCommands.registerCommands();
		LostTalesItemGroups.registerItemGroups();
		LostTalesItems.registerItems();
	}
}