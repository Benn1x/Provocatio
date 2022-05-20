package loader

import Challenges.*
import Timer.time
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import main.Structur.InternalMainClass
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.main.KSpigot
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import kotlin.concurrent.timer

class challengeLoader {
    val tradeClass = noTrade
    val DownClass = allwaysDown
    val UpClass = allwaysUp
    val BoostUpClass = BoostUp
    val noCraft = Challenges.noCraft
    val noSneak = Challenges.noSneak
    var plugin = main.Structur.InternalMainClass
    var frostWalker = FrostWalker
    var time = Timer.time



    fun loadallwaysDown(){
        allwaysDown.register()
        Timer.time.setTimer("Running")
        loadMessage("allwaysDown")
        gui.GuiChallengeLoader.setDown(true)
    }

    fun unloadAllwaysDown(){
        allwaysDown.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("allwaysDown")
        gui.GuiChallengeLoader.setDown(false)
    }
    fun loadAllwaysUp(){
        allwaysUp.register()
        Timer.time.setTimer("Running")
        loadMessage("allwaysUp")
        gui.GuiChallengeLoader.setUp(true)
    }
    fun unloadAllwaysUp(){
        allwaysUp.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("allwaysUp")
        gui.GuiChallengeLoader.setUp(false)
    }
    fun loadBoatRace(){
        BoatRace.register()
        loadMessage("BoatRace")
    }
    fun unloadBoatRace(){
        BoatRace.unregister()
        unloadMessage("BoatRace")
    }
    fun loadBoostUp(){
        BoostUp.register()
        Timer.time.setTimer("Running")
        loadMessage("BoostUp")
        gui.GuiChallengeLoader.setBoostUp(true)
    }
    fun unloadBoostUp(){
        BoostUp.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("BoostUp")
        gui.GuiChallengeLoader.setBoostUp(false)
    }
    fun loadNoCraft(){
        Challenges.noCraft.register()
        Timer.time.setTimer("Running")
        loadMessage("NoCraft")
        gui.GuiChallengeLoader.setNoCraft(true)
    }
    fun unloadNoCraft(){
        Challenges.noCraft.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("noCraft")
        gui.GuiChallengeLoader.setNoCraft(false)
    }
    fun loadNoSneak(){
        Challenges.noSneak.register()
        Timer.time.setTimer("Running")
        loadMessage("noSneak")
    }
    fun unloadNoSneak(){
        Challenges.noSneak.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("NoSneak")
    }
    fun loadNoTrade(){
        noTrade.register()
        Timer.time.setTimer("Running")
        loadMessage("noTrade")
    }
    fun unloadNoTrade(){
        noTrade.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("noTrade")
    }
    fun loadFrostWalker(){
        FrostWalker.register()
        Timer.time.setTimer("Running")
        loadMessage("FrostWalker")
        gui.GuiChallengeLoader.setFrostWalk(true)
    }
    fun unloadFrostWalker(){
        FrostWalker.unregister()
        Timer.time.setTimer("Stop")
        unloadMessage("FrostWalker")
        gui.GuiChallengeLoader.setFrostWalk(false)
    }

    fun unloadall() {
        allwaysDown.unregister()
        allwaysUp.unregister()
        BoostUp.unregister()
        Challenges.noCraft.unregister()
        Challenges.noSneak.unregister()
        noTrade.unregister()
        FrostWalker.unregister()
        BoatRace.unregister()
        Timer.time.setTimer("Stop")
        gui.GuiChallengeLoader.setDown(false)
        gui.GuiChallengeLoader.setUp(false)
        gui.GuiChallengeLoader.setFrostWalk(false)
    }
    fun loadMessage(args: String){
        var Component = MiniMessage.miniMessage().deserialize("<blue>[provocatio-network]</blue><green> loaded Challenge</green> <color:#40ff00>$args</color>")
        onlinePlayers.forEach(){
            it.sendMessage(Component)
        }

    }
    fun unloadMessage(args: String){
        var Component = MiniMessage.miniMessage().deserialize("<blue>[provocatio-network]</blue><red> unloaded Challenge</red> <red>$args</red>")
        onlinePlayers.forEach(){
            it.sendMessage(Component)
        }
    }



}