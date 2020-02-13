package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Entity
import net.minecraft.server.v1_13_R2.Navigation
import net.minecraft.server.v1_13_R2.NavigationAbstract
import net.minecraft.server.v1_13_R2.PathEntity
import net.minecraft.server.v1_13_R2.Vec3D

fun NavigationAbstract?.isFinished() = this?.p() ?: true

fun NavigationAbstract?.createPathTo(entity: Entity) = this?.a(entity)

fun NavigationAbstract?.createPathTo(posX: Double, posY: Double, posZ: Double) = this?.a(posX, posY, posZ)

fun NavigationAbstract?.createPathTo(position: BlockPosition) = this?.b(position)

fun NavigationAbstract?.createPathTo(vector: Vec3D) = this.createPathTo(vector.x, vector.y, vector.z)

fun NavigationAbstract.createPathToWithSpeed(entity: Entity, speed: Double) = this.a(entity, speed)

fun NavigationAbstract.createPathToWithSpeed(posX: Double, posY: Double, posZ: Double, speed: Double) = this.a(posX, posY, posZ, speed)

fun NavigationAbstract.createPathToWithSpeed(vector: Vec3D, speed: Double) = this.a(vector.x, vector.y, vector.z, speed)

fun NavigationAbstract.setSpeed(speed: Double): Unit = this.a(speed)

fun NavigationAbstract.clearPath(): Unit = this.q()

fun NavigationAbstract.setPath(path: PathEntity?, speed: Double) = this.a(path, speed)

val NavigationAbstract.currentPath: PathEntity?
    get() = this.m()

var NavigationAbstract.canEnterDoors: Boolean
    get() = this is Navigation && this.g()
    set(value) = when(this) {
        is Navigation -> this.b(value)
        else -> {}
    }

var NavigationAbstract.canOpenDoors: Boolean
    get() = this.s().d()
    set(value) = when(this) {
        is Navigation -> this.a(value)
        else -> this.s().b(value)
    }

var NavigationAbstract.canSwim: Boolean
    get() = this.t()
    set(value) = this.d(value)
