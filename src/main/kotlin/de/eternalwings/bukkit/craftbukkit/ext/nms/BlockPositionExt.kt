package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Vec3D
import org.bukkit.Location
import org.bukkit.World

fun BlockPosition.add(x: Int, y: Int, z: Int): BlockPosition = this.a(x, y, z)

fun BlockPosition.toVector() = Vec3D(this.x.toDouble(), this.y.toDouble(), this.z.toDouble())

fun BlockPosition.toLocation(world: World) = Location(world, this.x.toDouble(), this.y.toDouble(), this.z.toDouble())

fun BlockPosition.distanceSquared(other: BlockPosition): Double = this.m(other)
