package tr.com.infumia.darkkandadr.peteffect;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Peteffect extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new LoginListener(), this);
        getCommand("peteffect").setExecutor(new PetGiveCommand());
    }
}
