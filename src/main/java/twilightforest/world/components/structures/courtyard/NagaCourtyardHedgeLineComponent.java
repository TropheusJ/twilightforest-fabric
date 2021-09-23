package twilightforest.world.components.structures.courtyard;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Rotation;
import twilightforest.TFConstants;
import twilightforest.world.registration.TFFeature;

public class NagaCourtyardHedgeLineComponent extends NagaCourtyardHedgeAbstractComponent {
    public NagaCourtyardHedgeLineComponent(ServerLevel level, CompoundTag nbt) {
        super(level, NagaCourtyardPieces.TFNCLn, nbt, new ResourceLocation(TFConstants.ID, "courtyard/hedge_line"), new ResourceLocation(TFConstants.ID, "courtyard/hedge_line_big"));
    }

    public NagaCourtyardHedgeLineComponent(TFFeature feature, int i, int x, int y, int z, Rotation rotation) {
        super(NagaCourtyardPieces.TFNCLn, feature, i, x, y, z, rotation, new ResourceLocation(TFConstants.ID, "courtyard/hedge_line"), new ResourceLocation(TFConstants.ID, "courtyard/hedge_line_big"));
    }
}
