package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.EntityHuman
import net.minecraft.server.v1_13_R2.EntityLiving
import net.minecraft.server.v1_13_R2.Village
import net.minecraft.server.v1_13_R2.VillageDoor

fun Village.findNearestVillageAggressor(fromEntity: EntityLiving): EntityLiving? = this.b(fromEntity)

fun Village.findNearestPlayer(fromEntity: EntityLiving): EntityHuman? = this.c(fromEntity)

fun Village.getClosestDoor(position: BlockPosition): VillageDoor? = this.b(position)

val Village.doorCount: Int
    get() = this.c()

val Village.doors: List<VillageDoor>
    get() = this.f()

val Village.population: Int
    get() = this.e()
