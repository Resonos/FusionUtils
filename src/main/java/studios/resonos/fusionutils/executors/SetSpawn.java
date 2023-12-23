package studios.resonos.fusionutils.executors;

import studios.resonos.fusionutils.FusionUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if((sender.isOp() || sender.hasPermission("fusion.spawn") || sender.hasPermission("*") || sender.isOp())){
                    FusionUtils.getInstance().reloadConfig();
                    FusionUtils.getInstance().getConfig().set("spawn.world", p.getWorld().getName());
                    FusionUtils.getInstance().getConfig().set("spawn.x", p.getLocation().getX());
                    FusionUtils.getInstance().getConfig().set("spawn.y", p.getLocation().getY());
                    FusionUtils.getInstance().getConfig().set("spawn.z", p.getLocation().getZ());
                    FusionUtils.getInstance().getConfig().set("spawn.yaw", p.getLocation().getYaw());
                    FusionUtils.getInstance().getConfig().set("spawn.pitch", p.getLocation().getPitch());
                    FusionUtils.getInstance().saveConfig();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', FusionUtils.getInstance().getConfig().getString("messages.success-setspawn")));
                }else{
                    p.sendMessage("§cYou do not have permission to execute this command!");
                }
            }else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', FusionUtils.getInstance().getConfig().getString("messages.cmd-setspawn-usage")));
            }
        }else{
            sender.sendMessage("This Command can only executed by a player, sorry!");
        }

        return false;
    }

}
