package atm.bloodworkxgaming.atmtweaks;

import atm.bloodworkxgaming.atmtweaks.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static atm.bloodworkxgaming.atmtweaks.ATMTweaks.MODID;
import static atm.bloodworkxgaming.atmtweaks.ATMTweaks.VERSION;

@EventBusSubscriber
@Mod(
        modid = MODID,
        version = VERSION,
        acceptedMinecraftVersions = "{1.12,1.13)"
)
public class ATMTweaks {
    public static final String MODID = "atmtweaks";
    public static final String VERSION = "1.1";
    public static final CreativeTabs creativeTabATM = new ATMCreativeTab();

    @SidedProxy(
            serverSide = "atm.bloodworkxgaming.atmtweaks.proxy.ServerProxy",
            clientSide = "atm.bloodworkxgaming.atmtweaks.proxy.ClientProxy"
    )
    public static CommonProxy proxy;

    @Instance("atmtweaks")
    public static ATMTweaks instance;

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerModels(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
}
