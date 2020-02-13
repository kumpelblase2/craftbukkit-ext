package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.PathfinderGoal
import net.minecraft.server.v1_13_R2.PathfinderGoalSelector

fun PathfinderGoalSelector.clearGoals() {
    this.getGoals()?.clear()
    this.getRunningGoals()?.clear()
}

fun PathfinderGoalSelector.getGoals(): MutableSet<*>? {
    try {
        val field = PathfinderGoalSelector::class.java.getField("b")
        field.isAccessible = true
        return field.get(this) as MutableSet<*>
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun PathfinderGoalSelector.getRunningGoals(): MutableSet<*>? {
    try {
        val field = PathfinderGoalSelector::class.java.getField("c")
        field.isAccessible = true
        return field.get(this) as MutableSet<*>
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun PathfinderGoalSelector.addGoal(inGoal: PathfinderGoal, inPriority: Int) {
    this.a(inPriority, inGoal)
}
