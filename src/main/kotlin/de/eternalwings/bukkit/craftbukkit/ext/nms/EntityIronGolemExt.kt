package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityIronGolem
import net.minecraft.server.v1_13_R2.Village

var EntityIronGolem.isHoldingRose: Boolean
    get() = this.roseHoldTicks > 0
    set(value) = this.a(value)

val EntityIronGolem.roseHoldTicks: Int
    get() = this.dz()

val EntityIronGolem.village: Village?
    get() = this.l()
