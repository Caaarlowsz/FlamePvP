package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Gun implements Listener {
	public static HashMap<Player, Integer> guntiros;

	static {
		Gun.guntiros = new HashMap<Player, Integer>();
	}

	@EventHandler
	public void ar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Gun")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.WOOD_HOE) {
			e.setCancelled(true);
			if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 2) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(FlamePvP.getInstance(), new Runnable() {
					@Override
					public void run() {
						Gun.guntiros.remove(p);
						p.sendMessage(API.fimcooldown);
					}
				}, 400L);
			}
			if (Gun.guntiros.containsKey(p) && Gun.guntiros.get(p) == 3) {
				if (Cooldown.add(p)) {
					API.MensagemCooldown(p);
					return;
				}
				Cooldown.add(p, 20);
			} else if (!Gun.guntiros.containsKey(p)) {
				Gun.guntiros.put(p, 1);
			} else {
				Gun.guntiros.put(p, Gun.guntiros.get(p) + 1);
			}
			Location loc = p.getLocation().add(0.0, 1.5, 0.0);
			for (int i = 0; i <= 240; ++i) {
				loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY() - 0.05, loc.getDirection().getZ());
				p.getWorld().playEffect(loc, Effect.COLOURED_DUST, 15);
				for (final Entity ent : this.getEntitiesByLocation(loc, 1.0f)) {
					if (ent instanceof LivingEntity && ent != p) {
						((LivingEntity) ent).damage(7.0);
					}
				}
				if (loc.getBlock().getType().isSolid()) {
					break;
				}
			}
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 2.0f, 2.0f);
		}
	}

	private List<Entity> getEntitiesByLocation(final Location loc, final float r) {
		final List<Entity> ent = new ArrayList<Entity>();
		for (final Entity e : loc.getWorld().getEntities()) {
			if (e.getLocation().distanceSquared(loc) <= r) {
				ent.add(e);
			}
		}
		return ent;
	}
}
