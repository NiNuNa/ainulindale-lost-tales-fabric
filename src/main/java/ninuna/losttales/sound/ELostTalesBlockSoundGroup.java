package ninuna.losttales.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public enum ELostTalesBlockSoundGroup {
    PLUSHIE(new BlockSoundGroup(1.0F, 1.0F, SoundEvents.BLOCK_WOOL_BREAK, SoundEvents.BLOCK_WOOL_STEP, ELostTalesSoundEvents.PLUSHIE_SQUEAK.getSoundEvent(), SoundEvents.BLOCK_WOOL_HIT, SoundEvents.BLOCK_WOOL_FALL));

    private final BlockSoundGroup blockSoundGroup;

    ELostTalesBlockSoundGroup(BlockSoundGroup blockSoundGroup) {
        this.blockSoundGroup = blockSoundGroup;
    }

    public BlockSoundGroup getBlockSoundGroup() {
        return blockSoundGroup;
    }
}