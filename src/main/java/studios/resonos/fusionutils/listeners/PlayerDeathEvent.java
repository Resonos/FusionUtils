package studios.resonos.fusionutils.listeners;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import studios.resonos.fusionutils.WorldGuardEvents;
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
        UUID uuid = victim.getUniqueId();
        killer.sendTitle(CC.translate("&4⚔"), CC.translate("&2Killed &2" + victim.getName()), 10, 20, 10);
        victim.sendMessage("You have been healed!");
        victim.setHealth(20.0);
        event.setDeathMessage(null);
        EntityDamageEvent lastDamageCause = victim.getLastDamageCause();
        if (lastDamageCause.equals(ENTITY_ATTACK)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7was defeated by &2\uD83D\uDDE1" + killer.getName()));
        } else if (lastDamageCause.equals(PROJECTILE)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7was shot by &2\uD83D\uDDE1" + killer.getName()));
        } else if (lastDamageCause.equals(BLOCK_EXPLOSION)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7was blown to bits"));
        } else if (lastDamageCause.equals(MAGIC)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7was killed using magic"));
        } else if (lastDamageCause.equals(FALL)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7tried the leap of faith"));
        } else if (lastDamageCause.equals(LAVA)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7thought swimming in lava was a good idea"));
        } else if (lastDamageCause.equals(FIRE)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7just got Roasted"));
        } else if (lastDamageCause.equals(DROWNING)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7never learned how to swim"));
        } else if (lastDamageCause.equals(STARVATION)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7forgot to eat"));
        } else if (lastDamageCause.equals(LIGHTNING)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7was struck by lightning"));
        } else if (lastDamageCause.equals(SUFFOCATION)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + "&7forgot how to breathe"));
        } else if (lastDamageCause.equals(VOID)) {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7fell into the void"));
        } else {
            event.setDeathMessage(CC.translate("&4☠ " + victim.getName() + " &7died"));
        }

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
