package studios.resonos.fusionutils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * @Author: Athishh
 * Package: studios.resonos.fusionutils.listeners
 * Created on: 12/24/2023
 */
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import studios.resonos.fusionutils.utils.CC;

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
        EntityDamageEvent lastDamageCause = event.getEntity().getLastDamageCause();
        String cause = "died";
        if (lastDamageCause instanceof EntityDamageByEntityEvent) {
            switch (lastDamageCause.getCause()) {
                case ENTITY_ATTACK:
                    cause =  " &7was defeated by &x&0&0&e&5&0&0\uD83D\uDDE1 " + event.getEntity().getKiller().getName() + "&7(&x&f&c&0&0&0&0" + ((int) event.getEntity().getKiller().getHealth()) + "&x&f&c&0&0&0&0♥&7)";
                    break;
                case ENTITY_SWEEP_ATTACK:
                    cause =  " &7was defeated by &x&0&0&e&5&0&0\uD83D\uDDE1 " + event.getEntity().getKiller().getName() + "&7(&x&f&c&0&0&0&0" + ((int)  event.getEntity().getKiller().getHealth()) + "&x&f&c&0&0&0&0♥&7)";
                    break;
                case PROJECTILE:
                    cause = " &7was shot by &x&0&0&e&5&0&0\uD83D\uDDE1 " + event.getEntity().getKiller().getName() + "&7(&x&f&c&0&0&0&0" + ((int)  event.getEntity().getKiller().getHealth()) + "&x&f&c&0&0&0&0♥&7)";
                    break;
            }
        } else {
            switch (lastDamageCause.getCause()) {
                case KILL:
                    cause = " &7was killed";
                    break;
                case SUFFOCATION:
                    cause = " &7forgot how to breathe";
                    break;
                case FALL:
                    cause = " &7tried the leap of faith";
                    break;
                case FIRE:
                    cause = " &7just got Roasted";
                    break;
                case LAVA:
                    cause = " &7thought swimming in lava was a good idea";
                    break;
                case DROWNING:
                    cause = " &7never learnt how to swim";
                    break;
                case BLOCK_EXPLOSION:
                    cause = " &7was blown up";
                    break;
                case ENTITY_EXPLOSION:
                    cause = " &7was blown up";
                    break;
                case VOID:
                    cause = " &7fell into to the void";
                    break;
                case LIGHTNING:
                    cause = " &7was struck by lightning";
                    break;
                case SUICIDE:
                    cause = " &7committed suicide";
                    break;
                case STARVATION:
                    cause = " &7was starved to death";
                    break;
                case POISON:
                    cause = " &7was poisoned";
                    break;
                case MAGIC:
                    cause = " &7was killed using magic";
                    break;
                case WITHER:
                    cause = " &7withered away";
                    break;
            }
        }

        Bukkit.broadcastMessage(CC.hex("&x&f&c&0&0&0&0☠ " + event.getEntity().getPlayer().getName() + cause));
    }

    private String getRandomDeathMessage() {
        Random random = new Random();
        return DeathMessages[random.nextInt(DeathMessages.length)];
    }
}