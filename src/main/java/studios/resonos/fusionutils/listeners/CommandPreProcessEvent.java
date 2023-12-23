package studios.resonos.fusionutils.listeners;

import studios.resonos.fusionutils.managers.PearlManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * @Author: Athishh
 *
 * Package: me.athishh.antipearlabuse.listeners
 * Created on: 12/22/2023
 */
public class CommandPreProcessEvent implements Listener {

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
       // FusionUtils.getPlugin(FusionUtils.class).getLogger().info("#8");
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();
        if (command.startsWith("/spawn")) {
            PearlManager.clearEnderPearls(player);
            event.getPlayer().getInventory().clear();
            event.getPlayer().setHealth(20.0);
            event.getPlayer().getActivePotionEffects().clear();
        }
    }
}
