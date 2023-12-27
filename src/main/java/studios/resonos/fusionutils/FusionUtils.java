package studios.resonos.fusionutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import studios.resonos.fusionutils.commands.SetSpawn;
import studios.resonos.fusionutils.commands.SpawnCommand;
import studios.resonos.fusionutils.commands.StoreCommand;
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

        CommandHandler.registerCommands(SetSpawn.class, this);
        CommandHandler.registerCommands(SpawnCommand.class, this);
        CommandHandler.registerCommands(StoreCommand.class, this);


        TaskManager.init();

    }

    @Override
    public void onDisable() {

    }

    public static FusionUtils getInstance(){
        return plugin;
    }
}
