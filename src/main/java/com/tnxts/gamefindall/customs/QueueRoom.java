package com.tnxts.gamefindall.customs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class QueueRoom {
    private String roomUUID;
    private String gameID;
    private Queue<String> players = new LinkedList<String>();

    public QueueRoom(String roomUUID,String gameID) {
        this.roomUUID = roomUUID;
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    // 房间新增玩家
    public void addPlayer(String playerUUID){
        try{
            Boolean isExist = false;
            for(String aPlayer:players)
            {
                if(aPlayer.equalsIgnoreCase(playerUUID))
                {
                    isExist = true;
                    break;
                }
            }
            if(!isExist)
            {
                players.offer(playerUUID);
                Bukkit.getPlayer(UUID.fromString(playerUUID)).sendMessage(ChatColor.GREEN+"加入房间成功");
            }
            else {
                Bukkit.getPlayer(UUID.fromString(playerUUID)).sendMessage(ChatColor.RED+"加入失败，你已经在该房间中了");
            }
        }
        catch (NullPointerException nullPointerException)
        {}

    }
    // 房间移除玩家
    public Boolean removePlayer(String playerUUID){
        for(String player:players)
        {
            if(player.equalsIgnoreCase(playerUUID))
            {
                Bukkit.broadcastMessage("removePlayer");
                players.remove(player);
                return true;
            }
        }
        return false;
    }

    public String getRoomUUID(){
        return this.roomUUID;
    }

    public Queue<String> getPlayers() {
        return players;
    }

    public void setRoomUUID(String roomUUID) {
        this.roomUUID = roomUUID;
    }
}
