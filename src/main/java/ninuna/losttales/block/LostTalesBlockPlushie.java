package ninuna.losttales.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import ninuna.losttales.block.entity.LostTalesBlockEntityPlushie;
import org.jetbrains.annotations.Nullable;

public class LostTalesBlockPlushie extends BlockWithEntity {

    protected LostTalesBlockPlushie(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(LostTalesBlockPlushie::new);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LostTalesBlockEntityPlushie(pos, state);
    }
}