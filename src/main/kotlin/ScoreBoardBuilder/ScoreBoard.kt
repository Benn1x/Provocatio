package ScoreBoardBuilder

import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.entity.Player
import org.bukkit.scoreboard.*

class ScoreBoard {
    fun buildScoreBoard(
        board: ScoreboardManager,
        ScoreBoard: Scoreboard,
        team: Team,
        prefix: String,
        seeFrendlyInvisable: Boolean,
        allowFriendlyFire: Boolean
    ){
        team.setPrefix(prefix)
        team.setCanSeeFriendlyInvisibles(seeFrendlyInvisable)
        team.setAllowFriendlyFire(allowFriendlyFire)

    }
    fun add(team: Team, player: Player, add:Boolean, remove: Boolean){
        when(add){
            true -> team.addPlayer(player)
        }
        when(remove){
            true -> team.removePlayer(player)
        }
    }


}

