package Position

import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Position: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        var locx = sender.location.blockX
        var locy = sender.location.blockY
        var locz = sender.location.blockZ
        var loc = "$locx , $locy ,$locz"
        onlinePlayers.forEach{
            it.sendMessage("${sender.name} set ${args[0]} to Location $loc ")
        }
        return true
    }
}