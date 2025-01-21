package ninuna.losttales.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LostTalesBlockEntityPlushie extends BlockEntity {
    public LostTalesBlockEntityPlushie(BlockPos pos, BlockState state) {
        super(LostTalesBlockEntities.PLUSHIE, pos, state);
    }
}