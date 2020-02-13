package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.Entity
import net.minecraft.server.v1_13_R2.EnumBlockFaceShape
import net.minecraft.server.v1_13_R2.EnumDirection
import net.minecraft.server.v1_13_R2.IBlockData
import net.minecraft.server.v1_13_R2.World

fun IBlockData.getBlockFaceShape(world: World, position: BlockPosition, facing: EnumDirection): EnumBlockFaceShape =
        this.c(world, position, facing)

fun IBlockData.canEntitySpawn(entity: Entity) = this.a(entity)
