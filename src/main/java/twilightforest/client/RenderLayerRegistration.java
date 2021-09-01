package twilightforest.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import twilightforest.block.TFBlocks;

public class RenderLayerRegistration {
	public static void init() {
		RenderType cutoutMipped = RenderType.cutoutMipped();
		RenderType cutout = RenderType.cutout();
		RenderType translucent = RenderType.translucent();
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.oak_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.rainboak_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.canopy_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mangrove_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.time_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.transformation_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mining_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.sorting_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.time_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.sort_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.time_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.sort_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.twilight_portal.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.auroralized_glass.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.thorn_rose.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.fiery_block.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.thorn_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.beanstalk_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.giant_leaves.get(), cutoutMipped);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.experiment_115.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.wispy_cloud.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.uberous_soil.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.trollvidr.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.unripe_trollber.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.trollber.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.huge_lilypad.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.huge_waterlily.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_rune_brick_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_rune_brick_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_rune_brick_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_rune_brick_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_door_yellow.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_door_purple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_door_pink.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.castle_door_blue.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.green_thorns.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.brown_thorns.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.burnt_thorns.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.twilight_portal_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.hedge_maze_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.hollow_hill_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.quest_grove_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.mushroom_tower_miniature_structure.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.naga_courtyard_miniature_structure.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.lich_tower_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.minotaur_labyrinth_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.hydra_lair_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.goblin_stronghold_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.dark_tower_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.yeti_cave_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.aurora_palace_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.troll_cave_cottage_miniature_structure.get(), cutout);
//		RenderTypeLookup.setRenderLayer(TFBlocks.final_castle_miniature_structure.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.trophy_pedestal.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.stone_twist_thin.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.fiery_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.firefly_jar.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.firefly_spawner.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.cicada_jar.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.moss_patch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mayapple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.clover_patch.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.fiddlehead.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mushgloom.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.torchberry_plant.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.root_strand.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.fallen_leaves.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.uncrafting_table.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.encased_smoker.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.encased_fire_jet.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.oak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.rainboak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.canopy_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mangrove_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.darkwood_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.hollow_oak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.time_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.transformation_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.mining_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.sorting_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.built_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.antibuilt_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.reactor_debris.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.force_field_pink.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.force_field_blue.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.force_field_green.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.force_field_purple.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.force_field_orange.get(), translucent);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_naga.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_lich.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_hydra.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_ur_ghast.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_knight_phantom.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_snow_queen.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_minoshroom.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_alpha_yeti.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.boss_spawner_final_boss.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.reappearing_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.locked_vanishing_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.vanishing_block.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.carminite_builder.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.antibuilder.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.carminite_reactor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.ghast_trap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_twilight_oak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_canopy_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_mangrove_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_darkwood_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_hollow_oak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_rainboak_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_time_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_trans_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_mine_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_sort_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_mayapple.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_fiddlehead.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_mushgloom.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_thorn.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_green_thorn.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(TFBlocks.potted_dead_thorn.get(), cutout);
	}
}
