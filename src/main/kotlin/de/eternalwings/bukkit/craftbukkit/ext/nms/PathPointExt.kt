package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.PathPoint

val PathPoint.blockPosition
    get() = BlockPosition(this.x, this.y, this.z)

val PathPoint.x
    get() = this.a

val PathPoint.y
    get() = this.b

val PathPoint.z
    get() = this.c
