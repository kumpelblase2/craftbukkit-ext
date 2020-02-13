package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityVillager

var EntityVillager.isPlaying: Boolean
    get() = this.dA()
    set(value) = this.t(value)

val EntityVillager.isTrading: Boolean
    get() = this.dB()
