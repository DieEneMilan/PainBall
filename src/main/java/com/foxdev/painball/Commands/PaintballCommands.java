package com.foxdev.painball.Commands;

import com.foxdev.painball.Manager.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaintballCommands implements CommandExecutor {

    private GameManager gameManager;
    public PaintballCommands(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Alleen spelers!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length > 0 ){
            switch(args[0]){
                case "join":
                    gameManager.addPlayer(player);
                    break;
                case "leave":
                    gameManager.removePlayer(player);
            break;
                case "start":
                    gameManager.startGame();
                    break;
                case "stop":
                    gameManager.endGame();
                    break;
                default:
                    player.sendMessage("Ongeldig commando. Gebruik /paintball <join|leave|start|stop>");
            }
        } else {
            player.sendMessage("Gebruik /paintball <join|leave|start|stop>");
        }


        return true;
    }
}
