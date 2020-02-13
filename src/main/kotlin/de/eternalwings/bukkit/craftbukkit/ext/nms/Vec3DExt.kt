package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.Vec3D
import org.bukkit.Location
import org.bukkit.World

fun Vec3D.multiply(value: Double): Vec3D = this.a(value)

fun Vec3D.toLocation(world: World): Location = Location(world, this.x, this.y, this.z)
