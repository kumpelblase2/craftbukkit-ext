package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockPosition
import net.minecraft.server.v1_13_R2.EntityCreature

fun EntityCreature.getLightBrightnessOf(position: BlockPosition) = this.a(position)
