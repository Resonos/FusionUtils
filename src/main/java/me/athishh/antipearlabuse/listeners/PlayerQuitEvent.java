package me.athishh.antipearlabuse.listeners;

import me.athishh.antipearlabuse.managers.PearlManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * @Author: Athishh
 * Package: me.athishh.antipearlabuse.listeners
 * Created on: 12/22/2023
 */

public class PlayerQuitEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
        PearlManager.clearEnderPearls(event.getPlayer());
    }
}
