package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.ControllerLook
import net.minecraft.server.v1_13_R2.Entity

fun ControllerLook.lookAt(target: Entity, yaw: Float, pitch: Float) = this.a(target, yaw, pitch)

fun ControllerLook.lookAt(x: Double, y: Double, z: Double, yaw: Float, pitch: Float) = this.a(x, y, z, yaw, pitch)
