package de.eternalwings.bukkit.craftbukkit.ext

import net.minecraft.server.v1_13_R2.Packet
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer
import org.bukkit.entity.Player

fun Player.sendPacket(packet: Packet<*>) {
    (this as CraftPlayer).handle.playerConnection.sendPacket(packet)
}
