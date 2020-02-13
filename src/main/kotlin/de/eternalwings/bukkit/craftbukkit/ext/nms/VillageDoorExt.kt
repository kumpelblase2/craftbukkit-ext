package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.VillageDoor

val VillageDoor.insidePosition: BlockPosition
    get() = this.e()

val VillageDoor.position: BlockPosition
    get() = this.d()

fun VillageDoor.distanceSquared(blockPosition: BlockPosition) = this.a(blockPosition)
