package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.GameRules

val GameRules.mobGriefing: Boolean
    get() = this.getBoolean("mobGriefing")
