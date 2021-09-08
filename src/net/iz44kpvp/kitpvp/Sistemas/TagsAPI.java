package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.plugin.Plugin;
import net.iz44kpvp.kitpvp.Main;
import ca.wacos.nametagedit.NametagAPI;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class TagsAPI
{
    public static void setarTag(final Player p, final String tag) {
        new BukkitRunnable() {
            public void run() {
                p.setDisplayName(String.valueOf(String.valueOf(tag)) + p.getName());
                NametagAPI.setPrefix(p.getName(), tag);
            }
        }.runTaskAsynchronously((Plugin)Main.getInstance());
    }
}
