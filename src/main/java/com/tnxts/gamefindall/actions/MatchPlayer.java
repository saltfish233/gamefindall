package com.tnxts.gamefindall.actions;

import com.tnxts.gamefindall.GameFindAll;
import com.tnxts.gamefindall.guis.GuiHub;
import com.tnxts.gamefindall.managers.GameManager;
import com.tnxts.gamefindall.customs.QueueRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class MatchPlayer extends BukkitRunnable {
    private String masterUUID;

    public String getMasterUUID() {
        return masterUUID;
    }

    private String gameID;
    private QueueRoom room;
    private static Boolean isGameWait;
    private static int timeCount;
    public MatchPlayer(String masterUUID,QueueRoom room){
        setMasterUUID(masterUUID);
        setRoom(room);
        setGameID(room.getGameID());
        isGameWait = false;
        timeCount = 0;
    }
    @Override
    public void run() {
        Bukkit.broadcastMessage(room.getPlayers().size()+"");
        if(room == null || room.getPlayers().size() <= 0)
        {
            this.cancel();
            return;
        }
        if(room.getPlayers().size() % 2 == 0)
        {
            if(!isGameWait)
            {
                for(String playerUUID:room.getPlayers())
                {
                    Bukkit.getPlayer(UUID.fromString(playerUUID)).sendTitle(ChatColor.YELLOW + "十秒后游戏开始","",20,70,20);
                }
                isGameWait = true;
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(!GameManager.getGameManager().containsKey(room.getRoomUUID()) || !room.getGameID().equalsIgnoreCase(gameID))
                    {
                        GameManager.addGame(room.getRoomUUID(),gameID);
                    }
                    isGameWait = false;
                    timeCount = 0;
                    this.cancel();
                }
            }.runTaskLater(GameFindAll.getPlugin(),20L*10);
            if(++timeCount >= 3)
            {
                this.cancel();
                return;
            }
        }

        GuiHub.openBettleInviteMessageGui(masterUUID);
    }
    public void stop() {
        this.cancel();
    }
    public void start(long delay,long time){
        this.runTaskTimer(GameFindAll.getPlugin(),20L*delay,20L*time);
    }
    public void setRoom(QueueRoom room) {
        this.room = room;
    }
    public void setMasterUUID(String masterUUID) {
        this.masterUUID = masterUUID;
    }
    public void setGameID(String gameID)
    {
        this.gameID = gameID;
    }
}
