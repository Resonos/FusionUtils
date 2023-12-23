package studios.resonos.fusionutils.executors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import studios.resonos.fusionutils.FusionUtils;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(sender.isOp() || sender.hasPermission("spawn.admin") || sender.hasPermission("spawn.spawn")){
                    FusionUtils.getInstance().reloadConfig();
                    if (FusionUtils.getInstance().getConfig().getString("spawn.world") != null && FusionUtils.getInstance().getConfig().getString("spawn.x") != null && FusionUtils.getInstance().getConfig().getString("spawn.y") != null && FusionUtils.getInstance().getConfig().getString("spawn.z") != null && FusionUtils.getInstance().getConfig().getString("spawn.yaw") != null && FusionUtils.getInstance().getConfig().getString("spawn.pitch") != null) {
                        World world = Bukkit.getWorld(FusionUtils.getInstance().getConfig().getString("spawn.world"));
                        double x = FusionUtils.getInstance().getConfig().getDouble("spawn.x");
                        double y = FusionUtils.getInstance().getConfig().getDouble("spawn.y");
                        double z = FusionUtils.getInstance().getConfig().getDouble("spawn.z");
                        float yaw = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.yaw");
                        float pitch = (float) FusionUtils.getInstance().getConfig().getDouble("spawn.pitch");

                        Location loc = new Location(world, x, y, z, yaw, pitch);
                        p.teleport(loc);

                        if(Boolean.parseBoolean(FusionUtils.getInstance().getConfig().getString("settings.tpmessage-enable"))){
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', FusionUtils.getInstance().getConfig().getString("messages.tpmessage")));
                        }
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', FusionUtils.getInstance().getConfig().getString("messages.error-nospawnpoint")));
                    }
                }else{
                    p.sendMessage("§cYou do not have permission to execute this command!");
                }
            }else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', FusionUtils.getInstance().getConfig().getString("messages.cmd-spawn-usage")));
            }
        }else{
            sender.sendMessage("This Command can only executed by a player, sorry!");
        }

        return false;
    }

}
