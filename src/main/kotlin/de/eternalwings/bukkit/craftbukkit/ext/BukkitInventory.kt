package de.eternalwings.bukkit.craftbukkit.ext

import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftInventoryCustom
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

object BukkitInventory {
    fun createCustom(entity: LivingEntity?, size: Int = 36): Inventory {
        return CraftInventoryCustom(entity?.nmsEntity as InventoryHolder, size)
    }
}
