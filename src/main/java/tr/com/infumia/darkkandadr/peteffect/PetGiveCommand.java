package tr.com.infumia.darkkandadr.peteffect;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PetGiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            sender.sendMessage("§6[PetEFFECT] §aTrue usage: /peteffect give <blaze,rabbit,magma_cube,miner>");
            return false;
        }
        else if(args.length < 2){
            sender.sendMessage("§6[PetEFFECT] §aTrue usage: /peteffect give <blaze,rabbit,magma_cube,miner>");
            return false;
        }
        else if (sender instanceof Player && label.equalsIgnoreCase("peteffect")) {
            if (args[0].equalsIgnoreCase("give")) {
                if (args[1].equalsIgnoreCase("blaze") || args[1].equalsIgnoreCase("rabbit") || args[1].equalsIgnoreCase("magma_cube") || args[1].equalsIgnoreCase("miner")) {
                    if (args[1].equalsIgnoreCase("blaze")) {
                        giveItem(((Player) sender).getPlayer(), "blaze");
                        sender.sendMessage("§aPet given.");
                    } else if (args[1].equalsIgnoreCase("rabbit")) {
                        giveItem(((Player) sender).getPlayer(), "rabbit");
                        sender.sendMessage("§aPet given.");
                    } else if (args[1].equalsIgnoreCase("magma_cube")) {
                        giveItem(((Player) sender).getPlayer(), "magma_cube");
                        sender.sendMessage("§aPet given.");
                    } else if (args[1].equalsIgnoreCase("miner")) {
                        giveItem(((Player) sender).getPlayer(), "miner");
                        sender.sendMessage("§aPet given.");
                    }
                } else {
                    sender.sendMessage("§6[PetEFFECT] §cPet name list: blaze, rabbit, magma_cube, miner");
                }
                return true;
            }
        }
        return false;
    }

    public void giveItem(Player player, String type){
        if(type.equalsIgnoreCase("blaze")){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setDisplayName("§6Blaze Pet");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7It's time to meet the Blaze power!");
            lore.add("§eThis item gives you §lSTRENGTH 2 §eeffect.");
            skull.setLore(lore);
            skull.setOwner("MHF_Blaze");
            item.setItemMeta(skull);
            Bukkit.getPlayer(player.getName()).getInventory().addItem(item);
        }
        else if(type.equalsIgnoreCase("rabbit")){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setDisplayName("§aRabbit Pet");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7Using the agility of rabbits is very functional.");
            lore.add("§eThis item gives you §lSPEED 2 §eeffect.");
            skull.setLore(lore);
            skull.setOwner("MHF_Rabbit");
            item.setItemMeta(skull);
            Bukkit.getPlayer(player.getName()).getInventory().addItem(item);
        }
        else if(type.equalsIgnoreCase("magma_cube")){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setDisplayName("§cMagma Cube Pet");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7Confers the fire resistance power of magma cubes!");
            lore.add("§eThis item gives you §lFIRE RESISTANCE §eeffect.");
            skull.setLore(lore);
            skull.setOwner("Magma_Cube");
            item.setItemMeta(skull);
            Bukkit.getPlayer(player.getName()).getInventory().addItem(item);
        }
        else if(type.equalsIgnoreCase("miner")){
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta skull = (SkullMeta) item.getItemMeta();
            skull.setDisplayName("§bMiner Pet");
            ArrayList<String> lore = new ArrayList<>();
            lore.add("§7The miners powers are concentrated in this item.");
            lore.add("§This item gives you §lHASTE 3 and Night Vision §eeffect.");
            skull.setLore(lore);
            skull.setOwner("Miner");
            item.setItemMeta(skull);
            Bukkit.getPlayer(player.getName()).getInventory().addItem(item);
        }
    }
}
