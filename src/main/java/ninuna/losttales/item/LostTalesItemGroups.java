package ninuna.losttales.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;

public class LostTalesItemGroups {

    public static final ItemGroup COMBAT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LostTales.MOD_ID, "combat"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.BELL))
                    .displayName(Text.translatable("itemgroup.losttales.combat"))
                    .entries((displayContext, entries) -> {
                        entries.add(LostTalesItems.TEST_ITEM);
                    }).build());


    public static void registerItemGroups() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": registering item groups");
    }
}