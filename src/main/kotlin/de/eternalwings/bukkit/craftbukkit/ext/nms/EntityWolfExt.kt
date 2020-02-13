package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityWolf

var EntityWolf.begging
    get() = this.dL()
    set(value) = this.w(value)
