package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.PathEntity
import net.minecraft.server.v1_13_R2.PathPoint

val PathEntity.isFinished: Boolean
    get() = this.b()

val PathEntity.index: Int
    get() = this.e()

val PathEntity.currentLength: Int
    get() = this.d()

fun PathEntity.getElementAtIndex(index: Int): PathPoint = this.a(index)
