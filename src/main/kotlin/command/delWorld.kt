package command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class delWorld: CommandExecutor {
        override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
            if (sender !is Player) return false
            /*var gui = GuiChallengeLoader

             */
            var player: Player = sender
            WorldManager.delWorld().del(args[0])
            return true
        }
}