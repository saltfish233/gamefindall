package com.tnxts.gamefindall.managers;

import com.tnxts.gamefindall.games.thingscollection.actions.GroupPlayer;
import com.tnxts.gamefindall.games.thingscollection.guis.CustomScoreboard;
import com.tnxts.gamefindall.games.thingscollection.managers.ThingsCollectionManager;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class GameManager {
    //
    private static HashMap<String,Object> gameManager = new HashMap<>();

    public static void addGame(String roomUUID,String gameID){
        if(gameID.equalsIgnoreCase("0"))
        {
            gameManager.put(roomUUID,ThingsCollectionManager.startGame(roomUUID));
        }
        createGame(roomUUID, gameID);
    }

    // 玩家退出游戏
    public static void exitGame(String roomUUID,String playerUUID){
        try{
            if(RoomManager.getRoomByRoomUUID(roomUUID).getGameID().equalsIgnoreCase(ThingsCollectionManager.getGameID()))
            {
                CustomScoreboard scoreboard = (CustomScoreboard) getGameByRoomUUID(roomUUID);
                scoreboard.closeScoreboard(playerUUID);
                System.out.println("closeScoreboard" + playerUUID);
                scoreboard.whichTeam(playerUUID).removeEntry(Bukkit.getPlayer(UUID.fromString(playerUUID)).getName());
                Bukkit.broadcastMessage("exit game");
            }
        }
        catch (NullPointerException nullPointerException)
        {
        }
    }

    public static void removeGame(String roomUUID){
        System.out.println(gameManager);
        gameManager.remove(roomUUID);
        System.out.println(gameManager);
    }

    public static void createGame(String gameID,String roomUUID){
        if(gameID.equalsIgnoreCase("0"))
        {
            ThingsCollectionManager.startGame(roomUUID);
        }
    }
    // 获取当前房间的游戏
    public static Object getGameByRoomUUID(String roomUUID)
    {
        if(gameManager.containsKey(roomUUID))
        {
            return gameManager.get(roomUUID);
        }
        return null;
    }

    public static Object getGameByPlayerUUID(String playerUUID)
    {
        try {
            return GameManager.getGameByRoomUUID(RoomManager.getRoomByPlayerUUID(playerUUID).getRoomUUID());
        }
        catch (NullPointerException e){}
        return  null;
    }

    public static String getGameIDByPlayerUUID(String playerUUID)
    {
        return RoomManager.getRoomByPlayerUUID(playerUUID).getGameID();
    }
    public static HashMap<String, Object> getGameManager() {
        return gameManager;
    }
}
