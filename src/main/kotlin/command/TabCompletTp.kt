package command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class TabCompletTp: TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): MutableList<String>? {
        var list = ArrayList<String>()
        Bukkit.getWorlds().forEach{
            var name = it.name
            list.add(name.toString())
        }
        return list
    }
}