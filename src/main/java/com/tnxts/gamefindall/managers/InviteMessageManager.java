package com.tnxts.gamefindall.managers;

import com.tnxts.gamefindall.actions.MatchPlayer;
import org.bukkit.Bukkit;

import java.util.LinkedList;

public class InviteMessageManager {
    private final static LinkedList<MatchPlayer> inviteMessageManager = new LinkedList<>();

    // 添加邀请信息
    public static void addInviteMessage(MatchPlayer matchPlayer){
        inviteMessageManager.offer(matchPlayer);
    }

    // 修改邀请信息
    public static void changeInviteMessage(MatchPlayer matchPlayer,String newMaster)
    {
        if(matchPlayer != null)
        {
            stopInviteMessage(matchPlayer);
            matchPlayer.setMasterUUID(newMaster);
            startInviteMessage(matchPlayer,0,5,newMaster);
        }
    }

    public static void removeInviteMessage(MatchPlayer matchPlayer)
    {
//            stopInviteMessage(matchPlayer);

        inviteMessageManager.remove(matchPlayer);
    }

    public static LinkedList<MatchPlayer> getInviteMessageManager(){
        return inviteMessageManager;
    }

    public static void startInviteMessage(MatchPlayer matchPlayer,int startTime,int period,String playerUUID)
    {
        for(String gamePlayerUUID:RoomManager.getRoomByPlayerUUID(playerUUID).getPlayers())
        {
            GameManager.exitGame(RoomManager.getRoomUUIDByPlayerUUID(playerUUID),playerUUID);
        }
        GameManager.removeGame(RoomManager.getRoomUUIDByPlayerUUID(playerUUID));

        matchPlayer.start(startTime,period);
    }

    public static void stopInviteMessage(MatchPlayer matchPlayer)
    {
        matchPlayer.stop();
    }

    public static Boolean hasInviteMessage(String playerUUID)
    {
        for(int i=0;i<inviteMessageManager.size();i++)
        {
            if(inviteMessageManager.get(i).getMasterUUID().equalsIgnoreCase(playerUUID))
            {
                return true;
            }
        }
        return false;
    }

    public static MatchPlayer getInviteMessage(String masterUUID)
    {
        for(int i=0;i<inviteMessageManager.size();i++)
        {
            if(inviteMessageManager.get(i).getMasterUUID().equalsIgnoreCase(masterUUID))
            {
                return inviteMessageManager.get(i);
            }
        }
        return null;
    }
}