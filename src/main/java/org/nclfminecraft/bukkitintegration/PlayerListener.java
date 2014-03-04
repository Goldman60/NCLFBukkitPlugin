package org.nclfminecraft.bukkitintegration;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
        
        /* Check if player is registered
                if not registered send message and check group membership,
                Make necessary changes to group membership if required
                
                if registered check group membership
                Make necessary changes to group membership if required
        
                Log result
         */
        
        event.getPlayer().getServer().broadcastMessage("Player login fired");
        
    }
}
