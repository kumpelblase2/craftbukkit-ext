package de.eternalwings.bukkit.craftbukkit.ext

import net.minecraft.server.v1_13_R2.EntityLiving
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftLivingEntity
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

val LivingEntity.nmsEntity: EntityLiving
    get() = (this as CraftLivingEntity).handle

val LivingEntity.nmsClass: Class<out EntityLiving>
    get() = (this as CraftLivingEntity).handle.javaClass

fun Entity.getNearbyPlayers(distanceX: Double, distanceY: Double = distanceX, distanceZ: Double = distanceX): List<Player> {
    return this.getNearbyEntities(distanceX, distanceY, distanceZ).filterIsInstance(Player::class.java)
}

fun ItemStack.asCraftVersion(): CraftItemStack = this as? CraftItemStack ?: CraftItemStack.asCraftCopy(this)
