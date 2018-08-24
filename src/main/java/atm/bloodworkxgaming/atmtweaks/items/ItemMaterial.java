package atm.bloodworkxgaming.atmtweaks.items;

import atm.bloodworkxgaming.atmtweaks.ATMTweaks;
import atm.bloodworkxgaming.atmtweaks.ModItems;
import atm.bloodworkxgaming.atmtweaks.util.Data;
import atm.bloodworkxgaming.atmtweaks.util.IHasModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemMaterial extends Item implements IHasModel {
    public ItemMaterial() {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("item_material");
        this.setRegistryName("item_material");
        this.setCreativeTab(ATMTweaks.creativeTabATM);
        Data.ITEMS.add(this);
    }

    public static ItemStack createItemStack(EnumItemMaterial enumItemMaterial, int count) {
        return new ItemStack(ModItems.itemMaterial, count, enumItemMaterial.getMeta());
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumItemMaterial.getFromMeta(stack.getMetadata()).getName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            EnumItemMaterial[] values = EnumItemMaterial.values();

            for (int i = 1; i < values.length; ++i) {
                list.add(new ItemStack(this, 1, values[i].getMeta()));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel(ModelRegistryEvent e) {
        for (EnumItemMaterial enumItemMaterial : EnumItemMaterial.values()) {
            String variant = "type=" + enumItemMaterial.getName();
            ModelLoader.setCustomModelResourceLocation(this, enumItemMaterial.getMeta(), new ModelResourceLocation(this.getRegistryName(), variant));
        }
    }

    public int getItemStackLimit(ItemStack stack) {
        return EnumItemMaterial.getFromMeta(stack.getMetadata()).getStackSize();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return EnumItemMaterial.getFromMeta(stack.getMetadata()).hasEffectGlow() || super.hasEffect(stack);
    }
}
