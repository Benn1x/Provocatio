package standartMessagnes

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.player.PlayerQuitEvent

object onLeave {
    fun register(){
        onJoin.register()
    }
    var onJoin = listen<PlayerQuitEvent>{
        var player = it.player.name
        var join: Component = MiniMessage.miniMessage().deserialize("<blue>[provocatio-network]</blue><red> << </red><underlined><color:#40ff00>$player</color></underlined>")
        it.quitMessage(join)

    }
}
