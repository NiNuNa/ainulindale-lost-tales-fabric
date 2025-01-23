package ninuna.losttales.item.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.block.ELostTalesBlocks;
import ninuna.losttales.item.ELostTalesItems;

public enum ELostTalesItemGroups {
    PLUSHIES("plushies", new ItemStack(ELostTalesItems.TEST_ITEM.getItem()), ELostTalesItemGroupsContents.PLUSHIES),
    EQUIPMENT("equipment", new ItemStack(ELostTalesItems.TEST_ITEM.getItem()), ELostTalesItemGroupsContents.EQUIPMENT),
    WEAPONS("weapons", new ItemStack(ELostTalesBlocks.PLUSHIE_FOX.getBlock().asItem()), ELostTalesItemGroupsContents.WEAPONS);

    ELostTalesItemGroups(String name, ItemStack icon, ELostTalesItemGroupsContents itemGroupsContents) {
        this.registerItemGroup(name, icon, itemGroupsContents);
    }

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing item groups");
    }

    private void registerItemGroup(String name, ItemStack icon, ELostTalesItemGroupsContents itemGroupsContents) {
        ItemGroup group = FabricItemGroup.builder().displayName(Text.translatable("itemgroup." + LostTales.MOD_ID + "." + name)).icon(() -> icon).entries((displayContext, entries) -> {
            for(ItemStack item : itemGroupsContents.getItems()) {
                entries.add(item);
            }
        }).build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of(LostTales.MOD_ID, name), group);
    }
}