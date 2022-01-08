package me.shaneyboy02.ducky.common;

import me.shaneyboy02.ducky.DuckMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DuckEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DuckMod.MODID);



    // Entity Creation
    private static <T extends Entity> EntityType<T> registerBase(EntityType.EntityFactory<T> factory, IClientSpawner<T> client, MobCategory classification, float width, float height, int trackingRange, int updateFreq, boolean sendUpdate, String name) {
        ResourceLocation loc = new ResourceLocation(DuckMod.MODID, name);
        EntityType.Builder<T> builder = EntityType.Builder.of(factory, classification);
        builder.setShouldReceiveVelocityUpdates(sendUpdate);
        builder.setTrackingRange(trackingRange);
        builder.setUpdateInterval(updateFreq);
        builder.clientTrackingRange(10);
        builder.sized(width, height);
        builder.setCustomClientFactory((spawnEntity, world) -> client.spawn(world));
        return builder.build(loc.toString());
    }

    // Fire Resistant Entity Creation
    private static <T extends Entity> EntityType<T> registerFireImmuneBase(EntityType.EntityFactory<T> factory, IClientSpawner<T> client, MobCategory classification, float width, float height, int trackingRange, int updateFreq, boolean sendUpdate, String name) {
        ResourceLocation loc = new ResourceLocation(DuckMod.MODID, name);
        EntityType.Builder<T> builder = EntityType.Builder.of(factory, classification);
        builder.setShouldReceiveVelocityUpdates(sendUpdate);
        builder.setTrackingRange(trackingRange);
        builder.setUpdateInterval(updateFreq);
        builder.fireImmune();
        builder.clientTrackingRange(10);
        builder.canSpawnFarFromPlayer();
        builder.sized(width, height);
        builder.setCustomClientFactory((spawnEntity, world) -> client.spawn(world));
        return builder.build(loc.toString());
    }

    private static <T extends Entity> EntityType<T> registerFireResistMob(EntityType.EntityFactory<T> factory, IClientSpawner<T> client, MobCategory classification, float width, float height, String name, boolean velocity) {
        return registerFireImmuneBase(factory, client, classification, width, height, 80, 2, velocity, name);
    }

    public static <T extends Entity> EntityType<T> registerStatic(EntityType.EntityFactory<T> factory, IClientSpawner<T> client, MobCategory classification, float width, float height, String name) {
        return registerBase(factory, client, classification, width, height, 64, 40, false, name);
    }

    public static <T extends Entity> EntityType<T> registerMob(EntityType.EntityFactory<T> factory, IClientSpawner<T> client, MobCategory classification, float width, float height, String name, boolean velocity) {
        return registerBase(factory, client, classification, width, height, 80, 3, velocity, name);
    }

    public interface IClientSpawner<T> {
        T spawn(Level world);
    }

}
