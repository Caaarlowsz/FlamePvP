package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import net.iz44kpvp.kitpvp.Main;
import org.bukkit.Bukkit;
import java.util.HashSet;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Thor implements Listener
{
    @EventHandler
    public void ThorKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 5);
            final Location loc = p.getTargetBlock((HashSet)null, 30).getLocation();
            p.getWorld().strikeLightning(loc);
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 100L);
        }
    }
}