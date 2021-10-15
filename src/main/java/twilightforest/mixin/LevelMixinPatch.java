package twilightforest.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import twilightforest.ASMHooks;

import java.util.List;
import java.util.function.Predicate;

@Mixin(Level.class)
public class LevelMixinPatch {

    @Unique
    private Entity entityCached;
    @Unique
    private AABB areaCached;
    @Unique
    private Predicate<? super Entity> predicateCached;

    @Inject(method = "getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;", at=@At("HEAD"))
    public void multiPartGetEntities(Entity entity, AABB area, Predicate<? super Entity> predicate, CallbackInfoReturnable<List<Entity>> cir){
        entityCached = entity;
        areaCached = area;
        predicateCached = predicate;
        //(TargetClass) (Object) this)
    }

    @ModifyVariable(method = "getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;", at=@At("RETURN"))
    public List<Entity> multipartHitbox(List<Entity> list){
        return ASMHooks.multipartHitbox(list, ((Level) (Object) this), entityCached, areaCached, predicateCached);
    }

}
