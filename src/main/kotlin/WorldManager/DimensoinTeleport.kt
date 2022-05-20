package WorldManager

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerPortalEvent
import org.bukkit.event.player.PlayerTeleportEvent

class DimensoinTeleport {
    fun register(){
        teleport.register()
    }
        val teleport = listen<PlayerPortalEvent>{
            when(it.cause){
                PlayerTeleportEvent.TeleportCause.NETHER_PORTAL ->{
                    var overworld = it.player.world.name
                    if("_nether" in overworld){
                        overworld = overworld.replace("_nether","")
                        var world = Bukkit.getWorld("$overworld")
                        it.to.setWorld(world)
                    }
                    else{
                        var nether = Bukkit.getWorld("${overworld}_nether")
                        it.to.setWorld(nether)

                    }
                }
                PlayerTeleportEvent.TeleportCause.END_PORTAL->{
                    var overworld = it.player.world.name
                    if("_the_end" in overworld ){
                        overworld = overworld.replace("_the_end","")
                        var world = Bukkit.getWorld("$overworld")
                        it.to.setWorld(world)
                    }
                    else{
                        var end = Bukkit.getWorld("${overworld}_the_end")
                        it.to.setWorld(end)
                    }
                }
            }
        }

}