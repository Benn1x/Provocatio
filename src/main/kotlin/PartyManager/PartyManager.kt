package PartyManager

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.scoreboard.Team


class PartyManager: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        val manager: ScoreboardManager = Bukkit.getScoreboardManager()
        val board: Scoreboard = manager.getNewScoreboard()
        val team: Team = board.registerNewTeam(args[0])
        var see = false
        var fire= false
        when(args[2]){
            "True"->see = true
        }
        when(args[3]){
            "True"-> fire = true
        }

        ScoreBoardBuilder.ScoreBoard().buildScoreBoard(manager, board,team,args[1],see, fire)
        if (args[4] != null){
            when(args[4]){
                "add"->{
                    var player: Player? = Bukkit.getServer().getPlayer(args[5])
                    if (player != null) {
                        ScoreBoardBuilder.ScoreBoard().add(team,player,true,false)
                    }
                }
                "remove"->{
                    var player: Player? = Bukkit.getServer().getPlayer(args[5])
                    if (player != null) {
                        ScoreBoardBuilder.ScoreBoard().add(team,player,false,true)
                    }
                }
            }
        }

        return true
    }
}