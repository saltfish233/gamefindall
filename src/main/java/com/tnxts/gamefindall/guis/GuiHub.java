package com.tnxts.gamefindall.guis;

public class GuiHub  {
    public GuiHub(){}
    public static void openGameMenuGui(String playerUUID){
        GameMenuGui.mainGui(playerUUID);
    }
    public static void openBettleInviteMessageGui(String playerUUID){
       BettleInviteMessageGui.InvitePlayerMessage(playerUUID);
    }
}
