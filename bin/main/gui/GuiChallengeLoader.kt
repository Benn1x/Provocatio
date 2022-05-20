package gui

import loader.challengeLoader
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.unregister
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder


object GuiChallengeLoader: InventoryHolder{
    var loadAllwaysDown:Boolean = false
    var loadAllwaysUp: Boolean = false
    var loadFrostWalker: Boolean = false
    var loadBoostUp: Boolean = false
    var loadNoCraft: Boolean = false
    fun setDown(set:Boolean){
        when(set){
            true-> loadAllwaysDown = true
            false -> loadAllwaysDown = false

        }
    }
    fun setUp(set:Boolean){
        when(set){
            true-> loadAllwaysUp = true
            false -> loadAllwaysUp = false
        }
    }
    fun setFrostWalk(set:Boolean){
        when(set){
            true-> loadFrostWalker = true
            false -> loadFrostWalker = false
        }
    }
    fun setBoostUp(set:Boolean){
        when(set){
            true-> loadBoostUp = true
            false -> loadBoostUp = false
        }
    }
    fun setNoCraft(set:Boolean){
        when(set){
            true-> loadNoCraft = true
            false -> loadNoCraft = false
        }
    }
    var title = "Challenge Page: ${page.Pages.aktivePage}"
    var Gui: Inventory = Bukkit.createInventory(null,36,title)

    override fun getInventory(): Inventory {
        return page.Pages.Page(Gui,1, title)
    }

}

