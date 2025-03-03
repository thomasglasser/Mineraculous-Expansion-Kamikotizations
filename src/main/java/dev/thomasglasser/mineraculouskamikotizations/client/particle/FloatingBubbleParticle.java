package dev.thomasglasser.mineraculouskamikotizations.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class FloatingBubbleParticle extends TextureSheetParticle {
    protected final SpriteSet sprites;

    public FloatingBubbleParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = sprites;
        setSpriteFromAge(sprites);
        this.lifetime = level.random.nextInt(10, 20);
        scale(level.random.nextInt(5, 10) / 10.0F);
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.yd = this.yd - (double) this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.setSpriteFromAge(this.sprites);
        }
    }

    @Override
    public void setSpriteFromAge(SpriteSet sprite) {
        if (!this.removed) {
            if ((double) this.age / this.lifetime <= 0.75D) {
                this.setSprite(sprite.get(0, 1));
            } else
                this.setSprite(sprite.get(this.age / 6, this.lifetime / 6));
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(
                SimpleParticleType type,
                ClientLevel level,
                double x,
                double y,
                double z,
                double xSpeed,
                double ySpeed,
                double zSpeed) {
            return new FloatingBubbleParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
        }
    }
}
