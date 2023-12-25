package studios.resonos.fusionutils.commands;

import org.bukkit.entity.Player;
import studios.resonos.fusionutils.FusionUtils;
import studios.resonos.fusionutils.lib.commandhandler.Command;
import studios.resonos.fusionutils.utils.LocationUtil;

public class SetSpawn {
    @Command(names = {"setspawn"}, permission = "fusion.setspawn", playerOnly = true)
    public void Command(Player player) {
        player.sendMessage("You have set the spawn.");
        FusionUtils.getInstance().getConfig().set("spawn", LocationUtil.serialize(player.getLocation()));
    }
}
