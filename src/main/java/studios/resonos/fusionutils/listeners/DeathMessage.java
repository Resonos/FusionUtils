package studios.resonos.fusionutils.listeners;

import org.bukkit.event.Listener;

/**
 * @Author: Athishh
 * Package: studios.resonos.fusionutils.listeners
 * Created on: 12/24/2023
 */
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Random;

public class DeathMessage implements Listener {

    private final String[] DeathMessages = {
            " got pranked by ",
            " tried to outsmart ",
            " danced with death and lost to ",
            " challenged fate and lost to ",
            " received a surprise visit from ",
            " took a selfie with death and tagged ",
            " played hide and seek with death, but ",
            " tried to out-dab ",
            " attempted a backflip and landed in front of ",
            " got rekt by ",
            " challenged Chuck Norris and lost to ",
            " went to the wrong neighborhood and met ",
            " was out-memed by ",
            " underestimated the power of ",
            " summoned a creeper and blamed ",
            " became a meme for ",
            " lost a staring contest to ",
            " challenged a wizard and was defeated by ",
            " couldn't handle the swag of ",
            " thought they were a ninja but got ninja'd by ",
            " tried to outrun a snail, but ",
            " played rock-paper-scissors with death and got scissors from ",
            " thought they were in a rom-com but ended up with ",
            " was Rickrolled by ",
            " tried to 1v1 but got 360-no-scoped by ",
            " challenged a cat and lost to ",
            " became a ghost writer for ",
            " faced the wrong way in an Enderman staring contest with ",
            " attempted to joust with a squid and was defeated by ",
            " tried to eat a cactus but got served by ",
            " thought they were in a parkour map but got pranked by ",
            " was photobombed by ",
            " tried to parkour over lava but tripped over ",
            " played the floor is lava and lost to ",
            " challenged a fish to a swimming race and drowned against ",
            " tried to outwit a fox but got outfoxed by ",
            " lost a rap battle to ",
            " thought they were a superhero but got defeated by ",
    };

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            String victimName = event.getEntity().getName();
            String killerName = event.getEntity().getKiller().getName();

            String deathMessage = getRandomDeathMessage() + killerName;
            event.setDeathMessage(victimName + deathMessage);
        } else {
            // Set a default death message for non-player kills
            event.setDeathMessage(event.getEntity().getName() + " died");
        }
    }

    private String getRandomDeathMessage() {
        Random random = new Random();
        return DeathMessages[random.nextInt(DeathMessages.length)];
    }
}