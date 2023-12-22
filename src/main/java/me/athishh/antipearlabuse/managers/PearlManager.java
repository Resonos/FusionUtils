package me.athishh.antipearlabuse.managers;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: Athishh
 * Package: me.athishh.antipearlabuse.listeners.util
 * Created on: 12/22/2023
 */
public class PearlManager {

    public static HashMap<UUID, Projectile> activePearls = new HashMap<>();

    public static void clearEnderPearls(Player player) {
        for (Projectile pearl : activePearls.values()) {
            if ((pearl.getShooter() instanceof Player) && pearl.getShooter().equals(player)) {
                pearl.remove();
            }
        }
    }
}
