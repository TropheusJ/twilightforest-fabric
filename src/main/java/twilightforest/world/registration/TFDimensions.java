package twilightforest.world.registration;

import net.minecraft.core.Registry;
import twilightforest.TwilightForestMod;
import twilightforest.world.components.biomesources.LandmarkBiomeSource;
import twilightforest.world.components.chunkgenerators.ChunkGeneratorTwilight;

public class TFDimensions {
	// Use TFGenerationSettings.usesTwilightChunkGenerator or TFGenerationSettings.isTwilightWorldOnClient instead of hard-comparing the dimension ID
	//public static final RegistryKey<World> twilightForest = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(TFConfig.COMMON_CONFIG.DIMENSION.twilightForestID.get()));
	public static long seed;

	public static void init() {
//		Registry.register(Registry.BIOME_SOURCE, TwilightForestMod.prefix("landmarks"), LandmarkBiomeSource.CODEC);
//
//		Registry.register(Registry.CHUNK_GENERATOR, TwilightForestMod.prefix("structure_locating_wrapper"), ChunkGeneratorTwilight.CODEC);
	}
}
