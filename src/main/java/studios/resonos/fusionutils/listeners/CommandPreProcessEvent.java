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
         if (command.startsWith("/kits")) {
            if(!(player.hasPermission("fusion.playerkits.kits"))) {
                event.setCancelled(true);
            }
        } else if (command.startsWith("/playerkits")) {
            if(!(player.hasPermission("fusion.playerkits.playerkits"))) {
                event.setCancelled(true);
            }
        }
    }
}
