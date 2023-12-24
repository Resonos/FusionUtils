package studios.resonos.fusionutils;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import studios.resonos.fusionutils.executors.SetSpawn;
import studios.resonos.fusionutils.executors.SpawnCommand;
import studios.resonos.fusionutils.listeners.CommandPreProcessEvent;
import studios.resonos.fusionutils.listeners.PlayerQuitEvent;
import studios.resonos.fusionutils.listeners.ProjectileEvent;
import studios.resonos.fusionutils.listeners.SpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import studios.resonos.fusionutils.tasks.TaskManager;

import java.util.logging.Logger;

public final class  FusionUtils extends JavaPlugin {
    public static FusionUtils plugin;
    static RegionContainer container;

    @Override
    public void onEnable() {
        Logger log = Bukkit.getLogger();
        PluginManager pm = Bukkit.getPluginManager();
        Plugin p = Bukkit.getPluginManager().getPlugin("WorldGuard");

        if (p == null) {
            log.severe("[WorldGuardEvents] WorldGuard wasn't found. Disabling WorldGuardEvents.");
            pm.disablePlugin(FusionUtils.getInstance());
            return;
        }

        String version = WorldGuard.getVersion();

        if (version.isEmpty()) {
            log.severe("[WorldGuardEvents] WorldGuard's version not detected. Are you sure it's installed properly ?");
            log.severe("[WorldGuardEvents] Disabling WorldGuardEvents.");

            pm.disablePlugin(FusionUtils.getInstance());
            return;
        }

        if (!version.startsWith("7.")) {
            log.warning("[WorldGuardEvents] Detected WorldGuard version \"" + version + "\".");
            log.warning("[WorldGuardEvents] This plugin is meant to work with WorldGuard version \"7.0.0\" or higher,");
            log.warning("[WorldGuardEvents] and may not work properly with any other major revision.");
            log.warning("[WorldGuardEvents] Please update WorldGuard if your version is below \"7.0.0\" or wait for");
            log.warning("[WorldGuardEvents] an update of WorldGuardEvents to support WorldGuard "+version+".");
        }

        if (!WorldGuard.getInstance().getPlatform().getSessionManager().registerHandler(Entry.factory, null)) {
            log.severe("[WorldGuardEvents] Could not register the entry handler !");
            log.severe("[WorldGuardEvents] Please report this error. The plugin will now be disabled.");

            pm.disablePlugin(FusionUtils.getInstance());
            return;
        }

        container = WorldGuard.getInstance().getPlatform().getRegionContainer();

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
        TaskManager.init();

    }

    @Override
    public void onDisable() {
        container = null;
    }

    public static FusionUtils getInstance(){
        return plugin;
    }
}
