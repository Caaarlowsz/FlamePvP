package net.iz44kpvp.kitpvp.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class SetWarp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("warpset") && p.hasPermission("flame.warpset") && args.length == 0) {
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "�cSintaxe correta: /warpset (challenge,fps,knock,main,mdr,rdm,spawn)");
			return true;
		}
		if (args[0].equalsIgnoreCase("challenge")) {
			FlamePvP.getInstance().warps.set("challenge.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("challenge.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("challenge.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("challenge.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("challenge.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("challenge.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Challenge");
			return true;
		}
		if (args[0].equalsIgnoreCase("fps")) {
			FlamePvP.getInstance().warps.set("fps.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("fps.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("fps.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("fps.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("fps.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("fps.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Fps");
			return true;
		}
		if (args[0].equalsIgnoreCase("knock")) {
			FlamePvP.getInstance().warps.set("knock.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("knock.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("knock.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("knock.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("knock.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("knock.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Knock");
			return true;
		}
		if (args[0].equalsIgnoreCase("main")) {
			FlamePvP.getInstance().warps.set("main.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("main.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("main.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("main.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("main.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("main.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Main");
			return true;
		}
		if (args[0].equalsIgnoreCase("mdr")) {
			FlamePvP.getInstance().warps.set("mdr.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("mdr.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("mdr.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("mdr.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("mdr.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("mdr.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Mdr");
			return true;
		}
		if (args[0].equalsIgnoreCase("rdm")) {
			FlamePvP.getInstance().warps.set("rdm.x", p.getLocation().getX());
			FlamePvP.getInstance().warps.set("rdm.y", p.getLocation().getY());
			FlamePvP.getInstance().warps.set("rdm.z", p.getLocation().getZ());
			FlamePvP.getInstance().warps.set("rdm.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().warps.set("rdm.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().warps.set("rdm.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().save();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou a warp �6Rdm");
			return true;
		}
		if (args[0].equalsIgnoreCase("spawn")) {
			FlamePvP.getInstance().getConfig().set("spawn.x", p.getLocation().getX());
			FlamePvP.getInstance().getConfig().set("spawn.y", p.getLocation().getY());
			FlamePvP.getInstance().getConfig().set("spawn.z", p.getLocation().getZ());
			FlamePvP.getInstance().getConfig().set("spawn.pitch", p.getLocation().getPitch());
			FlamePvP.getInstance().getConfig().set("spawn.yaw", p.getLocation().getYaw());
			FlamePvP.getInstance().getConfig().set("spawn.world", p.getLocation().getWorld().getName());
			FlamePvP.getInstance().saveConfig();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cVoce setou o �6Spawn");
			p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(),
					p.getLocation().getBlockZ());
			return true;
		}
		return false;
	}
}
