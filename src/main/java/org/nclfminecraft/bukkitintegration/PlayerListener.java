package org.nclfminecraft.bukkitintegration;

import static org.bukkit.Bukkit.getLogger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 *
 * @author AJ
 */
public class PlayerListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        /*
         Add account to account list
         */
        
        getLogger().info("NCLF onLogin fired.");

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        /* Check if player is registered
         if not registered send message and check group membership,
         Make necessary changes to group membership if required
                
         if registered check group membership
         Make necessary changes to group membership if required
        
         Log result
         */
        
        getLogger().info("NCLF onJoin fired.");

    }
}
