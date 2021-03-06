package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Terrorista implements Listener {
	@EventHandler
	public void aoterrorista(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.MAGMA_CREAM) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			p.setVelocity(p.getLocation().getDirection().setY(6));
			p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 15);
			p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			Cooldown.add(p, 25);
			Bukkit.getScheduler().scheduleSyncDelayedTask(FlamePvP.getInstance(), new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 500L);
		}
	}

	@EventHandler
	public void naodanoexplosion(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
				return;
			}
			if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista")) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void stomper(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		final Player p = (Player) event.getEntity();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista") && event.getDamage() >= 8.0) {
			event.setDamage(8.0);
			for (final Entity e : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				if (e instanceof Player && !((Player) e).isSneaking()) {
					p.getWorld().createExplosion(p.getLocation(), 3.0f);
				}
			}
		}
	}
}
