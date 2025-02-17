package dev.thomasglasser.mineraculouskamikotizations.network;

import dev.thomasglasser.mineraculouskamikotizations.MineraculousKamikotizations;
import dev.thomasglasser.tommylib.api.network.ExtendedPacketPayload;
import dev.thomasglasser.tommylib.api.network.NeoForgeNetworkUtils;
import dev.thomasglasser.tommylib.api.network.PayloadInfo;
import java.util.List;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class MineraculousKamikotizationsPayloads {
    public static List<PayloadInfo<?>> PAYLOADS = List.of(
            // Serverbound
            new PayloadInfo<>(ServerboundSetWeatherControlParasolAbilityPayload.TYPE, ExtendedPacketPayload.Direction.CLIENT_TO_SERVER, ServerboundSetWeatherControlParasolAbilityPayload.CODEC));

    public static void onRegisterPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MineraculousKamikotizations.MOD_ID);
        PAYLOADS.forEach((info) -> NeoForgeNetworkUtils.register(registrar, info));
    }
}
