package gui

import net.axay.kspigot.items.itemStack
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import net.kyori.adventure.text.TextComponent

class GuiBuilder() {
    fun Item(Gui: Inventory, name: String ,items: Material, slot: Int, amt: Int){
            Gui.addItem(itemStack(items){
                val item = ItemStack(items, amt,)
                val meta = item.itemMeta
                meta.setDisplayName(name)
                Gui.setMaxStackSize(1)
                item.setItemMeta(meta)
                Gui.setItem(slot, item)
            })
        }

        fun GUI(Gui: Inventory,item: List<Material>,name: List<String>,challenges: List<Boolean>) {
            var slots_challenges = 9
            var slots_deko_paper_1 = 0
            var slots_deko_paper_2 = 27

            while(slots_deko_paper_1 != 9){
                Item(Gui,"",Material.PAPER, slots_deko_paper_1,1)
                slots_deko_paper_1 += 1
            }
            item.forEach {
                Item(Gui,name[(slots_challenges-9)],it, slots_challenges,1)
                var slot_challenge_run = challenges[(slots_challenges-9)]
                when(slot_challenge_run){
                    true->Item(Gui,"Challenge Active  ",Material.GREEN_TERRACOTTA, (slots_challenges+9),1)
                    false->Item(Gui,"Challenge Inactive ",Material.RED_TERRACOTTA, (slots_challenges+9),1)
                }
                slots_challenges += 1
            }
            if(slots_challenges != 18){
                while(slots_challenges != 18){
                    Item(Gui,"This slot is empty",Material.BARRIER,slots_challenges,1)
                    Item(Gui,"No Challenge in the Slot above",Material.GRAY_STAINED_GLASS_PANE, (slots_challenges+9),1)
                    slots_challenges += 1
                }
            }
            while(slots_deko_paper_2 != 36) {
                Item(Gui, "", Material.PAPER, slots_deko_paper_2, 1)
                slots_deko_paper_2 += 1
            }
            //Item(Gui,"NextPage",Material.NETHERITE_SHOVEL,35,1)
        }

}