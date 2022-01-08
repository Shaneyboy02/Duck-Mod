package me.shaneyboy02.ducky;

import me.shaneyboy02.ducky.client.models.DuckModels;
import me.shaneyboy02.ducky.common.DuckEntities;
import me.shaneyboy02.ducky.common.DuckItems;
import me.shaneyboy02.ducky.data.EnglishLang;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("quack_duck")
public class DuckMod {

    public static final String MODID = "quack_duck";
    private static final Logger LOGGER = LogManager.getLogger();

    public DuckMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onNewRegistries(RegistryEvent.NewRegistry e) {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        DuckItems.ITEMS.register(bus);
        DuckEntities.ENTITIES.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void regModels(EntityRenderersEvent.RegisterLayerDefinitions definitions) {
        DuckModels.init(definitions);
    }

    @SubscribeEvent
    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        generator.addProvider(new EnglishLang(generator));
    }
}
