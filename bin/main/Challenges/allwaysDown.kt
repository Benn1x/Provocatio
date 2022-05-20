package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.extensions.onlinePlayers
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent

object allwaysDown {
    fun register(){
        onMove.register()
    }

    fun unregister() {
        onMove.unregister()
    }


    private val onMove = listen<PlayerMoveEvent>{
        val player = it.player
        if(it.getTo().getBlockY() > it.getFrom().getBlockY()){

            onlinePlayers.forEach() {
                it.damage(100000000000000000.0)
            }
            val playername = player.getName()
            onlinePlayers.forEach() {it.sendMessage("$playername ist nach Oben gegangen") }
        }
        val y = it.getTo().getBlockY()
        player.spigot().sendMessage(
            ChatMessageType.ACTION_BAR, TextComponent(ChatColor.GOLD.toString() +
                    ChatColor.BOLD +"$y")
        )

    }
}

