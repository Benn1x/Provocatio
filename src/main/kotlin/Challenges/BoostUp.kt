package Challenges

import net.axay.kspigot.event.listen
import net.axay.kspigot.event.register
import net.axay.kspigot.event.unregister
import net.axay.kspigot.particles.particle
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.util.Vector

object BoostUp {
    fun register(){
        onMove.register()
    }
    fun unregister() {
        onMove.unregister()
    }



    private val onMove = listen<PlayerMoveEvent>{
        val player = it.player
        player.getNearbyEntities(10.0,10.0,10.0).forEach{ entity ->
            if ( entity !is Player ){
                player.playSound(entity.location,Sound.BLOCK_RESPAWN_ANCHOR_DEPLETE,0.25f,1f)
                entity.velocity = entity.velocity.clone().add(Vector(0,2,0))
                entity.location.particle(Particle.FLAME){
                    amount = 150
                    offset=Vector(1.0,1.0,1.0)
                    extra = 0.1
                }
            }
        }
    }

}
