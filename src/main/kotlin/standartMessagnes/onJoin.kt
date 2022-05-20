package standartMessagnes

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.minimessage.MiniMessage
import net.md_5.bungee.api.ChatColor
import org.bukkit.event.player.PlayerJoinEvent


object onJoin{
    fun register(){
        onJoin.register()
    }
    var onJoin = listen<PlayerJoinEvent>{
        var player = it.player.name
        var join: Component = MiniMessage.miniMessage().deserialize("<blue>[provocatio-network]</blue><yellow> » </yellow><underlined><color:#40ff00>$player</color></underlined>")
        it.joinMessage(join)
        if(it.player.hasPermission("op")){
        }

    }
}