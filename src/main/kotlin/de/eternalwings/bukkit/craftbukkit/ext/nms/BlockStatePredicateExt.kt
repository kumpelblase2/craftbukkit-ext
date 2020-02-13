package de.eternalwings.bukkit.craftbukkit.ext.nms

import net.minecraft.server.v1_13_R2.Block
import net.minecraft.server.v1_13_R2.BlockStatePredicate
import net.minecraft.server.v1_13_R2.IBlockState
import java.util.function.Predicate

object BlockStatePredicateExt {
    fun getForBlock(block: Block): BlockStatePredicate = BlockStatePredicate.a(block)
}

fun <V : Comparable<V>> BlockStatePredicate.where(property: IBlockState<V>, matcher: Predicate<Any>) = this.a(property, matcher)
