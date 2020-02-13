package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.BlockDoor.OPEN
import net.minecraft.server.v1_13_R2.IBlockData
import net.minecraft.server.v1_13_R2.IBlockDataHolder

val IBlockDataHolder<IBlockData>.isDoorOpen: Boolean
    get() = this.get(OPEN)
