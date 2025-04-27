package dev.thomasglasser.mineraculouskamikotizations.world.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.EntityMountEvent;

public class MineraculousKamikotizationsEntityEvents {
    public static void onEntityMount(EntityMountEvent event) {
        Entity mounting = event.getEntityMounting();
        Entity mounted = event.getEntityBeingMounted();
        if (event.isDismounting() && !(mounting.isRemoved() || mounting.isSpectator() || mounting instanceof Player player && player.isCreative()) && !mounted.isRemoved() && mounted instanceof BubblePrison) {
            event.setCanceled(true);
        }
    }
}
