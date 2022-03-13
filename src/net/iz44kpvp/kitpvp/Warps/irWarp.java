package net.iz44kpvp.kitpvp.Warps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;
import net.iz44kpvp.kitpvp.Sistemas.Warp;

public class irWarp implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("warp") && args.length == 0) {
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "�cSintaxe correta: /warp (challenge,fps,main,knock,mdr,rdm,,spawn)");
			return true;
		}
		if (args[0].equalsIgnoreCase("challenge")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("challenge") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cChallenge Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("challenge.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("challenge.x");
			final double y = FlamePvP.getInstance().warps.getDouble("challenge.y");
			final double z = FlamePvP.getInstance().warps.getDouble("challenge.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("challenge.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("challenge.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "�aVoce Foi Teleportado Para A Warp �cLava Challenge");
			Warp.setWarp(p, "Challenge");
			p.setFireTicks(0);
			p.setGameMode(GameMode.SURVIVAL);
			API.darSopa(p, 36);
			API.tirarEfeitos(p);
			API.tirarArmadura(p);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else if (args[0].equalsIgnoreCase("fps")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("fps") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cFps Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("fps.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("fps.x");
			final double y = FlamePvP.getInstance().warps.getDouble("fps.y");
			final double z = FlamePvP.getInstance().warps.getDouble("fps.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("fps.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("fps.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.setHealth(20.0);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para A Warp �cFps");
			Warp.setWarp(p, "Fps");
			p.setFireTicks(0);
			API.darItem(p, Material.STONE_SWORD, 1, "�aEspada", 0);
			API.darSopa(p, 35);
			p.setGameMode(GameMode.SURVIVAL);
			API.tirarEfeitos(p);
			API.tirarArmadura(p);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else if (args[0].equalsIgnoreCase("main")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("main") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cMain Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("main.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("main.x");
			final double y = FlamePvP.getInstance().warps.getDouble("main.y");
			final double z = FlamePvP.getInstance().warps.getDouble("main.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("main.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("main.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para A Warp �cMain");
			p.setGameMode(GameMode.SURVIVAL);
			Warp.setWarp(p, "Main");
			p.setFireTicks(0);
			p.setHealth(20.0);
			API.darItemEnchant(p, Material.DIAMOND_SWORD, 1, "�aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
			API.darSopa(p, 34);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else if (args[0].equalsIgnoreCase("knock")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("knock") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cKnock Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("knock.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("knock.x");
			final double y = FlamePvP.getInstance().warps.getDouble("knock.y");
			final double z = FlamePvP.getInstance().warps.getDouble("knock.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("knock.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("knock.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para A Warp �cKnock");
			Warp.setWarp(p, "Knock");
			p.setFireTicks(0);
			p.setHealth(20.0);
			API.darItemEnchant(p, Material.STICK, 1, "�aVaret\u00e3o", 0, Enchantment.KNOCKBACK, 1, true);
			API.tirarEfeitos(p);
			API.tirarArmadura(p);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else if (args[0].equalsIgnoreCase("mdr")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("mdr") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cMdr Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("mdr.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("mdr.x");
			final double y = FlamePvP.getInstance().warps.getDouble("mdr.y");
			final double z = FlamePvP.getInstance().warps.getDouble("mdr.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("mdr.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("mdr.yaw"));
			p.teleport(lobby);
			p.setGameMode(GameMode.SURVIVAL);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para A Warp �cMdr");
			Warp.setWarp(p, "Mdr");
			p.setHealth(20.0);
			p.setFireTicks(0);
			API.tirarEfeitos(p);
			API.tirarArmadura(p);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else if (args[0].equalsIgnoreCase("rdm")) {
			if (FlamePvP.getInstance().warps.getConfigurationSection("rdm") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cRdm Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().warps.getString("rdm.world"));
			final double x = FlamePvP.getInstance().warps.getDouble("rdm.x");
			final double y = FlamePvP.getInstance().warps.getDouble("rdm.y");
			final double z = FlamePvP.getInstance().warps.getDouble("rdm");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().warps.getDouble("rdm.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().warps.getDouble("rdm.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.setHealth(20.0);
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para A Warp �cRdm");
			Warp.setWarp(p, "Rdm");
			API.darItemEnchant(p, Material.STONE_SWORD, 1, "�aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			API.darSopa(p, 34);
			p.setFireTicks(0);
			API.tirarEfeitos(p);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		} else {
			if (!args[0].equalsIgnoreCase("spawn")) {
				return false;
			}
			if (FlamePvP.getInstance().getConfig().getConfigurationSection("spawn") == null) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cSpawn Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(FlamePvP.getInstance().getConfig().getString("spawn.world"));
			final double x = FlamePvP.getInstance().getConfig().getDouble("spawn.x");
			final double y = FlamePvP.getInstance().getConfig().getDouble("spawn.y");
			final double z = FlamePvP.getInstance().getConfig().getDouble("spawn.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) FlamePvP.getInstance().getConfig().getDouble("spawn.pitch"));
			lobby.setYaw((float) FlamePvP.getInstance().getConfig().getDouble("spawn.yaw"));
			p.teleport(lobby);
			Habilidade.removeAbility(p);
			p.getInventory().clear();
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�aVoce Foi Teleportado Para O �cSpawn");
			Warp.removeWarp(p);
			API.ItemServer(p);
			p.setExp(0.0f);
			p.setExhaustion(20.0f);
			p.setHealth(20.0);
			p.setFireTicks(0);
			API.tirarEfeitos(p);
			API.tirarArmadura(p);
			p.setGameMode(GameMode.SURVIVAL);
			p.setAllowFlight(false);
			p.updateInventory();
			return true;
		}
	}
}
