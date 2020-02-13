package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.AttributeInstance
import net.minecraft.server.v1_13_R2.AttributeModifier

fun AttributeInstance.applyModifier(modifier: AttributeModifier) = this.b(modifier)

fun AttributeInstance.removeModifier(modifier: AttributeModifier) = this.c(modifier)
