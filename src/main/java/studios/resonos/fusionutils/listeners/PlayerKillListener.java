package studios.resonos.fusionutils.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import studios.resonos.fusionutils.FusionUtils;

public class PlayerKillListener implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event){
        Player killer=event.getEntity().getKiller();
        Player victim=event.getEntity().getPlayer();
        killer.sendMessage("You have been healed!");
        killer.setHealth(20.0);
    }
}
