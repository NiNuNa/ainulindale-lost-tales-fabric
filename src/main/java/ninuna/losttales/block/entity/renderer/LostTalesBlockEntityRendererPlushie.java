package ninuna.losttales.block.entity.renderer;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import ninuna.losttales.block.entity.LostTalesBlockEntityPlushie;
import ninuna.losttales.block.entity.model.LostTalesBlockEntityModelPlushie;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LostTalesBlockEntityRendererPlushie extends GeoBlockRenderer<LostTalesBlockEntityPlushie> {
    public LostTalesBlockEntityRendererPlushie(BlockEntityRendererFactory.Context context) {
        super(new LostTalesBlockEntityModelPlushie());
    }
}