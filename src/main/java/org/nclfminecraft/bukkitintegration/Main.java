/*
 *  Copyright 2014 A.J. Fite
 *  Please see the license file for more information.
 *//*
 *  Copyright 2014 A.J. Fite
 *  Please see the license file for more information.
 */

package org.nclfminecraft.bukkitintegration;

import org.bukkit.plugin.java.JavaPlugin;

/** 
 *
 * @author AJ
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //Registers player event listener
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        //Registers handler for account commands
        getCommand("nclfaccount").setExecutor(new AccountCommandExecutor());
    }
    
    @Override
    public void onDisable() {
        
    }
}
