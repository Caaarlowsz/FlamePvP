package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import ca.wacos.nametagedit.NametagAPI;
import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;

public class TagsAPI {
	public static void setarTag(final Player p, final String tag) {
		new BukkitRunnable() {
			public void run() {
				p.setDisplayName(String.valueOf(String.valueOf(tag)) + p.getName());
				NametagAPI.setPrefix(p.getName(), tag);
			}
		}.runTaskAsynchronously(FlamePvP.getInstance());
	}
}
