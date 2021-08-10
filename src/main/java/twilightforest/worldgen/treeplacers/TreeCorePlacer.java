package twilightforest.worldgen.treeplacers;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import twilightforest.worldgen.TwilightFeatures;

public class TreeCorePlacer extends TreeDecorator {

	public static final Codec<TreeCorePlacer> CODEC = RecordCodecBuilder.create(
	        instance -> instance.group(
	                Codec.intRange(0, 20).fieldOf("core_position").forGetter(o -> o.corePos),
	                BlockStateProvider.CODEC.fieldOf("deco_provider").forGetter(o -> o.core)
	        ).apply(instance, TreeCorePlacer::new));

	private final int corePos;
	private final BlockStateProvider core;

	public TreeCorePlacer(int corePos, BlockStateProvider core) {
		this.corePos = corePos;
		this.core = core;
	}

	@Override
	protected TreeDecoratorType<TreeCorePlacer> type() {
		return TwilightFeatures.CORE_PLACER;
	}

	@Override
	public void place(LevelSimulatedReader worldReader, BiConsumer<BlockPos, BlockState> worldPlacer, Random random, List<BlockPos> trunkBlocks, List<BlockPos> leafBlocks) {
		BlockPos pos = trunkBlocks.get(0);
		BlockPos position = pos.offset(0, this.corePos, 0);
		worldPlacer.accept(pos, this.core.getState(random, position));
	}
}
