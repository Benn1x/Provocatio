package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerToggleSneakEvent

object noSneak {
    fun register(){
        Sneak.register()
    }

    fun unregister() {
        Sneak.unregister()
    }


    private val Sneak = listen<PlayerToggleSneakEvent> {
        val player = it.player
        it.setCancelled(true)
        val playername = player.getName()
        onlinePlayers.forEach() {
            it.sendMessage("$playername ist geSneaked")
        }
    }
}