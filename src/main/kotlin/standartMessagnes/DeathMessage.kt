package standartMessagnes

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.entity.PlayerDeathEvent

object DeathMessage {
    fun register(){
        death.register()
    }
    var death = listen<PlayerDeathEvent>{
        var x = it.player.location.blockX
        var y = it.player.location.blockY
        var z = it.player.location.blockZ
        var death: Component = MiniMessage.miniMessage().deserialize("<red> ${it.player.name} died at</red> <yellow>$x $y $z</yellow><red>, reason: ${it.player.lastDamageCause?.cause}-DAMAGE</red>")
        it.deathMessage(death)
    }
}