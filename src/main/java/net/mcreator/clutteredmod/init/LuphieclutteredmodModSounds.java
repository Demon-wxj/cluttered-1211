// Derived from Cluttered 2.1.0 (blake/unilock); nonofficial local Minecraft 1.21.1 Fabric adaptation.
/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 */
package net.mcreator.clutteredmod.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class LuphieclutteredmodModSounds {
    public static SoundEvent STARBOUNDMUSICBOX = SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath("luphieclutteredmod", "starboundmusicbox"));

    public static void load() {
        Registry.register((Registry)BuiltInRegistries.SOUND_EVENT, (ResourceLocation)ResourceLocation.fromNamespaceAndPath("luphieclutteredmod", "starboundmusicbox"), (Object)STARBOUNDMUSICBOX);
    }
}

