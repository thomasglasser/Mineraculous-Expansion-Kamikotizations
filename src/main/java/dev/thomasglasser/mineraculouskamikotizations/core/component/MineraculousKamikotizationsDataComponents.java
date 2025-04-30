package dev.thomasglasser.mineraculouskamikotizations.core.component;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;

public class MineraculousKamikotizationsDataComponents {
    private static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MineraculousKamikotizations.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<WeatherControlParasolItem.Ability>> WEATHER_CONTROL_PARASOL_ABILITY = DATA_COMPONENTS.registerComponentType("weather_control_parasol_ability", builder -> builder
            .persistent(WeatherControlParasolItem.Ability.CODEC)
            .networkSynchronized(WeatherControlParasolItem.Ability.STREAM_CODEC)
            .cacheEncoding());

    public static void init() {}
}
