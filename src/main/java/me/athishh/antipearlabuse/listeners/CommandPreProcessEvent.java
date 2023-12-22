package me.athishh.antipearlabuse.listeners;

import me.athishh.antipearlabuse.AntiPearlAbuse;
import me.athishh.antipearlabuse.managers.PearlManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * @Author: Athishh
 * Package: me.athishh.antipearlabuse.listeners
 * Created on: 12/22/2023
 */
public class CommandPreProcessEvent implements Listener {

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
       // AntiPearlAbuse.getPlugin(AntiPearlAbuse.class).getLogger().info("#8");
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();
        if (command.startsWith("/spawn")) {
            PearlManager.clearEnderPearls(player);
            Bukkit.getConsoleSender().sendMessage("Player /spawn command detected.. Removing pearl of "+event.getPlayer().getName());
            //AntiPearlAbuse.getPlugin(AntiPearlAbuse.class).getLogger().info("#9");
        }
    }
}
