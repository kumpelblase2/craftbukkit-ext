package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.AxisAlignedBB

fun AxisAlignedBB.grow(amount: Double): AxisAlignedBB = this.g(amount)
