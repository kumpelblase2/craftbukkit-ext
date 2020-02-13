package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.AttributeModifier

val AttributeModifier.operation: Int
    get() = this.c()

val AttributeModifier.value: Double
    get() = this.d()
