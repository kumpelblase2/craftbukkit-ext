package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.EntityHuman
import net.minecraft.server.v1_13_R2.EntityTameableAnimal

fun EntityTameableAnimal.tameBy(player: EntityHuman) = this.c(player)
