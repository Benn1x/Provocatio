package WorldManager

import org.apache.commons.io.FileUtils
import org.apache.commons.io.FileUtils.deleteDirectory
import org.bukkit.Bukkit
import org.bukkit.World
import java.io.File

class delWorld {
    fun del(world:String){
        Bukkit.unloadWorld("$world",false)
        Bukkit.getWorld("$world")?.worldFolder?.delete()
        Logger.Logging().infoLogger("The World $world got deleted")

    }
}