package de.eternalwings.bukkit.craftbukkit.ext.nms

import de.eternalwings.bukkit.craftbukkit.ext.toNMS
import net.minecraft.server.v1_13_R2.AxisAlignedBB
import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Entity
import net.minecraft.server.v1_13_R2.EntityHuman
import net.minecraft.server.v1_13_R2.PersistentVillage
import net.minecraft.server.v1_13_R2.SoundCategory
import net.minecraft.server.v1_13_R2.SoundEffect
import net.minecraft.server.v1_13_R2.World
import org.bukkit.Sound

val World.villages: PersistentVillage
    get() = this.af()

val World.isDayTime: Boolean
    get() = this.L()

inline fun <reified T : Entity> World.getEntitiesOfTypeInBox(boundingBox: AxisAlignedBB, noinline predicate: (T?) -> Boolean) =
        this.getEntitiesOfTypeInBox(T::class.java, boundingBox, predicate)

inline fun <reified T : Entity> World.getEntitiesOfTypeInBox(boundingBox: AxisAlignedBB) =
        this.getEntitiesOfTypeInBox(T::class.java, boundingBox)

inline fun <reified T : Entity> World.getClosestEntityOfTypeInBox(boundingBox: AxisAlignedBB, except: T) =
        this.getClosestEntityOfTypeInBox(T::class.java, boundingBox, except)

fun <T : Entity> World.getEntitiesOfTypeInBox(type: Class<out T>, boundingBox: AxisAlignedBB): List<T> =
        this.a(type, boundingBox)

fun <T : Entity> World.getClosestEntityOfTypeInBox(type: Class<out T>, boundingBox: AxisAlignedBB, except: T) =
        this.a(type, boundingBox, except)

fun <T : Entity> World.getEntitiesOfTypeInBox(type: Class<out T>, boundingBox: AxisAlignedBB, predicate: (T) -> Boolean): List<T> =
        this.a(type, boundingBox, predicate)

fun World.canSeeSkyAt(blockPosition: BlockPosition) = this.e(blockPosition)

fun World.getLightBrightnessOf(blockPosition: BlockPosition): Float = this.A(blockPosition)

fun World.sendBlockBreakProgress(breakerId: Int, position: BlockPosition, progress: Int) = this.c(breakerId, position, progress)

fun World.makeSound(x: Double, y: Double, z: Double, soundEffect: SoundEffect?, soundCategory: SoundCategory,
                    range: Float, intensity: Float, human: EntityHuman? = null) =
        this.a(human, x, y, z, soundEffect, soundCategory, range, intensity)

fun World.makeSound(x: Double, y: Double, z: Double, soundEffect: Sound?, soundCategory: SoundCategory, range: Float,
                    intensity: Float, human: EntityHuman? = null) =
        this.makeSound(x, y, z, soundEffect?.toNMS(), soundCategory, range, intensity, human)
