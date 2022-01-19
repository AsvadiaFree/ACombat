package eu.asvadia.acombat;


import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Combat extends BukkitRunnable {
    public static HashMap<Player, Long> combatList = new HashMap<>();

    @Override
    public void run() {
        if (combatList != null) {
            new HashMap<>(combatList).forEach((player, number) -> {
                long time = (System.currentTimeMillis() / 1000) - number;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§lCombat §f» §cEn combat (" + (30 - time) + "s)"));

                if (time >= 30)
                    combatList.remove(player);
            });
        }
    }
}
