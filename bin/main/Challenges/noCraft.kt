package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.PlayerJoinEvent

object noCraft {
    fun register(){
        Craft.register()
    }

    fun unregister() {
        Craft.unregister()
    }


    private val Craft = listen<CraftItemEvent>{
        it.setCancelled(true);
    }
}