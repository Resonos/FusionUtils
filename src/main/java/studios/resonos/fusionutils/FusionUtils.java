package studios.resonos.fusionutils;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import studios.resonos.fusionutils.executors.SetSpawn;
import studios.resonos.fusionutils.executors.SpawnCommand;
import studios.resonos.fusionutils.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import studios.resonos.fusionutils.tasks.TaskManager;

import java.util.logging.Logger;

public final class  FusionUtils extends JavaPlugin {
    public static FusionUtils plugin;

    @Override
    public void onEnable() {

        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§aFusionCore has been enabled!");
        Bukkit.getConsoleSender().sendMessage("§aDeveloped by Resonos Studios for Fusion Network");
        Bukkit.getConsoleSender().sendMessage(" ");
        this.saveDefaultConfig();
        

        // listeners
        getServer().getPluginManager().registerEvents(new CommandPreProcessEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new ProjectileEvent(), this);
        getServer().getPluginManager().registerEvents(new SpawnEvent(), this);

        getServer().getPluginManager().registerEvents(new DeathMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillListener(), this);
        TaskManager.init();

    }

    @Override
    public void onDisable() {

    }

    public static FusionUtils getInstance(){
        return plugin;
    }
}
