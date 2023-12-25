package studios.resonos.fusionutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import studios.resonos.fusionutils.lib.commandhandler.CommandHandler;
import studios.resonos.fusionutils.listeners.*;
import studios.resonos.fusionutils.tasks.TaskManager;

public final class  FusionUtils extends JavaPlugin {
    public static FusionUtils plugin;

    @Override
    public void onEnable() {
        plugin = this;
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
        CommandHandler.registerProcessors("studios.resonos.fusionutils.commands", this);


        TaskManager.init();

    }

    @Override
    public void onDisable() {

    }

    public static FusionUtils getInstance(){
        return plugin;
    }
}
