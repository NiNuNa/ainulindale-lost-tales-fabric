package ninuna.losttales.item.group;

import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

public enum ELostTalesItemGroupsContents {
    PLUSHIES(),
    EQUIPMENT(),
    WEAPONS();

    private final List<ItemStack> items;

    ELostTalesItemGroupsContents() {
        this.items = new LinkedList<>();
    }

    public List<ItemStack> getItems() {
        return items;
    }
}