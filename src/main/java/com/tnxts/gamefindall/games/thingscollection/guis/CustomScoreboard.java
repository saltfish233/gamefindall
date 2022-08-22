package com.tnxts.gamefindall.games.thingscollection.guis;

import com.tnxts.gamefindall.games.thingscollection.actions.GenerateTaskItem;
import com.tnxts.gamefindall.games.thingscollection.actions.GroupPlayer;
import com.tnxts.gamefindall.managers.GameManager;
import com.tnxts.gamefindall.managers.RoomManager;
import com.tnxts.gamefindall.utils.Translations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class CustomScoreboard {
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private  Objective objective;
    private ArrayList<Team> shows;
    private Boolean isRun = false;
    private int redScore;
    private int blueScore;
    GroupPlayer groupPlayer;
    LinkedList<HashMap<Translations,Integer>> itemArr;
    public CustomScoreboard() {
    }

    public GroupPlayer getGroupPlayer() {
        return groupPlayer;
    }

    public void initScoreboard(String roomUUID){
        try{
            manager = Bukkit.getScoreboardManager();
            scoreboard = manager.getNewScoreboard();

            objective = scoreboard.registerNewObjective("ScoreRecord","dummmy", ChatColor.YELLOW + "目标");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            shows = new ArrayList<>();
            isRun = false;

            groupPlayer = new GroupPlayer(RoomManager.getRoomByRoomUUID(roomUUID),scoreboard);
            redScore = groupPlayer.getRedScore();
            blueScore = groupPlayer.getBlueScore();

            itemArr = GenerateTaskItem.generateRandomItemList(0);
            for(String playerUUID: RoomManager.getRoomByRoomUUID(roomUUID).getPlayers())
            {
                openScoreBoard(playerUUID);
                Bukkit.getPlayer(UUID.fromString(playerUUID)).setScoreboard(scoreboard);
            }

        }
        catch (NullPointerException nullPointerException)
        {}
    }
    public void openScoreBoard(String playerUUID){
        if(isRun)
        {return;}
        isRun = true;

        Bukkit.getPlayer(UUID.fromString(playerUUID)).setScoreboard(scoreboard);
        ArrayList<String> tempList = new ArrayList<>();
        for(int i =0;i<9;i++)
        {
            tempList.add("§" + ChatColor.values()[i].getChar());
        }
        for(int i =0;i<9;i++)
        {
            Team shower = scoreboard.registerNewTeam(""+i);
            shower.addEntry(tempList.get(i));

            objective.getScore(tempList.get(i)).setScore(i);

            shows.add(shower);
        }
        int n = 0;
        int rn = 0;
        for(int i =0;i<9;i++)
        {
            Team shower = shows.get(i);
            if(i == 8)
            {
                shower.setPrefix(ChatColor.RED + "红队: " + redScore);
            }
            else if(i == 3)
            {
                shower.setPrefix(ChatColor.BLUE + "蓝队: " + blueScore);
            }
            else if(i == 4)
            {
                shower.setPrefix("---------------");
            }
            else
            {
                if(n < 6)
                {
                    try {
                        Map.Entry<Translations,Integer> entry = itemArr.poll().entrySet().iterator().next();
                        if(rn < 3)
                        {
                            groupPlayer.addBlueItem(entry);
                            rn++;
                        }
                        else
                        {
                            groupPlayer.addRedItem(entry);
                        }
                        String trans = entry.getKey().get(playerUUID);
                        int sign = entry.getValue();
                        shower.setSuffix(GenerateTaskItem.throwBySign(trans,sign));
                        n++;
                    }
                    catch (NullPointerException nullPointerException){
                    }
                }
            }
        }
    }
    public void closeScoreboard(String playerUUID){
        try{
            Bukkit.getPlayer(UUID.fromString(playerUUID)).setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
        catch (NullPointerException nullPointerException){}
    }
    public void closeAllScoreboard(String roomUUID){
        try{
            for(String playerUUID: RoomManager.getRoomByRoomUUID(roomUUID).getPlayers()) {
                ((CustomScoreboard) GameManager.getGameByRoomUUID(roomUUID)).closeScoreboard(playerUUID);
            }
            scoreboard.getTeams().forEach(Team::unregister);
        }
        catch (NullPointerException nullPointerException){}
    }

    public Boolean getRun() {
        return isRun;
    }

    public void setRun(Boolean run) {
        isRun = run;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public LinkedList<HashMap<Translations, Integer>> getItemArr() {
        return itemArr;
    }

    public Team whichTeam(String playerUUID){
        try{
            AtomicReference<Boolean> isRed = new AtomicReference<>(false);
            scoreboard.getTeam("RED").getEntries().forEach(entry -> {
            if(entry.equalsIgnoreCase(Bukkit.getPlayer(UUID.fromString(playerUUID)).getName()))
                {
                    isRed.set(true);
                }
            });
            if(isRed.get())
            {
                return scoreboard.getTeam("RED");
            }
            else {
                return scoreboard.getTeam("BLUE");
            }
        }
        catch (NullPointerException nullPointerException){}
        return null;
    }


}
