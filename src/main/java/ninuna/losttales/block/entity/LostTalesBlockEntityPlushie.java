package ninuna.losttales.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LostTalesBlockEntityPlushie extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean squeaked = false;

    public LostTalesBlockEntityPlushie(BlockPos pos, BlockState state) {
        super(LostTalesBlockEntities.PLUSHIE, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, this::deployAnimController));
    }

    protected <E extends LostTalesBlockEntityPlushie> PlayState deployAnimController(final AnimationState<E> state) {
        if (this.isSqueaked()) {
            this.setSqueaked(false);
            state.resetCurrentAnimation();
            return state.setAndContinue(RawAnimation.begin().thenPlay("squeak"));
        } else {
            return PlayState.CONTINUE;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public boolean isSqueaked() {
        return squeaked;
    }

    public void setSqueaked(boolean squeaked) {
        this.squeaked = squeaked;
        this.markDirty();
    }

    public void playSqueakAnimation() {
        this.setSqueaked(true);
    }
}