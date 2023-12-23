package studios.resonos.fusionutils.listeners;

import studios.resonos.fusionutils.managers.PearlManager;
import org.bukkit.Bukkit;
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
       // FusionUtils.getPlugin(FusionUtils.class).getLogger().info("#7");
        Bukkit.getConsoleSender().sendMessage("Player quit detected. Removing pearl of "+event.getPlayer().getName());
    }
}
