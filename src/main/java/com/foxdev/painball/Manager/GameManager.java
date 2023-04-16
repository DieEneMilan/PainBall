package com.foxdev.painball.Manager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager{
    private List<Player> players;
    private boolean gameInProgress;

    public GameManager(){
        this.players = new ArrayList<>();
        this.gameInProgress = false;
    }

    public void addPlayer(Player player){
        if(!isGameInProgress()){
            players.add(player);
            player.sendMessage("Je bent aangemeld voor de paintball-minigame!");
        } else {
            player.sendMessage("Het spel is al bezig. Probeer later opnieuw!");
        }
    }

    public void removePlayer(Player player){
        players.remove(player);
        player.sendMessage("Je hebt je afgemeld voor de paintball-minigame.");
    }

    public void startGame(){
        gameInProgress = true;
        teleportPlayersToArena();
        for(Player player : players){
            //Armour en Wapens hier!
            player.sendMessage("De paintball-minigame is begonnen");
        }
    }

    public void endGame(){
        gameInProgress = false;
        teleportPlayersBackToLobby();
        for(Player player: players){
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("De paintball-minigame is afgelopen!");
        }
        players.clear();
    }

    public boolean isGameInProgress(){
        return gameInProgress;
    }

    public boolean isPlayerInGame(Player player){
        return players.contains(player);
    }

    private void teleportPlayersToArena(){
        Location arena = new Location(Bukkit.getWorld("world"), "Locatie HIER!");
        for(Player player : players){
            player.teleport(arena);
        }
    }

    private void teleportPlayersBackToLobby(){
        Location lobby = new Location(Bukkit.getWorld("world"), "Lobby HIER!");
        for(Player player : players){
            player.teleport(lobby);
        }
    }
}
