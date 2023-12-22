package me.athishh.antipearlabuse.listeners;

import me.athishh.antipearlabuse.managers.PearlManager;
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
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();
        if (command.startsWith("/spawn")) {
            PearlManager.clearEnderPearls(player);
        }
    }
}
