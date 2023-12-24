package studios.resonos.fusionutils.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import studios.resonos.fusionutils.lib.commandhandler.Command;
import studios.resonos.fusionutils.lib.commandhandler.paramter.Param;

public class StoreCommand {
    @Command(names = {"store"}, permission = "fusion.stire", playerOnly = true)
    public void StoreCommand(Player player) {
        player.sendMessage("Visit our store!");
        TextComponent component = new TextComponent("STORE");
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.fusion-network.xyz/store"));
        player.spigot().sendMessage(component);
    }
}
