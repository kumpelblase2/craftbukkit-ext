package de.eternalwings.bukkit.craftbukkit.ext.nms

import de.eternalwings.bukkit.craftbukkit.ext.toNMS
import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Entity
import net.minecraft.server.v1_13_R2.MathHelper
import net.minecraft.server.v1_13_R2.SoundCategory
import net.minecraft.server.v1_13_R2.SoundEffect
import net.minecraft.server.v1_13_R2.Vec3D
import org.bukkit.Sound

fun Entity.distance(other: Entity) = this.g(other)

fun Entity.distanceSquared(other: Entity) = this.h(other)

fun Entity.distance(posX: Double, posY: Double, posZ: Double) = this.e(posX, posY, posZ)

fun Entity.distanceSquared(posX: Double, posY: Double, posZ: Double) = this.d(posX, posY, posZ)

fun Entity.distance(vec3D: Vec3D) = this.distance(vec3D.x, vec3D.y, vec3D.z)

fun Entity.distanceSquared(vec3D: Vec3D) = this.distanceSquared(vec3D.x, vec3D.y, vec3D.z)

fun Entity.distanceSquared(blockPosition: BlockPosition) = this.c(blockPosition)

val Entity.locationVector
    get() = Vec3D(this.locX, this.locY, this.locZ)

val Entity.blockPosition
    get() = BlockPosition(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ))

fun Entity.isOnSameTeam(entity: Entity) = this.a(entity.scoreboardTeam)

fun Entity.makeSound(sound: SoundEffect?, range: Float, intensity: Float) = this.a(sound, range, intensity)

fun Entity.makeSound(sound: Sound?, range: Float, intensity: Float) = this.makeSound(sound?.toNMS(), range, intensity)

val Entity.soundCategory: SoundCategory
    get() = this.bV()
