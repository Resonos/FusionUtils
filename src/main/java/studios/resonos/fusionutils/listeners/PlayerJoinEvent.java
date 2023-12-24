package studios.resonos.fusionutils.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player= event.getPlayer();
        if(player.hasPlayedBefore()){
            player.getInventory().clear();
            player.getActivePotionEffects().clear();
            player.setHealth(20.0);
        }if(!player.hasPlayedBefore()){
            player.sendMessage("Welcome to Fusion Network!");
        }
    }
}
