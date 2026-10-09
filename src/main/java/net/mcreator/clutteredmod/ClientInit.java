// Derived from Cluttered 2.1.0 (blake/unilock); nonofficial local Minecraft 1.21.1 Fabric adaptation.
/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 */
package net.mcreator.clutteredmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlocks;

@Environment(value=EnvType.CLIENT)
public class ClientInit
implements ClientModInitializer {
    public void onInitializeClient() {
        LuphieclutteredmodModBlocks.clientLoad();
    }
}

