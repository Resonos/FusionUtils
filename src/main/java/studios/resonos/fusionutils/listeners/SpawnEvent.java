package studios.resonos.fusionutils.listeners;

import studios.resonos.fusionutils.FusionUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class SpawnEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        FusionUtils.getInstance().reloadConfig();

        if(!e.getPlayer().hasPlayedBefore()){
            if (FusionUtils.getInstance().getConfig().getString("spawn.world") != null && FusionUtils.getInstance().getConfig().getString("spawn.x") != null && FusionUtils.getInstance().getConfig().getString("spawn.y") != null && FusionUtils.getInstance().getConfig().getString("spawn.z") != null && FusionUtils.getInstance().getConfig().getString("spawn.yaw") != null && FusionUtils.getInstance().getConfig().getString("spawn.pitch") != null){
                World world = Bukkit.getWorld(FusionUtils.getInstance().getConfig().getString("spawn.world"));
                double x = FusionUtils.getInstance().getConfig().getDouble("spawn.x");
                double y = FusionUtils.getInstance().getConfig().getDouble("spawn.y");
                double z = FusionUtils.getInstance().getConfig().getDouble("spawn.z");
                float yaw = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.yaw");
                float pitch = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.pitch");

                Location loc = new Location(world, x, y, z, yaw, pitch);
                e.getPlayer().teleport(loc);
            }
        }else{
            if(Boolean.parseBoolean(FusionUtils.getInstance().getConfig().getString("settings.spawn-on-join"))){
                if (FusionUtils.getInstance().getConfig().getString("spawn.world") != null && FusionUtils.getInstance().getConfig().getString("spawn.x") != null && FusionUtils.getInstance().getConfig().getString("spawn.y") != null && FusionUtils.getInstance().getConfig().getString("spawn.z") != null && FusionUtils.getInstance().getConfig().getString("spawn.yaw") != null && FusionUtils.getInstance().getConfig().getString("spawn.pitch") != null){
                    World world = Bukkit.getWorld(FusionUtils.getInstance().getConfig().getString("spawn.world"));
                    double x = FusionUtils.getInstance().getConfig().getDouble("spawn.x");
                    double y = FusionUtils.getInstance().getConfig().getDouble("spawn.y");
                    double z = FusionUtils.getInstance().getConfig().getDouble("spawn.z");
                    float yaw = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.yaw");
                    float pitch = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    e.getPlayer().teleport(loc);
                }
            }
        }
    }

}
