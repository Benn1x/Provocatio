package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import org.bukkit.entity.Item
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

object UltimateRandomizer {
    fun register(){
    }

    fun unregister() {
    }
    private val onBrake =  listen<BlockBreakEvent> {
        TODO("Random Zuweisung und speicherung")
        TODO("Derzeitiger Plan 'getDrops().remove(ItemStack)' und 'event.getDrops().add(ItemStack)' ")
        TODO("Siehe https://bukkit.org/threads/changing-the-item-a-block-drops.129007/ und https://www.spigotmc.org/threads/how-to-get-drops-from-block-in-event-of-block-break.353827/")

    }
    fun randomize(){

    }
}