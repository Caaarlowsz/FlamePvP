package com.github.caaarlowsz.flamemc.kitpvp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.github.caaarlowsz.kitpvpapi.KitPvP;
import com.github.caaarlowsz.kitpvpapi.KitPvPAPI;
import net.iz44kpvp.kitpvp.SendMSG;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;

import net.iz44kpvp.kitpvp.Comandos.Admin;
import net.iz44kpvp.kitpvp.Comandos.Aplicar;
import net.iz44kpvp.kitpvp.Comandos.Aviso;
import net.iz44kpvp.kitpvp.Comandos.Build;
import net.iz44kpvp.kitpvp.Comandos.Caixa;
import net.iz44kpvp.kitpvp.Comandos.Chat;
import net.iz44kpvp.kitpvp.Comandos.ClearChat;
import net.iz44kpvp.kitpvp.Comandos.ClickTest;
import net.iz44kpvp.kitpvp.Comandos.Congelar;
import net.iz44kpvp.kitpvp.Comandos.DarKit;
import net.iz44kpvp.kitpvp.Comandos.Fake;
import net.iz44kpvp.kitpvp.Comandos.Fly;
import net.iz44kpvp.kitpvp.Comandos.Gamemode;
import net.iz44kpvp.kitpvp.Comandos.Head;
import net.iz44kpvp.kitpvp.Comandos.Kills;
import net.iz44kpvp.kitpvp.Comandos.Kit;
import net.iz44kpvp.kitpvp.Comandos.Rank;
import net.iz44kpvp.kitpvp.Comandos.Report;
import net.iz44kpvp.kitpvp.Comandos.ResetKit;
import net.iz44kpvp.kitpvp.Comandos.Score;
import net.iz44kpvp.kitpvp.Comandos.SetArena;
import net.iz44kpvp.kitpvp.Comandos.Spawn;
import net.iz44kpvp.kitpvp.Comandos.StaffChat;
import net.iz44kpvp.kitpvp.Comandos.Status;
import net.iz44kpvp.kitpvp.Comandos.Tag;
import net.iz44kpvp.kitpvp.Comandos.Tell;
import net.iz44kpvp.kitpvp.Comandos.TogglePvP;
import net.iz44kpvp.kitpvp.Comandos.Tp;
import net.iz44kpvp.kitpvp.Comandos.UnCage;
import net.iz44kpvp.kitpvp.Comandos.Ver;
import net.iz44kpvp.kitpvp.Comandos.Xp;
import net.iz44kpvp.kitpvp.Comandos.Youtuber;
import net.iz44kpvp.kitpvp.Eventos.BarKit;
import net.iz44kpvp.kitpvp.Eventos.Bussola;
import net.iz44kpvp.kitpvp.Eventos.CombatLog;
import net.iz44kpvp.kitpvp.Eventos.DropEventos;
import net.iz44kpvp.kitpvp.Eventos.MorteEventos;
import net.iz44kpvp.kitpvp.Eventos.Naturais;
import net.iz44kpvp.kitpvp.Eventos.Nerfs;
import net.iz44kpvp.kitpvp.Eventos.PlayerEventos;
import net.iz44kpvp.kitpvp.Guis.EventosGuis;
import net.iz44kpvp.kitpvp.Guis.GuiCaixa;
import net.iz44kpvp.kitpvp.Guis.GuiKits;
import net.iz44kpvp.kitpvp.Guis.GuiKits2;
import net.iz44kpvp.kitpvp.Guis.GuiLoja;
import net.iz44kpvp.kitpvp.Guis.GuiRank;
import net.iz44kpvp.kitpvp.Guis.GuiWarps;
import net.iz44kpvp.kitpvp.Kits.Anchor;
import net.iz44kpvp.kitpvp.Kits.Avatar;
import net.iz44kpvp.kitpvp.Kits.Bombeiro;
import net.iz44kpvp.kitpvp.Kits.Bruxa;
import net.iz44kpvp.kitpvp.Kits.C4;
import net.iz44kpvp.kitpvp.Kits.Confusão;
import net.iz44kpvp.kitpvp.Kits.Deshzin;
import net.iz44kpvp.kitpvp.Kits.FisherMan;
import net.iz44kpvp.kitpvp.Kits.Flash;
import net.iz44kpvp.kitpvp.Kits.FlashBack;
import net.iz44kpvp.kitpvp.Kits.ForceField;
import net.iz44kpvp.kitpvp.Kits.Gaara;
import net.iz44kpvp.kitpvp.Kits.Gladiator;
import net.iz44kpvp.kitpvp.Kits.Goku;
import net.iz44kpvp.kitpvp.Kits.Grappler;
import net.iz44kpvp.kitpvp.Kits.Gun;
import net.iz44kpvp.kitpvp.Kits.Hack;
import net.iz44kpvp.kitpvp.Kits.HotPotato;
import net.iz44kpvp.kitpvp.Kits.Infernor;
import net.iz44kpvp.kitpvp.Kits.IronMan;
import net.iz44kpvp.kitpvp.Kits.JellyFish;
import net.iz44kpvp.kitpvp.Kits.Jumper;
import net.iz44kpvp.kitpvp.Kits.Kangaroo;
import net.iz44kpvp.kitpvp.Kits.Magma;
import net.iz44kpvp.kitpvp.Kits.Monk;
import net.iz44kpvp.kitpvp.Kits.Phantom;
import net.iz44kpvp.kitpvp.Kits.Poseidon;
import net.iz44kpvp.kitpvp.Kits.Rain;
import net.iz44kpvp.kitpvp.Kits.Rusher;
import net.iz44kpvp.kitpvp.Kits.Shooter;
import net.iz44kpvp.kitpvp.Kits.Stomper;
import net.iz44kpvp.kitpvp.Kits.Subzero;
import net.iz44kpvp.kitpvp.Kits.Switcher;
import net.iz44kpvp.kitpvp.Kits.Teleporter;
import net.iz44kpvp.kitpvp.Kits.Terrorista;
import net.iz44kpvp.kitpvp.Kits.Thor;
import net.iz44kpvp.kitpvp.Kits.TimeLord;
import net.iz44kpvp.kitpvp.Kits.Trader;
import net.iz44kpvp.kitpvp.Kits.Turtle;
import net.iz44kpvp.kitpvp.Kits.Vacuum;
import net.iz44kpvp.kitpvp.Kits.Viking;
import net.iz44kpvp.kitpvp.Kits2.Ajnin;
import net.iz44kpvp.kitpvp.Kits2.DeshIce_DeshFire;
import net.iz44kpvp.kitpvp.Kits2.Hercules;
import net.iz44kpvp.kitpvp.Kits2.Hulk;
import net.iz44kpvp.kitpvp.Kits2.Ninja;
import net.iz44kpvp.kitpvp.Kits2.NoFall;
import net.iz44kpvp.kitpvp.Kits2.Pyro;
import net.iz44kpvp.kitpvp.Kits2.Resouper;
import net.iz44kpvp.kitpvp.Kits2.Viper_Snail;
import net.iz44kpvp.kitpvp.ScoreBoard.ScoreBoard;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.AutoMensagem;
import net.iz44kpvp.kitpvp.Sistemas.BlocosJump;
import net.iz44kpvp.kitpvp.Sistemas.PlacaDeRecraft;
import net.iz44kpvp.kitpvp.Sistemas.PlacaDeSopa;
import net.iz44kpvp.kitpvp.Sistemas.Plugins;
import net.iz44kpvp.kitpvp.Warps.SetWarp;
import net.iz44kpvp.kitpvp.Warps.irWarp;

public class FlamePvP extends JavaPlugin implements KitPvP {

	@Override
	public void onEnable() {
		super.onEnable();
		KitPvPAPI.setInstance(this);

		// TODO: Remover quando melhorar a classe principal
		this.enable();
	}

	@Override
	public void onDisable() {
		super.onDisable();

		// TODO: Remover quando melhorar a classe principal
		this.disable();
	}

	// TODO: Melhorar a classe principal

	public static Plugin plugin;
	public static FlamePvP instance;
	public static Integer score;
	public File statusfile;
	public YamlConfiguration status;
	public File warpsfile;
	public YamlConfiguration warps;
	public File arenasfile;
	public YamlConfiguration arenas;

	static {
		FlamePvP.score = null;
	}

	public void onLoad() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			final ArrayList<String> msg = new ArrayList<String>();
			msg.add(" �6KITPVP");
			msg.add("�cServidor reiniciando...");
			todos.kickPlayer(String.valueOf(msg));
		}
	}

	public void enable() {
		FlamePvP.plugin = this;
		FlamePvP.instance = this;
		final File status = new File(this.getDataFolder(), "status.yml");
		if (!status.exists()) {
			this.saveResource("status.yml", false);
		}
		this.statusfile = new File(this.getDataFolder(), "status.yml");
		this.status = YamlConfiguration.loadConfiguration(this.statusfile);
		final File warps = new File(this.getDataFolder(), "warps.yml");
		if (!warps.exists()) {
			this.saveResource("warps.yml", false);
		}
		this.warpsfile = new File(this.getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(this.warpsfile);
		final File arenas = new File(this.getDataFolder(), "arenas.yml");
		if (!arenas.exists()) {
			this.saveResource("arenas.yml", false);
		}
		this.arenasfile = new File(this.getDataFolder(), "arenas.yml");
		this.arenas = YamlConfiguration.loadConfiguration(this.arenasfile);
		AutoMensagem.start();
		this.save();
		this.Eventos();
		this.Comandos();
		this.Kits();
		this.Guis();
		this.saveDefaultConfig();
		API.novaReceita();
		Bukkit.getConsoleSender().sendMessage("�aPLUGIN ATIVADO");
		FlamePvP.score = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(getInstance(),
				new Runnable() {
					@Override
					public void run() {
						Player[] arrayOfPlayer;
						for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
							final Player p = arrayOfPlayer[i];
							if (Score.ntemscore.contains(p.getName())) {
								ScoreBoard.FlameScore(p);
							}
							if (Score.temscore.contains(p.getName())) {
								p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
							}
						}
					}
				}, 0L, 10L);
	}

	public void disable() {
		Bukkit.getConsoleSender().sendMessage("�cPLUGIN DESATIVADO");
	}

	public void Eventos() {
		final PluginManager evento = Bukkit.getPluginManager();
		evento.registerEvents(new MorteEventos(), this);
		evento.registerEvents(new Naturais(), this);
		evento.registerEvents(new Nerfs(), this);
		evento.registerEvents(new PlayerEventos(), this);
		evento.registerEvents(new DropEventos(), this);
		evento.registerEvents(new Build(), this);
		evento.registerEvents(new Admin(), this);
		evento.registerEvents(new Congelar(), this);
		evento.registerEvents(new ClickTest(), this);
		evento.registerEvents(new Fake(), this);
		evento.registerEvents(new BarKit(), this);
		evento.registerEvents(new GuiLoja(), this);
		evento.registerEvents(new BlocosJump(), this);
		evento.registerEvents(new PlacaDeRecraft(), this);
		evento.registerEvents(new PlacaDeSopa(), this);
		evento.registerEvents(new Chat(), this);
		evento.registerEvents(new StaffChat(), this);
		evento.registerEvents(new CombatLog(), this);
		evento.registerEvents(new Bussola(), this);
		evento.registerEvents(new Ninja(), this);
		evento.registerEvents(new Plugins(), this);
	}

	public void Comandos() {
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("report").setExecutor(new Report());
		this.getCommand("status").setExecutor(new Status());
		this.getCommand("rank").setExecutor(new Rank());
		this.getCommand("xp").setExecutor(new Xp());
		this.getCommand("score").setExecutor(new Score());
		this.getCommand("resetkit").setExecutor(new ResetKit());
		this.getCommand("clicktest").setExecutor(new ClickTest());
		this.getCommand("gm").setExecutor(new Gamemode());
		this.getCommand("gamemode").setExecutor(new Gamemode());
		this.getCommand("build").setExecutor(new Build());
		this.getCommand("admin").setExecutor(new Admin());
		this.getCommand("congelar").setExecutor(new Congelar());
		this.getCommand("pvp").setExecutor(new TogglePvP());
		this.getCommand("tag").setExecutor(new Tag());
		this.getCommand("warpset").setExecutor(new SetWarp());
		this.getCommand("warp").setExecutor(new irWarp());
		this.getCommand("aviso").setExecutor(new Aviso());
		this.getCommand("cc").setExecutor(new ClearChat());
		this.getCommand("fake").setExecutor(new Fake());
		this.getCommand("tell").setExecutor(new Tell());
		this.getCommand("chat").setExecutor(new Chat());
		this.getCommand("aplicar").setExecutor(new Aplicar());
		this.getCommand("sc").setExecutor(new StaffChat());
		this.getCommand("setarena").setExecutor(new SetArena());
		this.getCommand("caixa").setExecutor(new Caixa());
		this.getCommand("darkit").setExecutor(new DarKit());
		this.getCommand("tp").setExecutor(new Tp());
		this.getCommand("tphere").setExecutor(new Tp());
		this.getCommand("tpall").setExecutor(new Tp());
		this.getCommand("vis").setExecutor(new Ver());
		this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("head").setExecutor(new Head());
		this.getCommand("youtuber").setExecutor(new Youtuber());
		this.getCommand("uncage").setExecutor(new UnCage());
		this.getCommand("kills").setExecutor(new Kills());
		this.getCommand("sendmsg").setExecutor(new SendMSG());
	}

	public void Kits() {
		final PluginManager kits = Bukkit.getPluginManager();
		this.getCommand("kit").setExecutor(new Kit());
		kits.registerEvents(new Bombeiro(), this);
		kits.registerEvents(new Jumper(), this);
		kits.registerEvents(new Goku(), this);
		kits.registerEvents(new Bruxa(), this);
		kits.registerEvents(new Shooter(), this);
		kits.registerEvents(new TimeLord(), this);
		kits.registerEvents(new JellyFish(), this);
		kits.registerEvents(new Anchor(), this);
		kits.registerEvents(new FisherMan(), this);
		kits.registerEvents(new Magma(), this);
		kits.registerEvents(new Confusão(), this);
		kits.registerEvents(new Gladiator(), this);
		kits.registerEvents(new HotPotato(), this);
		kits.registerEvents(new ForceField(), this);
		kits.registerEvents(new Avatar(), this);
		kits.registerEvents(new Kangaroo(), this);
		kits.registerEvents(new Grappler(), this);
		kits.registerEvents(new Monk(), this);
		kits.registerEvents(new Stomper(), this);
		kits.registerEvents(new Thor(), this);
		kits.registerEvents(new Teleporter(), this);
		kits.registerEvents(new Gaara(), this);
		kits.registerEvents(new Infernor(), this);
		kits.registerEvents(new Poseidon(), this);
		kits.registerEvents(new Trader(), this);
		kits.registerEvents(new IronMan(), this);
		kits.registerEvents(new Phantom(), this);
		kits.registerEvents(new C4(), this);
		kits.registerEvents(new Viking(), this);
		kits.registerEvents(new Gun(), this);
		kits.registerEvents(new Terrorista(), this);
		kits.registerEvents(new Deshzin(), this);
		kits.registerEvents(new Flash(), this);
		kits.registerEvents(new Rain(), this);
		kits.registerEvents(new Rusher(), this);
		kits.registerEvents(new Hack(), this);
		kits.registerEvents(new FlashBack(), this);
		kits.registerEvents(new Switcher(), this);
		kits.registerEvents(new Subzero(), this);
		kits.registerEvents(new Vacuum(), this);
		kits.registerEvents(new Turtle(), this);
		kits.registerEvents(new Ajnin(), this);
		kits.registerEvents(new Pyro(), this);
		kits.registerEvents(new Resouper(), this);
		kits.registerEvents(new NoFall(), this);
		kits.registerEvents(new Viper_Snail(), this);
		kits.registerEvents(new Hulk(), this);
		kits.registerEvents(new DeshIce_DeshFire(), this);
		kits.registerEvents(new Hercules(), this);
	}

	public void Guis() {
		final PluginManager guis = Bukkit.getPluginManager();
		guis.registerEvents(new EventosGuis(), this);
		guis.registerEvents(new GuiKits(), this);
		guis.registerEvents(new GuiKits2(), this);
		guis.registerEvents(new GuiWarps(), this);
		guis.registerEvents(new GuiRank(), this);
		guis.registerEvents(new GuiCaixa(), this);
	}

	public static Plugin getPlugin() {
		return FlamePvP.plugin;
	}

	public static FlamePvP getInstance() {
		return FlamePvP.instance;
	}

	public void save() {
		try {
			this.status.save(this.statusfile);
			this.warps.save(this.warpsfile);
			this.arenas.save(this.arenasfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
