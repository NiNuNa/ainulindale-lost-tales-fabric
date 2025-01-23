package ninuna.losttales.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.item.group.ELostTalesItemGroupsContents;
import ninuna.losttales.item.LostTalesItemPlushie;
import ninuna.losttales.sound.ELostTalesBlockSoundGroup;

public enum ELostTalesBlocks {
    //  BlocksWithEntity - Plushies.
    PLUSHIE_BEAR(registerBlockPlushie("plushie_bear", new LostTalesBlockPlushie(AbstractBlock.Settings.create().nonOpaque().sounds(ELostTalesBlockSoundGroup.PLUSHIE.getBlockSoundGroup())))),
    PLUSHIE_FOX(registerBlockPlushie("plushie_fox", new LostTalesBlockPlushie(AbstractBlock.Settings.copy(PLUSHIE_BEAR.getBlock()))));

    private final Block block;

    ELostTalesBlocks(Block block) {
        this.block = block;
    }

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing blocks");
    }

    private static Block registerBlockPlushie(String name, Block block) {
        registerBlockItemPlushie(name, block);
        ELostTalesItemGroupsContents.PLUSHIES.getItems().add(block.asItem().getDefaultStack());
        return Registry.register(Registries.BLOCK, Identifier.of(LostTales.MOD_ID, name), block);
    }

    private static void registerBlockItemPlushie(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LostTales.MOD_ID, name), new LostTalesItemPlushie(block, new Item.Settings().maxCount(1)));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LostTales.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public Block getBlock() {
        return block;
    }
}