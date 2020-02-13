package de.eternalwings.bukkit.craftbukkit.ext

import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.EventPriority.NORMAL
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.ServicePriority.Normal

fun Plugin.registerEvents(eventListener: Listener) {
    Bukkit.getPluginManager().registerEvents(eventListener, this)
}

fun Plugin.scheduleSyncRepeatingTask(initialDelay: Long = 0, delay: Long = 1000, task: () -> Unit) {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, task, initialDelay, delay)
}

fun Plugin.runTask(task: () -> Unit) {
    Bukkit.getScheduler().runTask(this, task)
}

fun Plugin.runAsync(task: () -> Unit) {
    Bukkit.getScheduler().runTaskAsynchronously(this, task)
}

object EmptyListener : Listener

inline fun <reified T : Event> Plugin.registerEvent(priority: EventPriority = NORMAL, crossinline closure: (T) -> Unit) {
    Bukkit.getPluginManager().registerEvent(T::class.java, EmptyListener, priority, { _, event ->
        closure(event as T)
    }, this)
}

inline fun <reified S, T : S> Plugin.registerService(instance: T, priority: ServicePriority = Normal) {
    Bukkit.getServicesManager().register(S::class.java, instance, this, priority)
}
