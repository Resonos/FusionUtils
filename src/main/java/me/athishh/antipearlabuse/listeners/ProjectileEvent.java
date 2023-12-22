package me.athishh.antipearlabuse.listeners;

import me.athishh.antipearlabuse.managers.PearlManager;
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
        Projectile projectile = event.getEntity();
        if (projectile instanceof org.bukkit.entity.EnderPearl) {
            PearlManager.activePearls.put(projectile.getUniqueId(), projectile);
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile instanceof org.bukkit.entity.EnderPearl) {
            PearlManager.activePearls.remove(projectile.getUniqueId());
        }
    }
}
