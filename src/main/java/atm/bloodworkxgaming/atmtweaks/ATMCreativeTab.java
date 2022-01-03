package atm.bloodworkxgaming.atmtweaks;

import atm.bloodworkxgaming.atmtweaks.items.EnumItemMaterial;
import atm.bloodworkxgaming.atmtweaks.items.ItemMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ATMCreativeTab extends CreativeTabs {
    public ATMCreativeTab() {
        super("atmtweaks");
    }

    @Override
    public ItemStack createIcon() {
        return ItemMaterial.createItemStack(EnumItemMaterial.ATM_STAR, 1);
    }
}
