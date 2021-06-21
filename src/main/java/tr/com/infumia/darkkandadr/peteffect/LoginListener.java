package tr.com.infumia.darkkandadr.peteffect;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;


public class LoginListener implements Listener {

    private final Peteffect plugin = Peteffect.getPlugin(Peteffect.class);
    private HashMap<String, Integer> map = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!map.containsKey(event.getPlayer().getName())){
            int schedule = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new EffectTask(event.getPlayer().getName()), 0, 200);
            map.put(event.getPlayer().getName(), schedule);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if(map.containsKey(event.getPlayer().getName())){
            Bukkit.getScheduler().cancelTask(map.get(event.getPlayer().getName()));
            map.remove(event.getPlayer().getName());
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event){
        if (event.getItemInHand() == null) return;
        if (event.getItemInHand().getItemMeta() == null) return;
        if (event.getItemInHand().getItemMeta().getDisplayName() == null) return;
        if (event.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Blaze Pet")){
            event.setCancelled(true);
        }
        else if (event.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aRabbit Pet")){
            event.setCancelled(true);
        }
        else if (event.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cMagma Cube Pet")){
            event.setCancelled(true);
        }
        else if (event.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bMiner Pet")){
            event.setCancelled(true);
        }
    }
}
