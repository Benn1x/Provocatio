package command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import main.Structur.InternalMainClass

class TabCompletion : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {

        val list = arrayListOf<String>()
        list.add("start")
        list.add("stop")
        when(args[0]){
            "start" -> list.addAll(listOf("allwaysDown","allwaysUp","BoostUp","noCraft","noSneak","noTrade","FrostWalker","BoatRace"))
            "stop" -> list.addAll(listOf("allwaysDown","allwaysUp","BoostUp","noCraft","noSneak","noTrade","FrostWalker","BoatRace","all"))
        }
        return list

    }

}
