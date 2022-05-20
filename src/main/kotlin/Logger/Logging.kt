package Logger

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit.getLogger
import org.bukkit.ChatColor

class Logging {
    fun infoLogger(text: String){
        var logger = getLogger()
        logger.info(ChatColor.BLUE.toString()+"[provocatio-network]"+ChatColor.WHITE.toString()+text)
    }
    fun warnLogger(text: String){
        var logger = getLogger()
        logger.info(ChatColor.RED.toString()+"[provocatio-network]"+ChatColor.WHITE.toString()+text)
    }
}