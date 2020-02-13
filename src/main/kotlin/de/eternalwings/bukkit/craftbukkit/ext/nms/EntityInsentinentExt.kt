package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityInsentient
import net.minecraft.server.v1_13_R2.PathType

fun EntityInsentient.onGrassEaten() = this.x()

fun EntityInsentient.getPathCost(pathType: PathType): Float = this.a(pathType)

fun EntityInsentient.setPathCost(pathType: PathType, value: Float) = this.a(pathType, value)
