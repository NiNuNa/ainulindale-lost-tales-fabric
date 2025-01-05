package ninuna.losttales.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;

public class LostTalesItems {
    public static final Item TEST_ITEM = registerItem("test_item", new Item(new Item.Settings()));

    public static void registerItems() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": registering items");
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LostTales.MOD_ID, name), item);
    }
}