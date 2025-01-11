package ninuna.losttales.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import ninuna.losttales.LostTales;

import java.util.HashMap;
import java.util.UUID;

public class LostTalesStateSaverAndLoader extends PersistentState {
    public HashMap<UUID, LostTalesPlayerData> players = new HashMap<>();
    private static final Type<LostTalesStateSaverAndLoader> type = new Type<>(LostTalesStateSaverAndLoader::new, LostTalesStateSaverAndLoader::createFromNbt, null);

    public LostTalesStateSaverAndLoader() {
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound playersNbt = new NbtCompound();
        players.forEach((uuid, playerData) -> {
            NbtCompound playerNbt = new NbtCompound();

            playerNbt.putIntArray(LostTalesPlayerData.KEY_ACTIVE_QUESTS, playerData.activeQuests);
            playerNbt.putIntArray(LostTalesPlayerData.KEY_COMPLETED_QUESTS, playerData.completedQuests);

            playersNbt.put(uuid.toString(), playerNbt);
        });
        nbt.put(LostTalesPlayerData.KEY_PLAYER_DATA, playersNbt);
        return nbt;
    }

    public static LostTalesStateSaverAndLoader createFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        LostTalesStateSaverAndLoader state = new LostTalesStateSaverAndLoader();

        NbtCompound playersNbt = tag.getCompound(LostTalesPlayerData.KEY_PLAYER_DATA);
        playersNbt.getKeys().forEach(key -> {
            LostTalesPlayerData playerData = new LostTalesPlayerData();

            for (int activeQuests : playersNbt.getCompound(key).getIntArray(LostTalesPlayerData.KEY_ACTIVE_QUESTS)) {
                playerData.activeQuests.add(activeQuests);
            }

            for (int completedQuests : playersNbt.getCompound(key).getIntArray(LostTalesPlayerData.KEY_COMPLETED_QUESTS)) {
                playerData.completedQuests.add(completedQuests);
            }

            UUID uuid = UUID.fromString(key);
            state.players.put(uuid, playerData);
        });

        return state;
    }

    public static LostTalesStateSaverAndLoader getServerState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        LostTalesStateSaverAndLoader state = persistentStateManager.getOrCreate(type, LostTales.MOD_ID);
        state.markDirty();
        return state;
    }

    public static LostTalesPlayerData getPlayerState(LivingEntity player) {
        LostTalesStateSaverAndLoader serverState = getServerState(player.getWorld().getServer());
        LostTalesPlayerData playerState = serverState.players.computeIfAbsent(player.getUuid(), uuid -> new LostTalesPlayerData());
        return playerState;
    }
}