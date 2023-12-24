package studios.resonos.fusionutils.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @Author: Athishh
 * Package: studios.resonos.fusionutils.tasks
 * Created on: 12/24/2023
 */
public class ArenaResetTask extends BukkitRunnable {


    @Override
    public void run() {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "platinumarenas:arena reset terrain fast");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "platinumarenas:arena reset lifesteal veryfast");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "platinumarenas:arena reset manhunt veryfast");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "platinumarenas:arena reset uhc veryfast");
    }
}
