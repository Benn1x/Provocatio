package debug

import Timer.time
import gui.GuiChallengeLoader
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class debug: CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage("Timer Status: ${time.status}; AllwaysDown Status: ${GuiChallengeLoader.loadAllwaysDown}; AllwaysUp Status: ${GuiChallengeLoader.loadAllwaysUp}; BoostUp Status: ${GuiChallengeLoader.loadBoostUp};FrostWalker Status: ${GuiChallengeLoader.loadFrostWalker}; NoCraft Status: ${GuiChallengeLoader.loadNoCraft}")
        return true
    }
}