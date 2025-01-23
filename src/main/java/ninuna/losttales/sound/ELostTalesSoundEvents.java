package ninuna.losttales.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import ninuna.losttales.LostTales;

public enum ELostTalesSoundEvents {
    PLUSHIE_SQUEAK(registerSoundEvent("plushie_squeak"));

    private final SoundEvent soundEvent;

    ELostTalesSoundEvents(SoundEvent soundEvent) {
        this.soundEvent = soundEvent;
    }

    public static void initialize() {
        LostTales.LOGGER.info(LostTales.MOD_ID + ": initializing sound events");
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = Identifier.of(LostTales.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }
}