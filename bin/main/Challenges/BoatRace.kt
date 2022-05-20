package Challenges

import Timer.time
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.particles.particle
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Boat
import org.bukkit.entity.EntityType
import org.bukkit.entity.EntityType.*
import org.bukkit.entity.Player
import org.bukkit.entity.Vehicle
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.vehicle.VehicleEnterEvent
import org.bukkit.event.vehicle.VehicleExitEvent
import org.bukkit.util.Vector

object BoatRace {
    fun register(){
        time.setTimer("Reset")
        boatRaceExit.register()
        boatRaceEnter.register()
        onMove.register()
    }
    fun unregister(){
        boatRaceEnter.unregister()
        boatRaceExit.unregister()
        onMove.unregister()
    }

    var boatRaceEnter = listen<VehicleEnterEvent>{
        if(it.entered.vehicle is Boat){
            time.setTimer("Reset")
            time.setTimer("Running")
        }
    }
    private val onMove = listen<PlayerMoveEvent>{
        val player = it.player
                player.location.particle(Particle.FLAME){
                    amount = 10
                    offset= Vector(0.0,1.0,0.0)
                    extra = 0.1
                }
    }
    var boatRaceExit = listen<VehicleExitEvent>{
        time.setTimer("Stop")

    }
}