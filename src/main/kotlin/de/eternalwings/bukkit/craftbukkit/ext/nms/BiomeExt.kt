package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BiomeBase

val BiomeBase.precipitation: BiomeBase.Precipitation
    get() = this.c()
