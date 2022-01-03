package atm.bloodworkxgaming.atmtweaks;

import atm.bloodworkxgaming.atmtweaks.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static atm.bloodworkxgaming.atmtweaks.ATMTweaks.MODID;
import static atm.bloodworkxgaming.atmtweaks.ATMTweaks.VERSION;

@EventBusSubscriber
@Mod(modid = MODID, version = VERSION, acceptedMinecraftVersions = "{1.12,1.13)")
public class ATMTweaks {
    public static final String MODID = "atmtweaks";
    public static final String VERSION = "1.2";
    public static final CreativeTabs creativeTabATM = new ATMCreativeTab();

    @SidedProxy(serverSide = "atm.bloodworkxgaming.atmtweaks.proxy.ServerProxy", clientSide = "atm.bloodworkxgaming.atmtweaks.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static ATMTweaks instance;

    static {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList("CONNECT", "PATCH"));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerModels(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
}
