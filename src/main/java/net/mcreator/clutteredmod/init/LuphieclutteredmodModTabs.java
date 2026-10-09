// Derived from Cluttered 2.1.0 (blake/unilock); nonofficial local Minecraft 1.21.1 Fabric adaptation.
/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 */
package net.mcreator.clutteredmod.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mcreator.clutteredmod.init.LuphieclutteredmodModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class LuphieclutteredmodModTabs {
    public static ResourceKey<CreativeModeTab> TAB_CLUTTER_MOD = ResourceKey.create((ResourceKey)Registries.CREATIVE_MODE_TAB, (ResourceLocation)ResourceLocation.fromNamespaceAndPath("luphieclutteredmod", "clutter_mod"));

    public static void load() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_CLUTTER_MOD, FabricItemGroup.builder().title(Component.translatable("item_group.luphieclutteredmod.clutter_mod")).icon(() -> new ItemStack(LuphieclutteredmodModBlocks.LUPHIE_PURPLE_BLACK_CAT_BOOKSHELF)).build());
    }
}

