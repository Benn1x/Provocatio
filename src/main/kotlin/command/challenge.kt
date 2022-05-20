package command

import Challenges.*
import loader.challengeLoader
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class challenge: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        when(args[0]  ){
            "start" -> when(args[1]){
                "allwaysDown" -> challengeLoader().loadallwaysDown()
                "allwaysUp" -> challengeLoader().loadAllwaysUp()
                "BoostUp" -> challengeLoader().loadBoostUp()
                "noCraft" -> challengeLoader().loadNoCraft()
                "noSneak" -> challengeLoader().loadNoSneak()
                "noTrade" -> challengeLoader().loadNoTrade()
                "FrostWalker" -> challengeLoader().loadFrostWalker()
                "BoatRace" -> challengeLoader().loadBoatRace()
            }
            "stop" ->when(args[1]) {
                "allwaysDown" -> challengeLoader().unloadAllwaysDown()
                "allwaysUp" -> challengeLoader().unloadAllwaysUp()
                "BoostUp" -> challengeLoader().unloadBoostUp()
                "noCraft" -> challengeLoader().unloadNoCraft()
                "noSneak" -> challengeLoader().unloadNoSneak()
                "noTrade" -> challengeLoader().unloadNoTrade()
                "FrostWalker" -> challengeLoader().unloadFrostWalker()
                "BoatRace" -> challengeLoader().unloadBoatRace()
                "all" -> challengeLoader().unloadall()
            }
        }
            return true
    }

}