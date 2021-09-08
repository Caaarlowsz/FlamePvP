package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import net.iz44kpvp.kitpvp.Main;
import org.bukkit.Bukkit;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import org.bukkit.potion.PotionEffectType;
import net.iz44kpvp.kitpvp.Sistemas.API;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Flash implements Listener
{
    @EventHandler
    public void onFlashUse(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Flash") && (e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON))) {
            if (Gladiator.lutando.containsKey(p.getName()) || Infernor.lutando.containsKey(p.getName())) {
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea n\u00e3o poder usar seu kit no gladiator(infernor) ent\u00e3o vai §aganhar §eum efeito de §afor\u00e7a §ee §aspeed");
                API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
                API.darEfeito(p, PotionEffectType.SPEED, 10, 2);
            }
            else {
                e.setCancelled(true);
                if (Cooldown.add(p)) {
                    API.MensagemCooldown(p);
                    return;
                }
                Cooldown.add(p, 30);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(API.fimcooldown);
                    }
                }, 600L);
                API.darEfeito(p, PotionEffectType.SPEED, 200, 2);
                for (final Entity pertos : p.getNearbyEntities(6.0, 6.0, 6.0)) {
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 2));
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 2));
                }
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea roubou a velocidade dos players perto de voc\u00ea");
            }
        }
    }
}
