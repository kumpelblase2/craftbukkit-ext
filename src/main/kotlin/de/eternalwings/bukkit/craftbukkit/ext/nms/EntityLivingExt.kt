package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Entity
import net.minecraft.server.v1_13_R2.EntityCreature
import net.minecraft.server.v1_13_R2.EntityGhast
import net.minecraft.server.v1_13_R2.EntityInsentient
import net.minecraft.server.v1_13_R2.EntityLiving
import net.minecraft.server.v1_13_R2.EntityPlayer
import net.minecraft.server.v1_13_R2.EntitySenses
import net.minecraft.server.v1_13_R2.EnumHand
import net.minecraft.server.v1_13_R2.GenericAttributes
import net.minecraft.server.v1_13_R2.PathType
import net.minecraft.server.v1_13_R2.Village

fun EntityLiving.getHomeRange(): Float = (this as? EntityCreature)?.du() ?: 5.0f

fun EntityLiving.getMaxHeadRotation() = (this as? EntityInsentient)?.K() ?: 40

val EntityLiving.followRange: Double
    get() {
        val attributeInstance = this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE) ?: return 16.0
        return attributeInstance.value
    }

fun EntityLiving.getEntitySenses() = when {
    this is EntityInsentient -> this.entitySenses
    else -> null
}

fun EntitySenses?.canSee(entity: Entity?) = this?.a(entity) ?: false

fun EntityLiving.getGoalTarget() = when (this) {
    is EntityInsentient -> this.goalTarget
    else -> null
}

fun EntityLiving.setGoalTarget(target: EntityLiving?) {
    when (this) {
        is EntityInsentient -> this.goalTarget = target
    }
}

fun EntityLiving.getNavigation() = when (this) {
    is EntityInsentient -> this.navigation
    else -> null
}

fun EntityLiving.getControllerLook() = when (this) {
    is EntityInsentient -> this.controllerLook
    else -> null
}

fun EntityLiving.getControllerMove() = when (this) {
    is EntityInsentient -> this.controllerMove
    else -> null
}

fun EntityLiving.getControllerJump() = when (this) {
    is EntityInsentient -> this.controllerJump
    else -> null
}

fun EntityLiving.jump() {
    this.getControllerJump()?.a()
}

fun EntityLiving.canAttackEntityType(type: Class<out EntityLiving>) = when (this) {
    is EntityInsentient -> this.b(type)
    else -> type != EntityGhast::class.java
}

val EntityLiving.chunkCoordinates: BlockPosition
    get() = (this as? EntityCreature)?.dt() ?: if (this is EntityPlayer) {
        this.chunkCoordinates
    } else {
        this.blockPosition
    }

val EntityLiving?.isOnLeash: Boolean
    get() = (this as? EntityInsentient)?.isLeashed ?: false

val EntityLiving.idleTime: Int
    get() = this.cj()

val EntityLiving.closestVillage: Village?
    get() = this.world.villages.getClosestVillage(this.blockPosition, 32)

val EntityLiving.lastAttackedTick: Int
    get() = this.cg()

fun EntityLiving.setJumping(state: Boolean) = this.o(state)

val EntityLiving.hasHomeArea: Boolean
    get() = this is EntityCreature && this.dw()

val EntityLiving.homeArea: BlockPosition?
    get() = (this as? EntityCreature)?.dt()

val EntityLiving.isInHomeArea: Boolean
    get() = this is EntityCreature && this.ds()

val EntityLiving.canBeSteered: Boolean
    get() = this is EntityInsentient && this.dh()

fun EntityLiving.isInHomeArea(x: Int, y: Int, z: Int) = this is EntityCreature && this.f(BlockPosition(x, y, z))

fun EntityLiving.isInHomeArea(position: BlockPosition) = isInHomeArea(position.x, position.y, position.z)

var EntityLiving.moveForward: Float
    get() = this.bj
    set(value) {
        this.bj = value
    }

var EntityLiving.moveStrafing: Float
    get() = this.bh
    set(value) {
        this.bh = value
    }

fun EntityLiving.getPathPriority(type: PathType): Float = when (this) {
    is EntityInsentient -> this.a(type)
    else -> type.a()
}

fun EntityLiving.setPathPriority(type: PathType, priority: Float): Unit = when (this) {
    is EntityInsentient -> this.a(type, priority)
    else -> {}
}

fun EntityLiving.showAttackAnimation(hand: EnumHand) = this.a(hand)

fun EntityLiving.damage(target: EntityLiving) = this.B(target)

fun EntityLiving.getPreferenceLevel(position: BlockPosition): Float = when (this) {
    is EntityCreature -> this.a(position)
    else -> 0.0f
}
