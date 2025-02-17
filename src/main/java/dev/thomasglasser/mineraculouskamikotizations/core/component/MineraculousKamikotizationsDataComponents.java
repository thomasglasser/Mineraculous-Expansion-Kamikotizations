package dev.thomasglasser.mineraculouskamikotizations.core.component;

import com.mojang.serialization.Codec;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import java.util.function.Supplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

public class MineraculousKamikotizationsDataComponents {
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MineraculousKamikotizations.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<WeatherControlParasolItem.Ability>> WEATHER_CONTROL_PARASOL_ABILITY = register("weather_control_parasol_ability", WeatherControlParasolItem.Ability.CODEC, WeatherControlParasolItem.Ability.STREAM_CODEC, true);

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, @Nullable Codec<T> diskCodec, @Nullable StreamCodec<? super RegistryFriendlyByteBuf, T> networkCodec, boolean cache) {
        Supplier<DataComponentType<T>> component = () -> {
            DataComponentType.Builder<T> builder = DataComponentType.builder();
            if (diskCodec != null) {
                builder.persistent(diskCodec);
            }
            if (networkCodec != null) {
                builder.networkSynchronized(networkCodec);
            }
            if (cache) {
                builder.cacheEncoding();
            }
            return builder.build();
        };
        return DATA_COMPONENTS.register(name, component);
    }

    public static void init() {}
}
