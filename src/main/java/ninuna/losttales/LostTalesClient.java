package ninuna.losttales;

import net.fabricmc.api.ClientModInitializer;
import ninuna.losttales.block.entity.renderer.LostTalesBlockEntityRenderers;
import ninuna.losttales.util.LostTalesKeyInputHandler;

public class LostTalesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LostTalesKeyInputHandler.initialize();
        LostTalesBlockEntityRenderers.initialize();
    }
}