package ultravanish.ultravanish.handler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ultravanish.ultravanish.UltraVanish;

public class Handlers implements Listener {

    UltraVanish plugin;

    public Handlers(UltraVanish plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);

        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        for (int i = 0; i < UltraVanish.invisiblePlayers.size(); i++) {
            player.hidePlayer(plugin, UltraVanish.invisiblePlayers.get(i));
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        for (int i = 0; i < UltraVanish.invisiblePlayers.size(); i++) {
            player.showPlayer(plugin, UltraVanish.invisiblePlayers.get(i));
        }
    }
}
