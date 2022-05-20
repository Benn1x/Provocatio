package WorldManager

import net.minecraft.core.SectionPos.*
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Player


class teleport {
    fun tp(name:String,player:Player){
        var Spawnloc = Bukkit.getWorld("$name")?.spawnLocation
        var SpawnLocX = Spawnloc?.blockX
        var SpawnLocY = Spawnloc?.blockY
        var SpawnLocZ = Spawnloc?.blockZ
        val loc = SpawnLocX?.let { SpawnLocY?.let { it1 -> SpawnLocZ?.let { it2 -> Location(Bukkit.getWorld("$name"), it.toDouble(), it1.toDouble(), it2.toDouble()) } } }
        if (loc != null) {
            player.teleport(loc)
            if (SpawnLocX != null) {
                if (SpawnLocY != null) {
                    if (SpawnLocZ != null) {
                        player.bedSpawnLocation?.set(SpawnLocX.toDouble(), SpawnLocY.toDouble(),SpawnLocZ.toDouble())
                    }
                }
            }
        }
        Logger.Logging().infoLogger("The Player ${player.name} were Teleported to The World $name")
    }
}