import org.bukkit.command.CommandExecutor

class Puma: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender != Player) return false
        if(args.size < 1 || args[0] == "help" || args[0] == "?" || args[0] == "h") {
            sender.sendMessage("§cUsage: /kit <kit-id>")
            sender.dendMessage("§cAvailable kits:")
            sender.sendMessage("§c  - §7Ninja: 1")
            sender.sendMessage("§c  - §7Teufel: 2")
            sender.sendMessage("§c  - §7Builder: 3")
            sender.sendMessage("§c  - §7Tank: 4")
            sender.sendMessage("§c  - §7Standart: 5")
            sender.sendMessage("§c  - §7Enderman: 6")
            sender.sendMessage("§c  - §7rmdMobs: 7")
            sender.sendMessage("§c  - §7TNT: 8")
            sender.sendMessage("§c  - §7WorldSwitcher: 9")
            sender.sendMessage("§c  - §7KB: 10")
            return false
        }
        val p = sender as Player
        var kit = "not Ste"
        args[0]: Int
        when(args[0]){
            1-> {Kit = "Ninja"
                description = "press Sneak and you can tp on top and you have an axt!"
            p.inventory.addItem(ItemStack(Material.DIAMOND_AXE))
            p.sendMessage(Kit.toString())}
            2-> {Kit = "Teufel"
            description = "all your swords have now Fire Aspect and you have Fire-Protection"
            p.sendMessage(Kit.toString())}
            3->{ Kit = "Builder"
            description = "You will get 64 oak-plans + fast-break"
            p.inventory.addItem(ItemStack(Material.OAK_PLANKS , 64))
            p.sendMessage(Kit.toString())}
            4->{ Kit = "Tank"
                description = "Netherrite Chest-Plate and 3/4 Iron"
                p.inventory.chestplate = ItemStack(Material.NETHERITE_CHESTPLATE)
                p.inventory.boots = ItemStack(Material.IRON_BOOTS)
                p.inventory.helmet = ItemStack(Material.IRON_HELMET)
                p.sendMessage(Kit.toString())}
            5 -> {Kit = "Standard"
             description = "Iron-Upgrade"
            if (!(p.inventory.contains(Material.DIAMOND_SWORD)) || !(p.inventory.contains(Material.NETHERITE_SWORD))) {
                p.inventory.addItem(ItemStack(Material.IRON_SWORD))
            }
            p.sendMessage(Kit.toString())}
            6->{
                Kit = "Enderman" // maxhealth = 30 aber blindness and Slowness
                description = "max-health 30 but blind + slow"
                p.maxHealth = 30.0
                p.addPotionEffect(PotionEffect(PotionEffectType.BLINDNESS , 5999 , 1))
                p.addPotionEffect(PotionEffect(PotionEffectType.SLOW , 5999 , 1))
                p.sendMessage(Kit.toString())
            }
            7->{
                Kit = "rmdMOBS" //alle 30sec hat man 10sec Zeit um Mathe-Rätsel zu machen
                description = "rmdMOBS"
                Bukkit.getScheduler().runTaskTimer(this , time2(p) , 0 , 20*10)
                p.sendMessage(Kit.toString())
            }
            8->{
                Kit = "TNT" // TNT RAIN
                description = "TNT-Rain"
                Bukkit.getScheduler().runTaskTimer(this , time3(p) , 0 , 30)
                p.sendMessage(Kit.toString())
            }
            9 -> {
                Kit = "WorldSwitch" // get World now and tps in other world then again back
                description = "get Biome now and tps in other biomes then again back"
                biom = p.world.getBiome(p.location.blockX , p.location.blockY , p.location.blockZ)
                Bukkit.getScheduler().runTaskTimer(this , time4(p) , 0 , 20*60)
                p.sendMessage(Kit.toString())
            }
            10->{
                Kit = "KB" // Player gets more kb
                description = "Player gets more KB"
                p.sendMessage(Kit.toString())}

        }
        return true
    }
    fun time2(p: Player): BukkitRunnable {
        return object : BukkitRunnable() {
            override fun run() {
                p.sendMessage("§c§lRätsel-Runde")
            }
        }
    }
    fun time3(p: Player): BukkitRunnable {
        return object : BukkitRunnable() {
            override fun run() {
                p.world.spawnEntity(p.location , EntityType.PRIMED_TNT)
            }
        }
    }
    fun time4(p: Player): BukkitRunnable {
        return object : BukkitRunnable() {
            override fun run() {
                if(p.world.getBiome(p.location.blockX , p.location.blockY , p.location.blockZ) == biom) {
                    p.teleport(p.world.spawnLocation)
                }
                else {
                    p.teleport(p.world.getHighestBlockAt(p.location.blockX , p.location.blockZ).location)
                }
            }
        }
    }
}