package dev.thomasglasser.mineraculouskamikotizations.world.attachment;

import com.mojang.serialization.Codec;
import dev.thomasglasser.mineraculous.Mineraculous;
import dev.thomasglasser.tommylib.api.registration.DeferredHolder;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MineraculousKamikotizationsAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Mineraculous.MOD_ID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> WEATHER_MODIFIED = ATTACHMENT_TYPES.register("weather_modified", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());

    public static void init() {}
}
