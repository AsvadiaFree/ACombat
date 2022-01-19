package eu.asvadia.acombat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CombatListeners implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!event.isCancelled()
                && event.getEntity() instanceof Player p
                && event.getDamager() instanceof Player d) {
            Combat.combatList.put(p, System.currentTimeMillis()/1000);
            Combat.combatList.put(d, System.currentTimeMillis()/1000);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (Combat.combatList.containsKey(event.getPlayer()))
            event.getPlayer().damage(20);
    }
}
