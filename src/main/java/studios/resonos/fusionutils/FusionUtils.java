package studios.resonos.fusionutils;

import studios.resonos.fusionutils.executors.SetSpawn;
import studios.resonos.fusionutils.executors.SpawnCommand;
import studios.resonos.fusionutils.listeners.CommandPreProcessEvent;
import studios.resonos.fusionutils.listeners.PlayerQuitEvent;
import studios.resonos.fusionutils.listeners.ProjectileEvent;
import studios.resonos.fusionutils.listeners.SpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class  FusionUtils extends JavaPlugin {
    public static FusionUtils plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§aFusionUtils has been enabled!");
        Bukkit.getConsoleSender().sendMessage("§aDeveloped by Resonos Studios for Fusion Network");
        Bukkit.getConsoleSender().sendMessage(" ");
        this.saveDefaultConfig();

        //commands
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new SpawnCommand());

        // listeners
        getServer().getPluginManager().registerEvents(new CommandPreProcessEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new ProjectileEvent(), this);
        getServer().getPluginManager().registerEvents(new SpawnEvent(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static FusionUtils getInstance(){
        return plugin;
    }
}
