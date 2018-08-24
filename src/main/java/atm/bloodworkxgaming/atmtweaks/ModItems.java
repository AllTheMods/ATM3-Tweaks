//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package atm.bloodworkxgaming.atmtweaks;

import atm.bloodworkxgaming.atmtweaks.items.ItemMaterial;
import atm.bloodworkxgaming.atmtweaks.util.Data;
import atm.bloodworkxgaming.atmtweaks.util.IHasModel;
import atm.bloodworkxgaming.atmtweaks.util.IHasSpecialRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static final ItemMaterial itemMaterial = new ItemMaterial();

    public static void registerItems(IForgeRegistry<Item> registry) {
        for (Item item : Data.ITEMS) {
            if (!(item instanceof IHasSpecialRegistry)) {
                registry.register(item);
            }
        }

        for (Block block : Data.BLOCKS) {
            if (!(block instanceof IHasSpecialRegistry)) {
                registry.register((new ItemBlock(block)).setRegistryName(block.getRegistryName()));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(ModelRegistryEvent e) {
        for (Item item : Data.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).initModel(e);
            }
        }
    }
}
