package Challenges

import Timer.time
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.Material
import org.bukkit.entity.Boat
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.event.vehicle.VehicleEnterEvent
import org.bukkit.event.vehicle.VehicleExitEvent

object FrostWalker {
    var boat = false
    var frostWalk = true
    var allredytriggerd = false
    fun register(){
        onMove.register()
        onSneak.register()
        //boatEnter.register()
        boatRaceExit.register()
    }

    fun unregister() {
        onMove.unregister()
        onSneak.unregister()
        boatEnter.unregister()
        boatRaceExit.unregister()
    }

    private val onMove = listen<PlayerMoveEvent>{
        val player = it.player
        if(frostWalk == false){
        }
            if (frostWalk == true) {
                if(boat == false) {
                    var loc = player.getLocation().add(0.0, -1.0, 0.0)
                    var loc1 = player.getLocation().add(-1.0, -1.0, 0.0)
                    var loc2 = player.getLocation().add(0.0, -1.0, -1.0)
                    var loc3 = player.getLocation().add(1.0, -1.0, 0.0)
                    var loc4 = player.getLocation().add(0.0, -1.0, 1.0)
                    var loc5 = player.getLocation().add(1.0, -1.0, 1.0)
                    var loc6 = player.getLocation().add(-1.0, -1.0, -1.0)
                    var loc7 = player.getLocation().add(-1.0, -1.0, 1.0)
                    var loc8 = player.getLocation().add(1.0, -1.0, -1.0)
                    var loc9 = player.getLocation().add(2.0, -1.0, 0.0)
                    var loc10 = player.getLocation().add(-2.0, -1.0, 0.0)
                    var loc11 = player.getLocation().add(0.0, -1.0, -2.0)
                    var loc12 = player.getLocation().add(0.0, -1.0, 2.0)
                    loc.getBlock().setType(Material.ICE)
                    loc1.getBlock().setType(Material.ICE)
                    loc2.getBlock().setType(Material.ICE)
                    loc3.getBlock().setType(Material.ICE)
                    loc4.getBlock().setType(Material.ICE)
                    loc5.getBlock().setType(Material.ICE)
                    loc6.getBlock().setType(Material.ICE)
                    loc7.getBlock().setType(Material.ICE)
                    loc8.getBlock().setType(Material.ICE)
                    loc9.getBlock().setType(Material.ICE)
                    loc10.getBlock().setType(Material.ICE)
                    loc11.getBlock().setType(Material.ICE)
                    loc12.getBlock().setType(Material.ICE)
                }
                if(boat == true){
                    var loc = player.getLocation().add(0.0, -0.0, 0.0)
                    var loc1 = player.getLocation().add(-1.0, -0.0, 0.0)
                    var loc2 = player.getLocation().add(0.0, -0.0, -1.0)
                    var loc3 = player.getLocation().add(1.0, -0.0, 0.0)
                    var loc4 = player.getLocation().add(0.0, -0.0, 1.0)
                    var loc5 = player.getLocation().add(1.0, -0.0, 1.0)
                    var loc6 = player.getLocation().add(-1.0, -0.0, -1.0)
                    var loc7 = player.getLocation().add(-1.0, -0.0, 1.0)
                    var loc8 = player.getLocation().add(1.0, -0.0, -1.0)
                    var loc9 = player.getLocation().add(2.0, -0.0, 0.0)
                    var loc10 = player.getLocation().add(-2.0, 0.0, 0.0)
                    var loc11 = player.getLocation().add(0.0, -0.0, -2.0)
                    var loc12 = player.getLocation().add(0.0, -0.0, 2.0)
                    loc.getBlock().setType(Material.ICE)
                    loc1.getBlock().setType(Material.ICE)
                    loc2.getBlock().setType(Material.ICE)
                    loc3.getBlock().setType(Material.ICE)
                    loc4.getBlock().setType(Material.ICE)
                    loc5.getBlock().setType(Material.ICE)
                    loc6.getBlock().setType(Material.ICE)
                    loc7.getBlock().setType(Material.ICE)
                    loc8.getBlock().setType(Material.ICE)
                    loc9.getBlock().setType(Material.ICE)
                    loc10.getBlock().setType(Material.ICE)
                    loc11.getBlock().setType(Material.ICE)
                    loc12.getBlock().setType(Material.ICE)
                }
                }
            }
    var boatEnter = listen<VehicleEnterEvent>{
        boat = true
    }
    var boatRaceExit = listen<VehicleExitEvent>{
        boat = false

    }
    private val onSneak = listen<PlayerToggleSneakEvent> {
        if(it.isSneaking){
            if(allredytriggerd == false) if(frostWalk == false) {
                frostWalk = true
                allredytriggerd = true
            }
            if(allredytriggerd == false) if(frostWalk == true){
                frostWalk = false
                allredytriggerd = true
            }
            onlinePlayers.forEach() {
                if(frostWalk == true) it.sendMessage("FrostWalk is now active")
                if(frostWalk == false) it.sendMessage("FrostWalk is now disabled")
            }
        }

    allredytriggerd = false
    }
}