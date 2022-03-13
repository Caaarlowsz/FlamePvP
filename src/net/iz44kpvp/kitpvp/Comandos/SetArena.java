package net.iz44kpvp.kitpvp.Comandos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class SetArena implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(API.semconsole);
			return true;
		}
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("setarena")) {
			if (p.hasPermission("kitpvp.staff")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "Sintaxe correta: /setarena (1|5)");
					return true;
				}
				if (args[0].equalsIgnoreCase("1")) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoc\u00ea setou a ARENA 1");
					FlamePvP.getInstance().arenas.set("arena1.x", p.getLocation().getX());
					FlamePvP.getInstance().arenas.set("arena1.y", p.getLocation().getY());
					FlamePvP.getInstance().arenas.set("arena1.z", p.getLocation().getZ());
					p.getWorld();
					FlamePvP.getInstance().arenas.set("arena1.pitch", p.getLocation().getPitch());
					FlamePvP.getInstance().arenas.set("arena1.yaw", p.getLocation().getYaw());
					FlamePvP.getInstance().arenas.set("arena1.world", p.getLocation().getWorld().getName());
					FlamePvP.getInstance().save();
				}
				if (args[0].equalsIgnoreCase("2")) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoc\u00ea setou a ARENA 2");
					FlamePvP.getInstance().arenas.set("arena2.x", p.getLocation().getX());
					FlamePvP.getInstance().arenas.set("arena2.y", p.getLocation().getY());
					FlamePvP.getInstance().arenas.set("arena2.z", p.getLocation().getZ());
					p.getWorld();
					FlamePvP.getInstance().arenas.set("arena2.pitch", p.getLocation().getPitch());
					FlamePvP.getInstance().arenas.set("arena2.yaw", p.getLocation().getYaw());
					FlamePvP.getInstance().arenas.set("arena2.world", p.getLocation().getWorld().getName());
					FlamePvP.getInstance().save();
				}
				if (args[0].equalsIgnoreCase("3")) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoc\u00ea setou a ARENA 3");
					FlamePvP.getInstance().arenas.set("arena3.x", p.getLocation().getX());
					FlamePvP.getInstance().arenas.set("arena3.y", p.getLocation().getY());
					FlamePvP.getInstance().arenas.set("arena3.z", p.getLocation().getZ());
					p.getWorld();
					FlamePvP.getInstance().arenas.set("arena3.pitch", p.getLocation().getPitch());
					FlamePvP.getInstance().arenas.set("arena3.yaw", p.getLocation().getYaw());
					FlamePvP.getInstance().arenas.set("arena3.world", p.getLocation().getWorld().getName());
					FlamePvP.getInstance().save();
				}
				if (args[0].equalsIgnoreCase("4")) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoc\u00ea setou a ARENA 4");
					FlamePvP.getInstance().arenas.set("arena4.x", p.getLocation().getX());
					FlamePvP.getInstance().arenas.set("arena4.y", p.getLocation().getY());
					FlamePvP.getInstance().arenas.set("arena4.z", p.getLocation().getZ());
					p.getWorld();
					FlamePvP.getInstance().arenas.set("arena4.pitch", p.getLocation().getPitch());
					FlamePvP.getInstance().arenas.set("arena4.yaw", p.getLocation().getYaw());
					FlamePvP.getInstance().arenas.set("arena4.world", p.getLocation().getWorld().getName());
					FlamePvP.getInstance().save();
				}
				if (args[0].equalsIgnoreCase("5")) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoc\u00ea setou a ARENA 5");
					FlamePvP.getInstance().arenas.set("arena5.x", p.getLocation().getX());
					FlamePvP.getInstance().arenas.set("arena5.y", p.getLocation().getY());
					FlamePvP.getInstance().arenas.set("arena5.z", p.getLocation().getZ());
					p.getWorld();
					FlamePvP.getInstance().arenas.set("arena5.pitch", p.getLocation().getPitch());
					FlamePvP.getInstance().arenas.set("arena5.yaw", p.getLocation().getYaw());
					FlamePvP.getInstance().arenas.set("arena5.world", p.getLocation().getWorld().getName());
					FlamePvP.getInstance().save();
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}

	public static void TeleportArenaRandom(final Player p) {
		final Random dice = new Random();
		final int number = dice.nextInt(4);
		switch (number) {
		case 0: {
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().arenas.getString("arena1.world"));
			final double x = FlamePvP.getInstance().arenas.getDouble("arena1.x");
			final double y = FlamePvP.getInstance().arenas.getDouble("arena1.y");
			final double z = FlamePvP.getInstance().arenas.getDouble("arena1.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().arenas.getDouble("arena1.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().arenas.getDouble("arena1.yaw"));
			p.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
			p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			p.teleport(lobby);
			break;
		}
		case 1: {
			final World w2 = Bukkit.getServer().getWorld(FlamePvP.getInstance().arenas.getString("arena2.world"));
			final double x2 = FlamePvP.getInstance().arenas.getDouble("arena2.x");
			final double y2 = FlamePvP.getInstance().arenas.getDouble("arena2.y");
			final double z2 = FlamePvP.getInstance().arenas.getDouble("arena2.z");
			final Location lobby2 = new Location(w2, x2, y2, z2);
			lobby2.setPitch((float) FlamePvP.getInstance().arenas.getDouble("arena2.pitch"));
			lobby2.setYaw((float) FlamePvP.getInstance().arenas.getDouble("arena2.yaw"));
			p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
			p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			p.teleport(lobby2);
			break;
		}
		case 2: {
			final World w3 = Bukkit.getServer().getWorld(FlamePvP.getInstance().arenas.getString("arena3.world"));
			final double x3 = FlamePvP.getInstance().arenas.getDouble("arena3.x");
			final double y3 = FlamePvP.getInstance().arenas.getDouble("arena3.y");
			final double z3 = FlamePvP.getInstance().arenas.getDouble("arena3.z");
			final Location lobby3 = new Location(w3, x3, y3, z3);
			lobby3.setPitch((float) FlamePvP.getInstance().arenas.getDouble("arena3.pitch"));
			lobby3.setYaw((float) FlamePvP.getInstance().arenas.getDouble("arena3.yaw"));
			p.getWorld().playEffect(lobby3, Effect.ENDER_SIGNAL, 5);
			p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			p.teleport(lobby3);
			break;
		}
		case 3: {
			final World w4 = Bukkit.getServer().getWorld(FlamePvP.getInstance().arenas.getString("arena4.world"));
			final double x4 = FlamePvP.getInstance().arenas.getDouble("arena4.x");
			final double y4 = FlamePvP.getInstance().arenas.getDouble("arena4.y");
			final double z4 = FlamePvP.getInstance().arenas.getDouble("arena4.z");
			final Location lobby4 = new Location(w4, x4, y4, z4);
			lobby4.setPitch((float) FlamePvP.getInstance().arenas.getDouble("arena4.pitch"));
			lobby4.setYaw((float) FlamePvP.getInstance().arenas.getDouble("arena4.yaw"));
			p.getWorld().playEffect(lobby4, Effect.ENDER_SIGNAL, 5);
			p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			p.teleport(lobby4);
			break;
		}
		case 4: {
			final World w5 = Bukkit.getServer().getWorld(FlamePvP.getInstance().arenas.getString("arena5.world"));
			final double x5 = FlamePvP.getInstance().arenas.getDouble("arena5.x");
			final double y5 = FlamePvP.getInstance().arenas.getDouble("arena5.y");
			final double z5 = FlamePvP.getInstance().arenas.getDouble("arena5.z");
			final Location lobby5 = new Location(w5, x5, y5, z5);
			lobby5.setPitch((float) FlamePvP.getInstance().arenas.getDouble("arena5.pitch"));
			lobby5.setYaw((float) FlamePvP.getInstance().arenas.getDouble("arena5.yaw"));
			p.getWorld().playEffect(lobby5, Effect.ENDER_SIGNAL, 5);
			p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
			p.teleport(lobby5);
			break;
		}
		}
	}
}
