package dev.thomasglasser.mineraculouskamikotizations.world.entity;

import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.EntityMountEvent;

public class MineraculousKamikotizationsEntityEvents {
    public static void onEntityMount(EntityMountEvent event) {
        Entity mounted = event.getEntityBeingMounted();
        if (event.isDismounting() && !mounted.isRemoved() && mounted instanceof BubblePrison) {
            event.setCanceled(true);
        }
    }
}
