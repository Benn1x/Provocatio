package command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class TabCompletTimer: TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {

        val list = arrayListOf<String>()
        list.add("Start")
        list.add("Stop")
        list.add("Reset")
        list.add("Restart")
        return list

    }

}