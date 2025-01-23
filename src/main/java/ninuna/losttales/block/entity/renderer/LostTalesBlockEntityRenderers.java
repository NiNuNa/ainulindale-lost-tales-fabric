package ninuna.losttales.block.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import ninuna.losttales.LostTales;
import ninuna.losttales.block.entity.LostTalesBlockEntities;

@Environment(EnvType.CLIENT)
public class LostTalesBlockEntityRenderers {

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing block entity renderers");

        BlockEntityRendererFactories.register(LostTalesBlockEntities.PLUSHIE, LostTalesBlockEntityRendererPlushie::new);
    }
}