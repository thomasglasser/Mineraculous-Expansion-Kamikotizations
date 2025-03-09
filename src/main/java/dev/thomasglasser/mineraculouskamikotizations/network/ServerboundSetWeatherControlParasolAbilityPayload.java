package dev.thomasglasser.mineraculouskamikotizations.network;

import dev.thomasglasser.mineraculous.Mineraculous;
import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.mineraculouskamikotizations.core.component.MineraculousKamikotizationsDataComponents;
import dev.thomasglasser.mineraculouskamikotizations.world.item.WeatherControlParasolItem;
import dev.thomasglasser.tommylib.api.network.ExtendedPacketPayload;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;

public record ServerboundSetWeatherControlParasolAbilityPayload(InteractionHand hand, WeatherControlParasolItem.Ability selected) implements ExtendedPacketPayload {
    public static final Type<ServerboundSetWeatherControlParasolAbilityPayload> TYPE = new Type<>(MineraculousKamikotizations.modLoc("set_weather_control_parasol_ability"));
    public static final StreamCodec<ByteBuf, ServerboundSetWeatherControlParasolAbilityPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8.map(InteractionHand::valueOf, InteractionHand::name), ServerboundSetWeatherControlParasolAbilityPayload::hand,
            WeatherControlParasolItem.Ability.STREAM_CODEC, ServerboundSetWeatherControlParasolAbilityPayload::selected,
            ServerboundSetWeatherControlParasolAbilityPayload::new);

    // ON SERVER
    @Override
    public void handle(Player player) {
        player.getItemInHand(hand).set(MineraculousKamikotizationsDataComponents.WEATHER_CONTROL_PARASOL_ABILITY, selected);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
