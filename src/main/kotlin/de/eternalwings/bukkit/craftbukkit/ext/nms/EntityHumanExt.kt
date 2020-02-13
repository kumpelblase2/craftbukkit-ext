package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityHuman

val EntityHuman.isCreative: Boolean
    get() = this.u()
