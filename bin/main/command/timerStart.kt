package command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class timerStart: CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        when(args[0]){
            "Start" -> Timer.time.setTimer("Running")
            "Stop" -> Timer.time.setTimer("Stop")
            "Reset" -> Timer.time.setTimer("Reset")
            "Reload"->Timer.time.setTimer("Restart")
        }
        return true
    }

}