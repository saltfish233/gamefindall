package com.tnxts.gamefindall.managers;

import com.tnxts.gamefindall.games.thingscollection.managers.ThingsCollectionManager;
import com.tnxts.gamefindall.actions.MatchPlayer;
import com.tnxts.gamefindall.customs.QueueRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.UUID;

public class RoomManager {
    private static final HashMap<String, QueueRoom> roomManager = new HashMap<>();

    // 创建房间
    public static void addRoom(String roomMaster,QueueRoom roomQueue){
        try{
            roomManager.putIfAbsent(roomMaster,roomQueue);
            Bukkit.getPlayer(UUID.fromString(roomMaster)).sendMessage(ChatColor.GREEN + "创建房间成功");
        }
        catch (NullPointerException nullPointerException)
        {}
    }
    public static QueueRoom getRoomByRoomUUID(String roomUUID)
    {
        return roomManager.get(roomUUID);
    }
    // 移除房间
    public static void removeRoom(String roomMaster){
        if(roomManager.containsKey(roomMaster))
        {
            roomManager.remove(roomMaster);
        }
    }
    public static HashMap<String,QueueRoom>  getRoomManager() {
        return roomManager;
    }
    // 判断玩家是否已经加入某房间
    public static Boolean isPlayerInOneRoom(String playerUUID){

        if(roomManager.containsKey(playerUUID))
        {
            return true;
        }

        for(QueueRoom queueRoom:roomManager.values())
        {
            for(String playerUID:queueRoom.getPlayers())
            {
                if( playerUID.equalsIgnoreCase(playerUUID) )
                {
                    return true;
                }
            }
        }
        return false;
    }
    // 判断玩家是否已经加入其他房间
    public static Boolean isPlayerInOtherRoom(String playerUUID,String roomUUID){
        for(QueueRoom queueRoom:roomManager.values())
        {
            if(queueRoom.getRoomUUID().equalsIgnoreCase(roomUUID))
            {
                continue;
            }
            for(String playerUID:queueRoom.getPlayers())
            {
                if( playerUID.equalsIgnoreCase(playerUUID) )
                {
                    return true;
                }
            }
        }
        return false;
    }
    // 玩家退出房间
    public static void exitRoom(String playerUUID){
        try{
            for(String roomMaster:roomManager.keySet()){
                if(roomMaster.equalsIgnoreCase(playerUUID))
                {
                    QueueRoom roomQueue = roomManager.get(roomMaster);
                    GameManager.exitGame(roomQueue.getRoomUUID(),roomMaster);
                    if(InviteMessageManager.hasInviteMessage(roomMaster))
                    {
                        InviteMessageManager.removeInviteMessage(InviteMessageManager.getInviteMessage(roomMaster));
                    }
                    if(roomQueue.removePlayer(playerUUID))
                    {
                        Bukkit.getPlayer(UUID.fromString(playerUUID)).sendMessage(ChatColor.GREEN + "退出房间成功");
                    }
                    if(roomQueue.getPlayers().size() <= 0)
                    {
                        Bukkit.broadcastMessage("移除房间");
                        ThingsCollectionManager.stopGame(roomQueue.getRoomUUID());
                        GameManager.removeGame(roomQueue.getRoomUUID());
                        removeRoom(roomMaster);
                    }
                    else
                    {
                        Bukkit.broadcastMessage("交换房主");
                        changeRoomMaster(playerUUID,roomManager.get(playerUUID));
                    }
                    return;
                }
            }
            for(QueueRoom room:roomManager.values())
            {
                for(String player:room.getPlayers())
                {
                    if(player.equalsIgnoreCase(playerUUID))
                    {
                        Bukkit.broadcastMessage("成员退出房间");
                        GameManager.exitGame(room.getRoomUUID(),playerUUID);
                        if(room.removePlayer(playerUUID))
                        {
                            Bukkit.getPlayer(UUID.fromString(playerUUID)).sendMessage(ChatColor.GREEN + "退出房间成功");
                        }
                        return;
                    }
                }
            }
        }
        catch (NullPointerException nullPointerException) {}
    }

    // 修改房主
    public static void changeRoomMaster(String roomMaster,QueueRoom room) {
        try{
            String newRoomMaster = room.getPlayers().element();
            String gameID = room.getGameID();
            GameManager.getGameManager().put(newRoomMaster, GameManager.getGameManager().get(roomMaster));
            System.out.println(GameManager.getGameManager());
            GameManager.getGameManager().remove(roomMaster);
            System.out.println(GameManager.getGameManager());
            //GameManager.addGame(room.getRoomUUID(),gameID);
        Bukkit.broadcastMessage(Bukkit.getPlayer(UUID.fromString(newRoomMaster)).getName());

        // 重新创建邀请信息
        MatchPlayer matchPlayer = new MatchPlayer(newRoomMaster,room);
        InviteMessageManager.addInviteMessage(matchPlayer);
        room.setRoomUUID(newRoomMaster);
        roomManager.putIfAbsent(newRoomMaster,room);
        roomManager.remove(roomMaster);
        Bukkit.getPlayer(UUID.fromString(newRoomMaster)).sendMessage(ChatColor.DARK_PURPLE + "你已成为新房主!");
        }
        catch (NullPointerException nullPointerException)
        {
            nullPointerException.printStackTrace();
        }
    }

    public static String getRoomUUIDByPlayerUUID(String playerUUID) {
        if (roomManager.containsKey(playerUUID)) {
            return playerUUID;
        }
        for (QueueRoom room : roomManager.values()) {
            for (String playerUID : room.getPlayers()) {
                if (playerUUID.equalsIgnoreCase(playerUID)) {
                    return room.getRoomUUID();
                }
            }
        }
        return null;
    }
    public static QueueRoom getRoomByPlayerUUID(String playerUUID)
    {
        if (roomManager.containsKey(playerUUID)) {
            return roomManager.get(playerUUID);
        }
        for (QueueRoom room : roomManager.values()) {
            for (String playerUID : room.getPlayers()) {
                if (playerUUID.equalsIgnoreCase(playerUID)) {
                    return room;
                }
            }
        }
        return null;
    }
}