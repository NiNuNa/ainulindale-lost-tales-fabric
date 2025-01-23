package ninuna.losttales.block.entity.model;

import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.block.ELostTalesBlocks;
import ninuna.losttales.block.entity.LostTalesBlockEntityPlushie;
import software.bernie.geckolib.model.GeoModel;

public class LostTalesBlockEntityModelPlushie extends GeoModel<LostTalesBlockEntityPlushie> {

    @Override
    public Identifier getModelResource(LostTalesBlockEntityPlushie lostTalesBlockEntityPlushie) {
        for (ELostTalesBlocks block : ELostTalesBlocks.values()) {
            if (lostTalesBlockEntityPlushie.getCachedState().getBlock().equals(block.getBlock())) {
                return Identifier.of(LostTales.MOD_ID, "geo/block/" + lostTalesBlockEntityPlushie.getCachedState().getBlock().getTranslationKey().substring(16) + ".geo.json");
            }
        }
        return null;
    }

    @Override
    public Identifier getTextureResource(LostTalesBlockEntityPlushie lostTalesBlockEntityPlushie) {
        for (ELostTalesBlocks block : ELostTalesBlocks.values()) {
            if (lostTalesBlockEntityPlushie.getCachedState().getBlock().equals(block.getBlock())) {
                return Identifier.of(LostTales.MOD_ID, "textures/block/" + lostTalesBlockEntityPlushie.getCachedState().getBlock().getTranslationKey().substring(16) + ".png");
            }
        }
        return null;
    }

    @Override
    public Identifier getAnimationResource(LostTalesBlockEntityPlushie lostTalesBlockEntityPlushie) {
        for (ELostTalesBlocks block : ELostTalesBlocks.values()) {
            if (lostTalesBlockEntityPlushie.getCachedState().getBlock().equals(block.getBlock())) {
                return Identifier.of(LostTales.MOD_ID, "animations/block/" + lostTalesBlockEntityPlushie.getCachedState().getBlock().getTranslationKey().substring(16) + ".animation.json");
            }
        }
        return null;
    }
}