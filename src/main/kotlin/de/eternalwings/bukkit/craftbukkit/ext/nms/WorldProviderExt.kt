package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.WorldProvider

val WorldProvider.hasSkylight: Boolean
    get() = this.g()
