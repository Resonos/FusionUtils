package studios.resonos.fusionutils.listeners;

import net.raidstone.wgevents.WorldGuardEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import studios.resonos.fusionutils.utils.CC;

import java.util.UUID;

import static org.bukkit.event.entity.EntityDamageEvent.DamageCause.*;

/**
 * @Author: Athishh
 * Package: studios.resonos.fusionutils.listeners
 * Created on: 12/24/2023
 */
public class PlayerDeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player victim = event.getEntity().getPlayer();
        Player killer = victim.getKiller();
        if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "nethpot")) {
            heal(killer);
            clearInventory(killer);
            giveKit(killer, "Nethpot");
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "arenanethpot")) {
            clearInventory(victim);
            clearInventory(killer);
            giveKit(killer, "Nethpot");
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "diamondpot")) {
            clearInventory(killer);
            giveKit(killer, "diamondpot");
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "opkit")) {
            clearInventory(killer);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "easykits give opkit " + killer.getName());
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "axe")) {
            clearInventory(killer);
            clearInventory(victim);
            giveKit(killer, "axeandshield");
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "axe")) {
            clearInventory(killer);
            clearInventory(victim);
            giveKit(killer, "axeandshield");
        } else if (WorldGuardEvents.isPlayerInAnyRegion(killer.getUniqueId(), "smpkit")) {
            clearInventory(killer);
            clearInventory(victim);
            giveKit(killer, "smpkit");
        }
    }
        private void clearInventory (Player player){
            player.getInventory().clear();
        }
        private void heal (Player player){
            player.getInventory().clear();
        }
        private void giveKit (Player player, String kit){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit give " + kit + " " + player.getName());
    }
}
