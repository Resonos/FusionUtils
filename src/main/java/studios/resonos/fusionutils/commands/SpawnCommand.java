package studios.resonos.fusionutils.commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import studios.resonos.fusionutils.FusionUtils;
import studios.resonos.fusionutils.lib.commandhandler.Command;
import studios.resonos.fusionutils.utils.LocationUtil;

import java.util.Objects;

/**
 * @Author: Athishh
 * Package: studios.resonos.fusionutils.commands
 * Created on: 12/25/2023
 */
public class SpawnCommand {

    @Command(names = "spawn", permission = "fusion.spawn", playerOnly = true)
    public void onCommand(Player player) {
        player.teleport(Objects.requireNonNull(LocationUtil.deserialize(FusionUtils.getInstance().getConfig().getString("spawn"))));
    }
}
