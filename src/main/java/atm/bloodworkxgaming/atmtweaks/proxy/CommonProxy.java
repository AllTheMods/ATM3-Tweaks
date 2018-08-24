package atm.bloodworkxgaming.atmtweaks.proxy;

import atm.bloodworkxgaming.atmtweaks.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public abstract class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        ModItems.registerItems(event.getRegistry());
    }

    @SubscribeEvent
    public static void onRecipeRegistry(Register<IRecipe> e) {
    }

    public void registerModels(ModelRegistryEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
