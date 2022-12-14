package com.tnxts.gamefindall.games.thingscollection.actions;

import com.tnxts.gamefindall.games.thingscollection.guis.CustomScoreboard;
import com.tnxts.gamefindall.games.thingscollection.managers.ThingsCollectionManager;
import com.tnxts.gamefindall.managers.GameManager;
import com.tnxts.gamefindall.managers.RoomManager;
import com.tnxts.gamefindall.utils.Translations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class ClickRequiredItem implements Listener {
    @EventHandler
    public void ClickRequiredItem(InventoryClickEvent event) {
        try {
            String playerUUID = event.getWhoClicked().getUniqueId().toString();
            if (RoomManager.isPlayerInOneRoom(playerUUID) && GameManager.getGameIDByPlayerUUID(playerUUID).equalsIgnoreCase(ThingsCollectionManager.getGameID()) && ThingsCollectionManager.getIsRun((CustomScoreboard) GameManager.getGameByRoomUUID(RoomManager.getRoomByPlayerUUID(playerUUID).getRoomUUID()))) {
                CustomScoreboard scoreboard = ((CustomScoreboard) GameManager.getGameByPlayerUUID(playerUUID));
                if (scoreboard.whichTeam(playerUUID).getName().equalsIgnoreCase("RED")) {
                    Iterator<Map.Entry<Translations, Integer>> iterator = scoreboard.getGroupPlayer().getRedItems().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Translations, Integer> item = iterator.next();
                        if (item.getKey().name().equalsIgnoreCase(event.getCurrentItem().getType().name())) {
                            scoreboard.getGroupPlayer().setRedScore(GroupPlayer.levelToScore(item.getValue()) + scoreboard.getGroupPlayer().getRedScore());
                            scoreboard.getScoreboard().getTeam("" + GroupPlayer.getRedPos()).setPrefix((ChatColor.RED + "??????: " + ((CustomScoreboard) GameManager.getGameByPlayerUUID(playerUUID)).getGroupPlayer().getRedScore()));
                            scoreboard.getScoreboard().getTeam("" + GroupPlayer.getRedPos()).setSuffix(ChatColor.AQUA + " (+" + GroupPlayer.levelToScore(item.getValue()) + ")");
                            int pos = GenerateTaskItem.getItemPos(scoreboard.getScoreboard(), item.getKey().get(playerUUID), scoreboard.whichTeam(playerUUID));
                            scoreboard.getScoreboard().getTeam("" + pos).setPrefix(ChatColor.GREEN + "\u2714");
                            for (String gamePlayerUUID : RoomManager.getRoomByPlayerUUID(playerUUID).getPlayers()) {
                                Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).sendMessage("[" + ChatColor.GREEN + "\u2714" + "]" + ChatColor.RED + "??????" + ChatColor.RESET + "??????" + "[" + ChatColor.RED + Bukkit.getPlayer(UUID.fromString(playerUUID)).getName() + ChatColor.RESET + "]" + "?????????" + ChatColor.YELLOW + "??????" + ChatColor.RESET + "[" + ChatColor.RED + item.getKey().get(gamePlayerUUID) + ChatColor.RESET + "]!");
                            }
                            iterator.remove();
                        }
                    }
                    if (scoreboard.getGroupPlayer().getRedItems().size() <= 0) {
                        GenerateTaskItem.updateRandomItemList(scoreboard.getGroupPlayer().getRedItems(), playerUUID, scoreboard.getScoreboard().getTeam("RED"), scoreboard.getGroupPlayer().getRedScore());
                        int i = 5;
                        for (Map.Entry<Translations, Integer> entry : scoreboard.getGroupPlayer().getRedItems()) {
                            String trans = entry.getKey().get(playerUUID);
                            int sign = entry.getValue();
                            scoreboard.getScoreboard().getTeam("" + i).setSuffix(GenerateTaskItem.throwBySign(trans, sign));
                            i++;
                        }
                    }
                } else {
                    Iterator<Map.Entry<Translations, Integer>> iterator = scoreboard.getGroupPlayer().getBlueItems().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Translations, Integer> item = iterator.next();
                        if (item.getKey().name().equalsIgnoreCase(event.getCurrentItem().getType().name())) {
                            scoreboard.getGroupPlayer().setBlueScore(GroupPlayer.levelToScore(item.getValue()) + scoreboard.getGroupPlayer().getBlueScore());
                            scoreboard.getScoreboard().getTeam("" + GroupPlayer.getBluPos()).setPrefix((ChatColor.BLUE + "??????: " + ((CustomScoreboard) GameManager.getGameByPlayerUUID(playerUUID)).getGroupPlayer().getBlueScore()));
                            scoreboard.getScoreboard().getTeam("" + GroupPlayer.getBluPos()).setSuffix(ChatColor.AQUA + " (+" + GroupPlayer.levelToScore(item.getValue()) + ")");
                            int pos = GenerateTaskItem.getItemPos(scoreboard.getScoreboard(), item.getKey().get(playerUUID), scoreboard.whichTeam(playerUUID));
                            scoreboard.getScoreboard().getTeam("" + pos).setPrefix(ChatColor.GREEN + "\u2714");
                            for (String gamePlayerUUID : RoomManager.getRoomByPlayerUUID(playerUUID).getPlayers()) {
                                Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).sendMessage("[" + ChatColor.GREEN + "\u2714" + "]" + ChatColor.BLUE + "??????" + ChatColor.RESET + "??????" + "[" + ChatColor.BLUE + Bukkit.getPlayer(UUID.fromString(playerUUID)).getDisplayName() + ChatColor.RESET + "]" + "?????????" + ChatColor.YELLOW + "??????" + ChatColor.RESET + "[" + ChatColor.BLUE + item.getKey().get(gamePlayerUUID) + ChatColor.RESET + "]!");
                            }
                            iterator.remove();
                        }
                    }
                    if (scoreboard.getGroupPlayer().getBlueItems().size() <= 0) {
                        GenerateTaskItem.updateRandomItemList(scoreboard.getGroupPlayer().getBlueItems(), playerUUID, scoreboard.getScoreboard().getTeam("BLUE"), scoreboard.getGroupPlayer().getBlueScore());
                        int i = 0;
                        for (Map.Entry<Translations, Integer> entry : scoreboard.getGroupPlayer().getBlueItems()) {
                            String trans = entry.getKey().get(playerUUID);
                            int sign = entry.getValue();
                            scoreboard.getScoreboard().getTeam("" + i).setSuffix(GenerateTaskItem.throwBySign(trans, sign));
                            i++;
                        }
                    }
                }
                if (ThingsCollectionManager.isTeamWin(scoreboard, playerUUID)) {
                    for (String gamePlayerUUID : RoomManager.getRoomByPlayerUUID(playerUUID).getPlayers()) {

                        Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).sendTitle(ChatColor.GOLD + "??????" + scoreboard.whichTeam(playerUUID).getColor() + Bukkit.getPlayer(UUID.fromString(playerUUID)).getName() + ChatColor.RESET + "?????????????????????" + ChatColor.GOLD + "??????" + ChatColor.RESET + "!", scoreboard.whichTeam(playerUUID).getColor() + scoreboard.whichTeam(playerUUID).getName() + ChatColor.RESET + "???????????????!!!", 10, 70, 10);
                        for(int i = 0;i<3;i++)
                        {
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 1);
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1, 1);
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1, 1);
                            Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).playSound(Bukkit.getPlayer(UUID.fromString(gamePlayerUUID)).getLocation(), Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, 1, 1);
                        }

                    }
                    ThingsCollectionManager.stopGame(RoomManager.getRoomByPlayerUUID(playerUUID).getRoomUUID());
                }
            }
        } catch (NullPointerException nullPointerException) {
        }
    }
}
