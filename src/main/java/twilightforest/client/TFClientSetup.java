package twilightforest.client;

import com.google.common.collect.Maps;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.impl.resource.loader.FabricModResourcePack;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import shadow.fabric.api.client.rendering.v1.ArmorRenderingRegistry;
import twilightforest.ASMHooks;
import twilightforest.TFConstants;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.block.entity.TFBlockEntities;
import twilightforest.client.model.TFLayerDefinitions;
import twilightforest.client.model.TFModelLayers;
import twilightforest.client.particle.TFParticleType;
import twilightforest.client.providers.*;
import twilightforest.client.shader.ShaderManager;
import twilightforest.compat.clothConfig.TFClientConfigEvent;
import twilightforest.compat.clothConfig.configFiles.TFConfig;
import twilightforest.compat.clothConfig.configFiles.TFConfigClient;
import twilightforest.dispenser.CrumbleDispenseBehavior;
import twilightforest.dispenser.FeatherFanDispenseBehavior;
import twilightforest.dispenser.MoonwormDispenseBehavior;
import twilightforest.dispenser.TransformationDispenseBehavior;
import twilightforest.entity.TFEntities;
import twilightforest.entity.projectile.MoonwormShot;
import twilightforest.entity.projectile.TwilightWandBolt;
import twilightforest.inventory.TFContainers;
import twilightforest.item.TFItems;
import twilightforest.network.TFPacketHandler;

import java.lang.reflect.Field;

@Environment(EnvType.CLIENT)
public class TFClientSetup implements ClientModInitializer {

	public static boolean optifinePresent = false;

    protected static boolean optifineWarningShown = false;

	public static TFConfigClient CLIENT_CONFIG;

    public static void clientConfigInit(){
        CLIENT_CONFIG = AutoConfig.getConfigHolder(TFConfig.class).getConfig().tfConfigClient;
    }

    @Environment(EnvType.CLIENT)
	@Override
	public void onInitializeClient() {
        TwilightForestMod.LOGGER.debug(FabricLoader.getInstance().isModLoaded("optifabric") + ": Optifine loaded?");
        if(FabricLoader.getInstance().isModLoaded("optifabric"))
            optifinePresent = true;

        FabricClientEvents();
        FabricRenderingCalls();
        //TODO: Currently only work's in Dev Environment
        //TFClientSetup.addLegacyPack();
		TFItems.addItemModelProperties();

        ScreenEvents.BEFORE_INIT.register(((client, screen, scaledWidth, scaledHeight) -> LoadingScreenListener.onOpenGui(screen))); //MinecraftForge.EVENT_BUS.register(new LoadingScreenListener());
        RenderLayerRegistration.init();
		TFBlockEntities.registerTileEntityRenders();
        TFContainers.renderScreens();

        TwilightForestRenderInfo renderInfo = new TwilightForestRenderInfo(128.0F, false, DimensionSpecialEffects.SkyType.NONE, false, false);
        DimensionSpecialEffects.EFFECTS.put(TwilightForestMod.prefix("renderer"), renderInfo);

        Minecraft.getInstance().execute(() -> {
            Sheets.SIGN_MATERIALS.put(TFBlocks.TWILIGHT_OAK, Sheets.createSignMaterial(TFBlocks.TWILIGHT_OAK));
            Sheets.SIGN_MATERIALS.put(TFBlocks.CANOPY, Sheets.createSignMaterial(TFBlocks.CANOPY));
            Sheets.SIGN_MATERIALS.put(TFBlocks.MANGROVE, Sheets.createSignMaterial(TFBlocks.MANGROVE));
            Sheets.SIGN_MATERIALS.put(TFBlocks.DARKWOOD, Sheets.createSignMaterial(TFBlocks.DARKWOOD));
            Sheets.SIGN_MATERIALS.put(TFBlocks.TIMEWOOD, Sheets.createSignMaterial(TFBlocks.TIMEWOOD));
            Sheets.SIGN_MATERIALS.put(TFBlocks.TRANSFORMATION, Sheets.createSignMaterial(TFBlocks.TRANSFORMATION));
            Sheets.SIGN_MATERIALS.put(TFBlocks.MINING, Sheets.createSignMaterial(TFBlocks.MINING));
            Sheets.SIGN_MATERIALS.put(TFBlocks.SORTING, Sheets.createSignMaterial(TFBlocks.SORTING));
        });

        armorRegistry();
    }

    public static void addLegacyPack() {
        //noinspection ConstantConditions
        if (Minecraft.getInstance() == null)
            // Normally Minecraft Client is never null except when generating through runData
            return;

        Minecraft.getInstance().getResourcePackRepository().sources.add(
                (consumer, iFactory) -> consumer.accept(
                        Pack.create(
                                TwilightForestMod.prefix("classic_textures").toString(),
                                false,
                                () -> new TwilightLegacyPack(
                                        FabricLoader
                                                .getInstance()
                                                .getModContainer(TFConstants.ID)
                                                .get()
                                ),
                                iFactory,
                                Pack.Position.TOP,
								PackSource.BUILT_IN
                        )
                )
        );
    }

	private static Field field_EntityRenderersEvent$AddLayers_renderers;

//	@SuppressWarnings("unchecked")
//	public static void attachRenderLayers(EntityRenderersEvent.AddLayers event) {
//		if (field_EntityRenderersEvent$AddLayers_renderers == null) {
//			try {
//				field_EntityRenderersEvent$AddLayers_renderers = EntityRenderersEvent.AddLayers.class.getDeclaredField("renderers");
//				field_EntityRenderersEvent$AddLayers_renderers.setAccessible(true);
//			} catch (NoSuchFieldException e) {
//				e.printStackTrace();
//			}
//		}
//		if (field_EntityRenderersEvent$AddLayers_renderers != null) {
//			event.getSkins().forEach(renderer -> {
//				LivingEntityRenderer<Player, EntityModel<Player>> skin = event.getSkin(renderer);
//				attachRenderLayers(Objects.requireNonNull(skin));
//			});
//			try {
//				((Map<EntityType<?>, EntityRenderer<?>>) field_EntityRenderersEvent$AddLayers_renderers.get(event)).values().stream().
//						filter(LivingEntityRenderer.class::isInstance).map(LivingEntityRenderer.class::cast).forEach(TFClientSetup::attachRenderLayers);
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	private static <T extends LivingEntity, M extends EntityModel<T>> void attachRenderLayers(LivingEntityRenderer<T, M> renderer) {
//		renderer.addLayer(new ShieldLayer<>(renderer));
//		renderer.addLayer(new IceLayer<>(renderer));
	}

    @Environment(EnvType.CLIENT)
    public static void armorRegistry() {
        ArcticArmorProvider arcticArmorProvider = new ArcticArmorProvider();
        ArmorRenderingRegistry.registerModel(arcticArmorProvider, TFItems.ARCTIC_BOOTS, TFItems.ARCTIC_LEGGINGS, TFItems.ARCTIC_CHESTPLATE, TFItems.ARCTIC_HELMET);
        ArmorRenderingRegistry.registerTexture(arcticArmorProvider, TFItems.ARCTIC_BOOTS, TFItems.ARCTIC_LEGGINGS, TFItems.ARCTIC_CHESTPLATE, TFItems.ARCTIC_HELMET);

        FieryArmorProvider fieryArmorProvider = new FieryArmorProvider();
        ArmorRenderingRegistry.registerModel(fieryArmorProvider, TFItems.FIERY_BOOTS, TFItems.FIERY_LEGGINGS, TFItems.FIERY_CHESTPLATE, TFItems.FIERY_HELMET);
        ArmorRenderingRegistry.registerTexture(fieryArmorProvider, TFItems.FIERY_BOOTS, TFItems.FIERY_LEGGINGS, TFItems.FIERY_CHESTPLATE, TFItems.FIERY_HELMET);

        KnightArmorProvider knightArmorProvider = new KnightArmorProvider();
        ArmorRenderingRegistry.registerModel(knightArmorProvider, TFItems.KNIGHTMETAL_BOOTS, TFItems.KNIGHTMETAL_LEGGINGS, TFItems.KNIGHTMETAL_CHESTPLATE, TFItems.KNIGHTMETAL_HELMET);
        ArmorRenderingRegistry.registerTexture(knightArmorProvider, TFItems.KNIGHTMETAL_BOOTS, TFItems.KNIGHTMETAL_LEGGINGS, TFItems.KNIGHTMETAL_CHESTPLATE, TFItems.KNIGHTMETAL_HELMET);

        PhantomArmorProvider phantomArmorProvider = new PhantomArmorProvider();
        ArmorRenderingRegistry.registerModel(phantomArmorProvider, TFItems.PHANTOM_HELMET, TFItems.PHANTOM_CHESTPLATE);
        ArmorRenderingRegistry.registerTexture(phantomArmorProvider, TFItems.PHANTOM_HELMET, TFItems.PHANTOM_CHESTPLATE);

        YetiArmorProvider yetiArmorProvider = new YetiArmorProvider();
        ArmorRenderingRegistry.registerModel( yetiArmorProvider, TFItems.YETI_BOOTS, TFItems.YETI_LEGGINGS, TFItems.YETI_CHESTPLATE, TFItems.YETI_HELMET);
        ArmorRenderingRegistry.registerTexture(yetiArmorProvider, TFItems.YETI_BOOTS, TFItems.YETI_LEGGINGS, TFItems.YETI_CHESTPLATE, TFItems.YETI_HELMET);

        ArmorRenderingRegistry.registerTexture(new NagaArmorProvider(), TFItems.NAGA_CHESTPLATE, TFItems.NAGA_LEGGINGS);

        ArmorRenderingRegistry.registerTexture(new IronwoodArmorProvider(), TFItems.STEELEAF_BOOTS, TFItems.STEELEAF_LEGGINGS, TFItems.STEELEAF_CHESTPLATE, TFItems.STEELEAF_HELMET);

        ArmorRenderingRegistry.registerTexture(new SteeleafArmorProvider(), TFItems.STEELEAF_BOOTS, TFItems.STEELEAF_LEGGINGS, TFItems.STEELEAF_CHESTPLATE, TFItems.STEELEAF_HELMET);
    }

    private static void FabricClientEvents(){
        TFClientConfigEvent.init();

        ASMHooks.registerMultipartEvents();
        TFPacketHandler.CHANNEL.initClient();
    }

    private static void FabricRenderingCalls() {
        TFClientEvents.registerFabricEvents();
        TFLayerDefinitions.registerLayers();
        TFModelLayers.init();
        TFClientEvents.registerModels();
        TFEntities.registerEntityRenderer();
        TFParticleType.registerFactories();
    }

}
