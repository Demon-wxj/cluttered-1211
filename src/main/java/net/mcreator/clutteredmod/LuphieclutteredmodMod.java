// Derived from Cluttered 2.1.0 (blake/unilock); nonofficial local Minecraft 1.21.1 Fabric adaptation.
/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package net.mcreator.clutteredmod;

import net.fabricmc.api.ModInitializer;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlockEntities;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlocks;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModItems;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModPaintings;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModSounds;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LuphieclutteredmodMod
implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "luphieclutteredmod";

    public void onInitialize() {
        LOGGER.info("Initializing LuphieclutteredmodMod");
        LuphieclutteredmodModTabs.load();
        LuphieclutteredmodModBlocks.load();
        LuphieclutteredmodModItems.load();
        LuphieclutteredmodModBlockEntities.load();
        LuphieclutteredmodModPaintings.load();
        LuphieclutteredmodModSounds.load();
    }
}

