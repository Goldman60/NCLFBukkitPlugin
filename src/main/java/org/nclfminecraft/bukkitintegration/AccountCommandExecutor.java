package org.nclfminecraft.bukkitintegration;

import java.security.NoSuchAlgorithmException;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 *
 * @author AJ
 */
public class AccountCommandExecutor implements CommandExecutor {

    private final PermissionManager pex;

    AccountCommandExecutor() {
        this.pex = PermissionsEx.getPermissionManager();
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] args) {

        if (args.length < 1) { //handle command with no arguements
            return defaultResponse(cs, args);
        }

        /*
         Handles:
         - link
         - unlink
         - status
         */
        String subcommand = args[0].toLowerCase();

        switch (subcommand) {
            case ("status"):
                return status(cs, args);

            case ("link"):
                return link(cs, args);

            case ("unlink"):
                return unlink(cs, args);

            default:
                return defaultResponse(cs, args);

        }
    }

    private boolean status(CommandSender cs, String[] args) {
        AccountResponse info;
        
        if(!(cs instanceof Player)) {
            return false;
        }
        
        Player player = (Player) cs;
        
        try {
           info = new NCLFRestRequest().getAccount(player.getUniqueId().toString());
        } catch (NoSuchAlgorithmException ex) {
           info = null;
        }
        
        if(info.getError() == null && info.getData().getUser_id() != null) {
            cs.sendMessage("Your account is linked to " + info.getData().getId());
        } else {
            cs.sendMessage("Your account is not linked!");
        }
        
        return true;
    }

    private boolean link(CommandSender cs, String[] args) {
        cs.sendMessage("COMMAND");
        return true;
    }

    private boolean unlink(CommandSender cs, String[] args) {
        cs.sendMessage("COMMAND");
        return true;
    }

    private boolean defaultResponse(CommandSender cs, String[] args) {
        cs.sendMessage(ChatColor.LIGHT_PURPLE + "To play on this server you must register online and link your accounts!");
        cs.sendMessage("For more information visit http://nclfminecraft.org");
        cs.sendMessage("");
        

        if (args.length < 1) {
            cs.sendMessage("Type " + ChatColor.AQUA + "/nclfaccount help" + ChatColor.WHITE + " for command help");
            cs.sendMessage("Type " + ChatColor.AQUA + "/nclfaccount link" + ChatColor.WHITE + " to register and link your account");
            return true;
        } else {
            cs.sendMessage("The following commands are allowed:");
            return false;
        }

    }
}
