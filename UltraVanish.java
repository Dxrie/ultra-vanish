package ultravanish.ultravanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class UltraVanish extends JavaPlugin {

    public static ArrayList<Player> invisiblePlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Ultra Vanish Version 1.0 for Minecraft 1.18.1 has been loaded.");

        new ultravanish.ultravanish.commands.UltraVanish(this);
        getCommand("vanish").setExecutor(new ultravanish.ultravanish.commands.UltraVanish(this));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Ultra Vanish Version 1.0 for Minecraft 1.18.1 has been shut down.");
    }
}
