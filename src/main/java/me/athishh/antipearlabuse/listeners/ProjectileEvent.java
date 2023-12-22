package me.athishh.antipearlabuse.listeners;

import me.athishh.antipearlabuse.AntiPearlAbuse;
import me.athishh.antipearlabuse.managers.PearlManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

/**
 * @Author: Athishh
 * Package: me.athishh.antipearlabuse.listeners
 * Created on: 12/22/2023
 */
public class ProjectileEvent implements Listener {


    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        //AntiPearlAbuse.getPlugin(AntiPearlAbuse.class).getLogger().info("#5");
        Projectile projectile = event.getEntity();
        if (projectile instanceof org.bukkit.entity.EnderPearl) {
            PearlManager.activePearls.put(projectile.getUniqueId(), projectile);
            Bukkit.getConsoleSender().sendMessage("Projectile launch detected from " +event.getEntity().getName());
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
       // AntiPearlAbuse.getPlugin(AntiPearlAbuse.class).getLogger().info("#6");
        Projectile projectile = event.getEntity();
        if (projectile instanceof org.bukkit.entity.EnderPearl) {
            PearlManager.activePearls.remove(projectile.getUniqueId());
            Bukkit.getConsoleSender().sendMessage("Projectile removed. Projectile of " +event.getEntity().getName());
        }
    }
}
