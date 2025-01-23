package ninuna.losttales.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;
import ninuna.losttales.item.group.ELostTalesItemGroupsContents;

public enum ELostTalesItems {
    TEST_ITEM(registerItem("test_item", new Item(new Item.Settings())));

    private final Item item;

    ELostTalesItems(Item item) {
        this.item = item;
    }

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing items");
    }

    private static Item registerItem(String name, Item item) {
        ELostTalesItemGroupsContents.WEAPONS.getItems().add(item.getDefaultStack());
        return Registry.register(Registries.ITEM, Identifier.of(LostTales.MOD_ID, name), item);
    }

    public Item getItem() {
        return item;
    }
}