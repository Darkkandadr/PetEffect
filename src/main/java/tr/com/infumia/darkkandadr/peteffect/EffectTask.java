package tr.com.infumia.darkkandadr.peteffect;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectTask implements Runnable{        

    private final String playerName;

    EffectTask(String player_name){
        playerName = player_name;
    }

    @Override
    public void run(){
        Player player = Bukkit.getPlayer(playerName);
        if (player != null && player.isOnline()){
            ItemControl(player);
        }
    }

    public void ItemControl(Player player){
        if(player != null && player.isOnline()){
            int x = 0;
            while (x < 9){
                if (player.getInventory().getItem(x) != null && player.getInventory().getItem(x).getItemMeta() != null && player.getInventory().getItem(x).getItemMeta().getDisplayName() != null){
                    if (player.getInventory().getItem(x).getItemMeta().getDisplayName().equalsIgnoreCase("§6Blaze Pet") && !player.getActivePotionEffects().contains(PotionEffectType.INCREASE_DAMAGE)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
                    }
                    if(player.getInventory().getItem(x).getItemMeta().getDisplayName().equalsIgnoreCase("§aRabbit Pet") && !player.getActivePotionEffects().contains(PotionEffectType.SPEED)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
                    }
                    if(player.getInventory().getItem(x).getItemMeta().getDisplayName().equalsIgnoreCase("§cMagma Cube Pet") && !player.getActivePotionEffects().contains(PotionEffectType.FIRE_RESISTANCE)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0));
                    }
                    if(player.getInventory().getItem(x).getItemMeta().getDisplayName().equalsIgnoreCase("§bMiner Pet") && !player.getActivePotionEffects().contains(PotionEffectType.FAST_DIGGING)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 2));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 0));
                    }
                }
                x++;
            }
        }
    }
}
