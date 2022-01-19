package eu.asvadia.acombat;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        new Combat().runTaskTimer(this, 20, 20);

        getServer().getPluginManager().registerEvents(new CombatListeners(), this);
    }
}
