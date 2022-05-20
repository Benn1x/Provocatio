package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import org.bukkit.event.inventory.TradeSelectEvent
import org.bukkit.event.player.PlayerJoinEvent

object noTrade {


    fun register(){
        Trade.register()
    }

     fun unregister(){
        Trade.unregister()
    }

    private val Trade = listen<TradeSelectEvent>{
        it.setCancelled(true);
    }
}