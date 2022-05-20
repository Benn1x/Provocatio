package WorldManager

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerPortalEvent


class McWorldGen {
    fun genarate(name: String){
        val overworld = WorldCreator("$name")


        overworld.environment(World.Environment.NORMAL)
        overworld.type(WorldType.NORMAL)

        overworld.createWorld()
        val nether = WorldCreator("${name}_nether")
        nether.environment(World.Environment.NETHER)
        nether.type(WorldType.NORMAL)
        nether.createWorld()

        val end = WorldCreator("${name}_the_end")
        end.environment(World.Environment.THE_END)
        end.type(WorldType.NORMAL)
        end.createWorld()
        var gen: Component = MiniMessage.miniMessage().deserialize("<blue>[provocatio-network]</blue> the World <green>$name</green> were generatet<newline>Click <green><click:run_command:/teleport $name><u><hover:show_text:'<green>Click this to teleport you in the World $name </green>'>here</hover></u></click>")
        onlinePlayers.forEach{
            it.sendMessage(gen)
        }
        Logger.Logging().infoLogger("the World's $name ${name}_nether ${name}_the_end were created")
    }
}