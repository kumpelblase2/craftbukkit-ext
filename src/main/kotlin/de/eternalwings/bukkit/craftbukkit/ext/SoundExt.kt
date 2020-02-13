package de.eternalwings.bukkit.craftbukkit.ext

import net.minecraft.server.v1_13_R2.SoundEffect
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_13_R2.CraftSound

fun Sound.toNMS(): SoundEffect = CraftSound.getSoundEffect(CraftSound.getSound(this))
