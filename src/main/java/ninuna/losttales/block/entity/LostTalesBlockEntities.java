package ninuna.losttales.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.block.ELostTalesBlocks;

public class LostTalesBlockEntities {
    public static final BlockEntityType<LostTalesBlockEntityPlushie> PLUSHIE = register("plushie", LostTalesBlockEntityPlushie::new, ELostTalesBlocks.PLUSHIE_BEAR.getBlock(), ELostTalesBlocks.PLUSHIE_FOX.getBlock());

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing block entities");
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.BlockEntityFactory<? extends T> entityFactory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(LostTales.MOD_ID, name), BlockEntityType.Builder.<T>create(entityFactory, blocks).build());
    }
}