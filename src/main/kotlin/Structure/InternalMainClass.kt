package main.Structur

import PartyManager.PartyManager
import Timer.time
import command.*
import loader.challengeLoader
import net.axay.kspigot.main.KSpigot
import java.awt.Dimension


class  InternalMainClass : KSpigot() {
    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }

    override fun load() {
        INSTANCE = this
    }

    override fun startup() {
        Logger.Logging().infoLogger("Starting Provocatio-Netzwerk")
        WorldManager.DimensoinTeleport().register()
        getCommand("challenge")?.setExecutor(challenge())
        getCommand("challenge")?.tabCompleter = TabCompletion()
        getCommand("timer")?.setExecutor(timerStart())
        getCommand("timer")?.tabCompleter = TabCompletTimer()
        getCommand("gui")?.setExecutor(GuiForChallenges())
        getCommand("party")?.setExecutor(PartyManager())
        getCommand("debug")?.setExecutor(debug.debug())
        getCommand("position")?.setExecutor(Position.Position())
        getCommand("Teleport")?.setExecutor(tp())
        getCommand("Teleport")?.tabCompleter = TabCompletTp()
        getCommand("delworld")?.tabCompleter = TabCompletTp()
        getCommand("WorldGen")?.setExecutor(worldGen())
        getCommand("delworld")?.setExecutor(delWorld())
        standartMessagnes.DeathMessage.register()
        standartMessagnes.onJoin.register()
        standartMessagnes.onLeave.register()
        challengeLoader().loadAllwaysUp()
        challengeLoader().unloadall()
        time.timer()
    }



    override fun shutdown() {

    }
}
val Manager by lazy { InternalMainClass.INSTANCE }
