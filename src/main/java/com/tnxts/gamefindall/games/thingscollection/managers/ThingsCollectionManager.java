package com.tnxts.gamefindall.games.thingscollection.managers;

import com.tnxts.gamefindall.games.thingscollection.actions.GroupPlayer;
import com.tnxts.gamefindall.games.thingscollection.guis.CustomScoreboard;
import com.tnxts.gamefindall.managers.GameManager;
import com.tnxts.gamefindall.managers.RoomManager;
import com.tnxts.gamefindall.utils.Translations;

import java.util.HashMap;
import java.util.LinkedList;

public class ThingsCollectionManager {
    private final static String gameID = "0";

    public static CustomScoreboard startGame(String roomUUID) {
        CustomScoreboard customScoreboard = new CustomScoreboard();
        customScoreboard.initScoreboard(roomUUID);

        return customScoreboard;
    }

    public static void stopGame(String roomUUID) {
        try {
            ((CustomScoreboard) GameManager.getGameByRoomUUID(roomUUID)).setRun(false);
            ((CustomScoreboard) GameManager.getGameByRoomUUID(roomUUID)).closeAllScoreboard(roomUUID);
        } catch (NullPointerException nullPointerException) {
        }
    }

    public static void removePlayer(CustomScoreboard scoreboard) {
    }

    public static String getGameID() {
        return gameID;
    }

    public static LinkedList<HashMap<Translations, Integer>> getItemArr(CustomScoreboard scoreboard) {
        return scoreboard.getItemArr();
    }

    public static Boolean getIsRun(CustomScoreboard scoreboard) {
        return scoreboard.getRun();
    }

    public static Boolean isTeamWin(CustomScoreboard scoreboard, String playerUUID) {
        if (scoreboard.whichTeam(playerUUID).getName().equalsIgnoreCase("RED")) {
            if (scoreboard.getGroupPlayer().getRedScore() >= 10) {
                return true;
            }
        } else {
            if (scoreboard.getGroupPlayer().getBlueScore() >= 10) {
                return true;
            }
        }
        return false;
    }
}
