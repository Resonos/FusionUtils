package me.athishh.antipearlabuse;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiPearlAbuse extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§aAntiPearlAbuse has been enabled!");
        Bukkit.getConsoleSender().sendMessage("§aDeveloped by Athishh");
        Bukkit.getConsoleSender().sendMessage(" ");
        getServer().getPluginManager().registerEvents(new me.athishh.antipearlabuse.listeners.CommandPreProcessEvent(), this);
        getServer().getPluginManager().registerEvents(new me.athishh.antipearlabuse.listeners.PlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new me.athishh.antipearlabuse.listeners.ProjectileEvent(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
