package ninuna.losttales;

import net.fabricmc.api.ModInitializer;

import ninuna.losttales.block.ELostTalesBlocks;
import ninuna.losttales.block.entity.LostTalesBlockEntities;
import ninuna.losttales.command.LostTalesCommands;
import ninuna.losttales.item.group.ELostTalesItemGroups;
import ninuna.losttales.item.ELostTalesItems;
import ninuna.losttales.quest.ELostTalesQuests;
import ninuna.losttales.sound.ELostTalesSoundEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostTales implements ModInitializer {
	public static final String MOD_ID = "losttales";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + ": initializing mod");

		ELostTalesItemGroups.initialize();
		// ELostTalesQuests.initialize();
		// LostTalesCommands.initialize();
		ELostTalesItems.initialize();
		ELostTalesBlocks.initialize();
		LostTalesBlockEntities.initialize();
		ELostTalesSoundEvents.initialize();
	}
}