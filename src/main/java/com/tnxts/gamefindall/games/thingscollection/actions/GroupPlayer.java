package com.tnxts.gamefindall.games.thingscollection.actions;

import com.tnxts.gamefindall.customs.QueueRoom;
import com.tnxts.gamefindall.utils.Translations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;

public class GroupPlayer {
    private int redScore;
    private int blueScore;
    private final static int redPos = 8;
    private final static int bluPos = 3;

    public static int getRedPos() {
        return redPos;
    }

    public static int getBluPos() {
        return bluPos;
    }

    private ArrayList<Map.Entry<Translations, Integer>> redItems;
    private ArrayList<Map.Entry<Translations, Integer>> blueItems;


    public GroupPlayer(QueueRoom room, Scoreboard scoreboard) {
        redScore = 0;
        blueScore = 0;
        redItems = new ArrayList<>();
        blueItems = new ArrayList<>();
        groupPlayers(room, scoreboard);
    }

    public void groupPlayers(QueueRoom room, Scoreboard scoreboard) {
        int n = room.getPlayers().size();

        int rNum = n >>> 1;
        Bukkit.broadcastMessage(rNum + "");
        int bNum = n - rNum;
        Team redTeam = scoreboard.registerNewTeam("RED");
        Team blueTeam = scoreboard.registerNewTeam("BLUE");

        redTeam.setDisplayName("红队");
        blueTeam.setDisplayName("蓝队");

        redTeam.setColor(ChatColor.RED);
        blueTeam.setColor(ChatColor.BLUE);

        redTeam.setCanSeeFriendlyInvisibles(true);
        blueTeam.setCanSeeFriendlyInvisibles(true);

        redTeam.setPrefix("§c红队|");
        blueTeam.setPrefix("§9蓝队|");

        ArrayList<Integer> plArr = new ArrayList<>();
        int rand;
        Random r = new Random();
        int i = 0;
        List<String> playerList = (List<String>) room.getPlayers();
        while (i < playerList.size()) {
            rand = r.nextInt(0, playerList.size());
            if (!plArr.contains(rand)) {
                String playerUUID = playerList.get(rand);
                if (rNum > 0) {
                    try {
                        Bukkit.broadcastMessage(Bukkit.getPlayer(UUID.fromString(playerUUID)).getName() + "=========");
                        redTeam.addEntry(Bukkit.getPlayer(UUID.fromString(playerUUID)).getName());
                        rNum--;
                    } catch (NullPointerException nullPointerException) {
                    }
                } else if (bNum > 0) {
                    try {
                        blueTeam.addEntry(Bukkit.getPlayer(UUID.fromString(playerUUID)).getName());
                        bNum--;
                    } catch (NullPointerException nullPointerException) {
                    }
                }
                plArr.add(rand);
                i++;
            }
        }
        scoreboard.getTeams().forEach(team -> {
            Bukkit.broadcastMessage("名字: " + team.getName());
            Bukkit.broadcastMessage("展示名: " + team.getDisplayName());
            Bukkit.broadcastMessage("展示名: " + team.getPrefix());
            Bukkit.broadcastMessage("已有队员: ");
            team.getEntries().forEach(player -> {
                Bukkit.broadcastMessage(" - " + player);
            });
            Bukkit.broadcastMessage("=====================");
        });
    }

    public int getRedScore() {
        return redScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public void setBlueScore(int blueScore) {
        this.blueScore = blueScore;
    }

    public ArrayList<Map.Entry<Translations, Integer>> getRedItems() {
        return redItems;
    }

    public void addRedItem(Map.Entry<Translations, Integer> item) {
        redItems.add(item);
    }

    public ArrayList<Map.Entry<Translations, Integer>> getBlueItems() {
        return blueItems;
    }

    public void addBlueItem(Map.Entry<Translations, Integer> item) {
        blueItems.add(item);
    }

    public static int levelToScore(int level) {
        switch (level) {
            case 0:
                return 3;
            case 1:
                return 5;
            case 2:
                return 8;
            case 3:
                return 50;
            default:
                return 3;
        }
    }
}
