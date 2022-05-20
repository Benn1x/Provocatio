package Timer

import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.ChatColor


object time {
    var s = 0
    var m = 0
    var h = 0
    var d = 0
    var status = "Stop"

    fun setTimer(args: String){
        status = args
    }

    fun timer(){
        var timer = ""
            task(sync = true, delay = 20, period = 20, howOften = null) {
                timer = ""
                when(status){
                    "Running" -> {s++
                        if (s == 59) {
                            s = 0
                            m++
                        }
                        if (m == 59) {
                            m = 0
                            h++
                        }
                        if (h == 24) {
                            h = 0
                            d++
                        }
                        if(s<10){
                            if(m<10) timer = "$d:$h:0$m:0$s"
                            if(m>=10) timer = "$d:$h:$m:0$s"
                        }
                        if(s>=10){
                            if(m<10) timer = "$d:$h:0$m:$s"
                            if(m>=10) timer = "$d:$h:$m:$s"
                        }
                    }
                    "Stop" -> {
                        if(s<10){
                            if(m<10) timer = "$d:$h:0$m:0$s"
                            if(m>=10) timer = "$d:$h:$m:0$s"
                        }
                        if(s>=10){
                            if(m<10) timer = "$d:$h:0$m:$s"
                            if(m>=10) timer = "$d:$h:$m:$s"
                        }
                    }
                    "Reset" -> {
                        s = 0
                        m = 0
                        h = 0
                        d = 0
                        timer = "Timer: Inavtive"
                    }
                }
                onlinePlayers.forEach() {
                    it.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR, TextComponent(
                            "<"+ChatColor.GOLD.toString() +
                                    ChatColor.BOLD + timer+ChatColor.WHITE.toString()+">"
                        )
                    )
                }


            }

    }
}

