package page

import gui.GuiBuilder
import gui.GuiChallengeLoader.loadAllwaysDown
import gui.GuiChallengeLoader.loadAllwaysUp
import gui.GuiChallengeLoader.loadBoostUp
import gui.GuiChallengeLoader.loadFrostWalker
import gui.GuiChallengeLoader.loadNoCraft
import loader.challengeLoader
import net.axay.kspigot.event.listen
import net.axay.kspigot.event.unregister
import net.kyori.adventure.text.TextComponent
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object Pages {
    var aktivePage = 1
    fun Page(Gui:Inventory,page:Int,title:String): Inventory {
        val items: List<Material> = listOf(Material.MAGENTA_GLAZED_TERRACOTTA,Material.MAGENTA_GLAZED_TERRACOTTA,Material.ICE,Material.ANVIL,Material.CRAFTING_TABLE)
        val name: List<String> = listOf("AllwaysDown","AllwaysUp","FrostWalker","BoostUp","NoCraft")
        val beschreibung: List<TextComponent> = listOf()
        when(page){
            1->{
                var challenge: List<Boolean> = listOf(loadAllwaysDown,loadAllwaysUp, loadFrostWalker, loadBoostUp, loadNoCraft)
                GuiBuilder().GUI(Gui,items,name,challenge)
                var inv = listen<InventoryClickEvent>{
                    var Items: ItemStack? = it.cursor
                    var invname = it.view.title
                    if(invname == "Challenge Page: 1") {
                        it.setCancelled(true)
                        var allredytriggert = false
                        when (it.slot) {
                            9 -> {
                                if (it.isLeftClick) {
                                    if (allredytriggert == false) {
                                        if (loadAllwaysDown == false) {
                                                challengeLoader().loadallwaysDown()
                                                allredytriggert = true
                                                Gui.clear(9 + 9)
                                                gui.GuiBuilder().Item(Gui, "Challenge Active  ", Material.GREEN_TERRACOTTA, (9 + 9), 1)
                                        }
                                    }

                                    if (allredytriggert == false) {
                                        if (loadAllwaysDown == true) {
                                            challengeLoader().unloadAllwaysDown()
                                            allredytriggert = true
                                            Gui.clear(9 + 9)
                                            gui.GuiBuilder().Item(Gui, "Challenge Inactive ", Material.RED_TERRACOTTA, (9 + 9), 1)
                                        }
                                    }
                                }
                            }
                            10 -> {
                                if (it.isLeftClick) {
                                    if (allredytriggert == false) {
                                        if (loadAllwaysUp == false) {
                                            challengeLoader().loadAllwaysUp()
                                            allredytriggert = true
                                            Gui.clear(10 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Active  ",  Material.GREEN_TERRACOTTA, (10 + 9), 1)
                                        }
                                    }

                                    if (allredytriggert == false) {
                                        if (loadAllwaysUp == true) {
                                            challengeLoader().unloadAllwaysUp()
                                            allredytriggert = true
                                            Gui.clear(10 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Inactive ", Material.RED_TERRACOTTA, (10 + 9), 1)
                                        }
                                    }
                                }
                            }
                            11 -> {
                                if (it.isLeftClick) {
                                    if (allredytriggert == false) {
                                        if (loadFrostWalker == false) {
                                            challengeLoader().loadFrostWalker()
                                            allredytriggert = true
                                            Gui.clear(11 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Active  ", Material.GREEN_TERRACOTTA, (11 + 9), 1)
                                        }
                                    }

                                    if (allredytriggert == false) {
                                        if (loadFrostWalker == true) {
                                            challengeLoader().unloadFrostWalker()
                                            allredytriggert = true
                                            Gui.clear(11 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Inactive ", Material.RED_TERRACOTTA, (11 + 9), 1)
                                        }
                                    }
                                }
                            }
                            12 -> {
                                if (it.isLeftClick) {
                                    if (allredytriggert == false) {
                                        if (loadBoostUp == false) {
                                            challengeLoader().loadBoostUp()
                                            allredytriggert = true
                                            Gui.clear(12 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Active  ", Material.GREEN_TERRACOTTA, (12 + 9), 1)
                                        }
                                    }

                                    if (allredytriggert == false) {
                                        if (loadBoostUp == true) {
                                            challengeLoader().unloadBoostUp()
                                            allredytriggert = true
                                            Gui.clear(12 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Inactive ", Material.RED_TERRACOTTA, (12 + 9), 1)
                                        }
                                    }
                                }
                            }
                            13 -> {
                                if (it.isLeftClick) {
                                    if (allredytriggert == false) {
                                        if (loadNoCraft == false) {
                                            challengeLoader().loadNoCraft()
                                            allredytriggert = true
                                            Gui.clear(13 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Active  ", Material.GREEN_TERRACOTTA, (13 + 9), 1)
                                        }
                                    }

                                    if (allredytriggert == false) {
                                        if (loadNoCraft == true) {
                                            challengeLoader().unloadNoCraft()
                                            allredytriggert = true
                                            Gui.clear(13 + 9)
                                            gui.GuiBuilder()
                                                .Item(Gui, "Challenge Inactive ", Material.RED_TERRACOTTA, (13 + 9), 1)
                                        }
                                    }

                                }

                            }
                            //35->{
                              //  if(it.isLeftClick){
                                //    Page(Gui, aktivePage +1,title)
                                //}
                            //}
                        }

                    }
                }
                var invCloase = listen<InventoryCloseEvent>{
                    var invname = it.view.title
                    if(invname == title){
                        inv.unregister()
                    }
                }
            }
        }
        if(page>1){
            val emptyItems: List<Material> = listOf()
            val emptyName: List<String> = listOf()
            val emptyChallenges: List<Boolean> = listOf()
            GuiBuilder().GUI(Gui,emptyItems,emptyName,emptyChallenges)

        }
        return Gui
    }
}