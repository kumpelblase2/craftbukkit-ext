package de.eternalwings.bukkit.craftbukkit.ext

import net.minecraft.server.v1_13_R2.BlockPosition
import org.bukkit.Location

fun Location.toBlockPosition() = BlockPosition(this.x, this.y, this.z)
