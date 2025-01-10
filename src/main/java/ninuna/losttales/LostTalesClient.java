package ninuna.losttales;

import net.fabricmc.api.ClientModInitializer;
import ninuna.losttales.event.LostTalesKeyInputHandler;

public class LostTalesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LostTalesKeyInputHandler.registerKeyBinds();
    }
}