package com.tnxts.gamefindall.games.thingscollection.actions;

import com.tnxts.gamefindall.games.thingscollection.guis.CustomScoreboard;
import com.tnxts.gamefindall.managers.GameManager;
import com.tnxts.gamefindall.utils.Translations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;

public class GenerateTaskItem {
    private static final ArrayList<Translations> easyItem = new ArrayList<>();
    private static final ArrayList<Translations> mediumItem = new ArrayList<>();
    private static final ArrayList<Translations> difficultItem = new ArrayList<>();
    private static final ArrayList<Translations> evilItem = new ArrayList<>();


    static {
        easyItem.add(Translations.ACACIA_BOAT);
        easyItem.add(Translations.ACACIA_CHEST_BOAT);
        easyItem.add(Translations.APPLE);
        easyItem.add(Translations.ARROW);
        easyItem.add(Translations.AXOLOTL_BUCKET);
        easyItem.add(Translations.BAKED_POTATO);
        easyItem.add(Translations.BEEF);
        easyItem.add(Translations.BEETROOT);
        easyItem.add(Translations.BEETROOT_SEEDS);
        easyItem.add(Translations.BEETROOT_SOUP);
        easyItem.add(Translations.BIRCH_BOAT);
        easyItem.add(Translations.BIRCH_CHEST_BOAT);
        easyItem.add(Translations.BLACK_DYE);
        easyItem.add(Translations.BLAZE_POWDER);
        easyItem.add(Translations.BLAZE_ROD);
        easyItem.add(Translations.BLUE_DYE);
        easyItem.add(Translations.BONE);
        easyItem.add(Translations.BONE_MEAL);
        easyItem.add(Translations.BOOK);
        easyItem.add(Translations.BOW);
        easyItem.add(Translations.BOWL);
        easyItem.add(Translations.BREAD);
        easyItem.add(Translations.BROWN_DYE);
        easyItem.add(Translations.BUCKET);
        easyItem.add(Translations.BUNDLE);
        easyItem.add(Translations.CARROT);
        easyItem.add(Translations.CARROT_ON_A_STICK);
        easyItem.add(Translations.CHARCOAL);
        easyItem.add(Translations.CHEST_MINECART);
        easyItem.add(Translations.CHICKEN);
        easyItem.add(Translations.CLAY_BALL);
        easyItem.add(Translations.CLOCK);
        easyItem.add(Translations.COAL);
        easyItem.add(Translations.COCOA_BEANS);
        easyItem.add(Translations.COD);
        easyItem.add(Translations.COD_BUCKET);
        easyItem.add(Translations.COMPASS);
        easyItem.add(Translations.COOKED_BEEF);
        easyItem.add(Translations.COOKED_CHICKEN);
        easyItem.add(Translations.COOKED_COD);
        easyItem.add(Translations.COOKED_MUTTON);
        easyItem.add(Translations.COOKED_PORKCHOP);
        easyItem.add(Translations.COOKED_RABBIT);
        easyItem.add(Translations.COOKED_SALMON);
        easyItem.add(Translations.COOKIE);
        easyItem.add(Translations.COPPER_INGOT);
        easyItem.add(Translations.CREEPER_BANNER_PATTERN);
        easyItem.add(Translations.CROSSBOW);
        easyItem.add(Translations.CYAN_DYE);
        easyItem.add(Translations.DARK_OAK_BOAT);
        easyItem.add(Translations.DARK_OAK_CHEST_BOAT);
        easyItem.add(Translations.FEATHER);
        easyItem.add(Translations.FERMENTED_SPIDER_EYE);
        easyItem.add(Translations.FISHING_ROD);
        easyItem.add(Translations.FLINT);
        easyItem.add(Translations.FLINT_AND_STEEL);
        easyItem.add(Translations.GLASS_BOTTLE);
        easyItem.add(Translations.GLOWSTONE_DUST);
        easyItem.add(Translations.GOAT_SPAWN_EGG);
        easyItem.add(Translations.GOLD_INGOT);
        easyItem.add(Translations.GOLD_NUGGET);
        easyItem.add(Translations.GOLDEN_APPLE);
        easyItem.add(Translations.GOLDEN_AXE);
        easyItem.add(Translations.GOLDEN_BOOTS);
        easyItem.add(Translations.GOLDEN_CARROT);
        easyItem.add(Translations.GOLDEN_CHESTPLATE);
        easyItem.add(Translations.GOLDEN_HELMET);
        easyItem.add(Translations.GOLDEN_HOE);
        easyItem.add(Translations.GOLDEN_HORSE_ARMOR);
        easyItem.add(Translations.GOLDEN_LEGGINGS);
        easyItem.add(Translations.GOLDEN_PICKAXE);
        easyItem.add(Translations.GOLDEN_SHOVEL);
        easyItem.add(Translations.GOLDEN_SWORD);
        easyItem.add(Translations.GRAY_DYE);
        easyItem.add(Translations.GREEN_DYE);
        easyItem.add(Translations.GUNPOWDER);
        easyItem.add(Translations.HONEY_BOTTLE);
        easyItem.add(Translations.HONEYCOMB);
        easyItem.add(Translations.HOPPER_MINECART);
        easyItem.add(Translations.INK_SAC);
        easyItem.add(Translations.IRON_AXE);
        easyItem.add(Translations.IRON_BOOTS);
        easyItem.add(Translations.IRON_CHESTPLATE);
        easyItem.add(Translations.IRON_HELMET);
        easyItem.add(Translations.IRON_HOE);
        easyItem.add(Translations.IRON_HORSE_ARMOR);
        easyItem.add(Translations.IRON_INGOT);
        easyItem.add(Translations.IRON_LEGGINGS);
        easyItem.add(Translations.IRON_NUGGET);
        easyItem.add(Translations.IRON_PICKAXE);
        easyItem.add(Translations.IRON_SHOVEL);
        easyItem.add(Translations.IRON_SWORD);
        easyItem.add(Translations.ITEM_FRAME);
        easyItem.add(Translations.JUNGLE_BOAT);
        easyItem.add(Translations.JUNGLE_CHEST_BOAT);
        easyItem.add(Translations.LAPIS_LAZULI);
        easyItem.add(Translations.LAVA_BUCKET);
        easyItem.add(Translations.LEAD);
        easyItem.add(Translations.LEATHER);
        easyItem.add(Translations.LEATHER_BOOTS);
        easyItem.add(Translations.LEATHER_CHESTPLATE);
        easyItem.add(Translations.LEATHER_HELMET);
        easyItem.add(Translations.LEATHER_HORSE_ARMOR);
        easyItem.add(Translations.LEATHER_LEGGINGS);
        easyItem.add(Translations.LIGHT_BLUE_DYE);
        easyItem.add(Translations.LIGHT_GRAY_DYE);
        easyItem.add(Translations.LIME_DYE);
        easyItem.add(Translations.LODESTONE);
        easyItem.add(Translations.MAGENTA_DYE);
        easyItem.add(Translations.MAGMA_CREAM);
        easyItem.add(Translations.MANGROVE_BOAT);
        easyItem.add(Translations.MANGROVE_CHEST_BOAT);
        easyItem.add(Translations.MAP);
        easyItem.add(Translations.MELON_SEEDS);
        easyItem.add(Translations.MELON_SLICE);
        easyItem.add(Translations.MILK_BUCKET);
        easyItem.add(Translations.MINECART);
        easyItem.add(Translations.MOJANG_BANNER_PATTERN);
        easyItem.add(Translations.MUSHROOM_STEW);
        easyItem.add(Translations.MUTTON);
        easyItem.add(Translations.NAME_TAG);
        easyItem.add(Translations.NAUTILUS_SHELL);
        easyItem.add(Translations.OAK_BOAT);
        easyItem.add(Translations.OAK_CHEST_BOAT);
        easyItem.add(Translations.ORANGE_DYE);
        easyItem.add(Translations.PAINTING);
        easyItem.add(Translations.PAPER);
        easyItem.add(Translations.PINK_DYE);
        easyItem.add(Translations.POISONOUS_POTATO);
        easyItem.add(Translations.PORKCHOP);
        easyItem.add(Translations.POTATO);
        easyItem.add(Translations.POWDER_SNOW_BUCKET);
        easyItem.add(Translations.PRISMARINE_CRYSTALS);
        easyItem.add(Translations.PRISMARINE_SHARD);
        easyItem.add(Translations.PUFFERFISH);
        easyItem.add(Translations.PUFFERFISH_BUCKET);
        easyItem.add(Translations.PUMPKIN_PIE);
        easyItem.add(Translations.PUMPKIN_SEEDS);
        easyItem.add(Translations.PURPLE_DYE);
        easyItem.add(Translations.RABBIT);
        easyItem.add(Translations.RABBIT_FOOT);
        easyItem.add(Translations.RABBIT_HIDE);
        easyItem.add(Translations.RABBIT_STEW);
        easyItem.add(Translations.RAW_COPPER);
        easyItem.add(Translations.RAW_GOLD);
        easyItem.add(Translations.RAW_IRON);
        easyItem.add(Translations.RED_DYE);
        easyItem.add(Translations.REDSTONE);
        easyItem.add(Translations.ROTTEN_FLESH);
        easyItem.add(Translations.SADDLE);
        easyItem.add(Translations.SALMON);
        easyItem.add(Translations.SALMON_BUCKET);
        easyItem.add(Translations.SCUTE);
        easyItem.add(Translations.SHEARS);
        easyItem.add(Translations.SHIELD);
        easyItem.add(Translations.SHULKER_SHELL);
        easyItem.add(Translations.SPRUCE_SIGN);
        easyItem.add(Translations.ACACIA_SIGN);
        easyItem.add(Translations.BIRCH_SIGN);
        easyItem.add(Translations.CRIMSON_SIGN);
        easyItem.add(Translations.JUNGLE_SIGN);
        easyItem.add(Translations.SPRUCE_WALL_SIGN);
        easyItem.add(Translations.ACACIA_WALL_SIGN);
        easyItem.add(Translations.BIRCH_WALL_SIGN);
        easyItem.add(Translations.CRIMSON_WALL_SIGN);

        mediumItem.add(Translations.GOAT_HORN);
        mediumItem.add(Translations.GOLD_INGOT);
        mediumItem.add(Translations.GOLD_NUGGET);
        mediumItem.add(Translations.GOLDEN_APPLE);
        mediumItem.add(Translations.GOLDEN_AXE);
        mediumItem.add(Translations.GOLDEN_BOOTS);
        mediumItem.add(Translations.GOLDEN_CARROT);
        mediumItem.add(Translations.GOLDEN_CHESTPLATE);
        mediumItem.add(Translations.GOLDEN_HELMET);
        mediumItem.add(Translations.GOLDEN_HOE);
        mediumItem.add(Translations.GOLDEN_HORSE_ARMOR);
        mediumItem.add(Translations.GOLDEN_LEGGINGS);
        mediumItem.add(Translations.GOLDEN_PICKAXE);

        difficultItem.add(Translations.LEATHER);
        difficultItem.add(Translations.LEATHER_BOOTS);
        difficultItem.add(Translations.LEATHER_CHESTPLATE);
        difficultItem.add(Translations.LEATHER_HELMET);
        difficultItem.add(Translations.LEATHER_HORSE_ARMOR);
        difficultItem.add(Translations.LEATHER_LEGGINGS);
        difficultItem.add(Translations.LIGHT_BLUE_DYE);
        difficultItem.add(Translations.LIGHT_GRAY_DYE);
        difficultItem.add(Translations.LIME_DYE);
        difficultItem.add(Translations.LINGERING_POTION);
        difficultItem.add(Translations.LODESTONE);
        difficultItem.add(Translations.MAGENTA_DYE);
        difficultItem.add(Translations.MAGMA_CREAM);
        difficultItem.add(Translations.MANGROVE_BOAT);

        evilItem.add(Translations.NAUTILUS_SHELL);
        evilItem.add(Translations.NETHER_BRICK);
        evilItem.add(Translations.NETHER_STAR);
        evilItem.add(Translations.NETHER_WART);
        evilItem.add(Translations.NETHERITE_AXE);
        evilItem.add(Translations.NETHERITE_BOOTS);
        evilItem.add(Translations.NETHERITE_CHESTPLATE);
    }

    private static int easyItemNum = easyItem.size();
    private static int mediumItemNum = mediumItem.size();
    private static int difficultItemNum = difficultItem.size();
    private static int evilItemNum = evilItem.size();

    private static final int easyItemSign = 0;
    private static final int mediumItemSign = 1;
    private static final int difficultItemSign = 2;
    private static final int evilItemSign = 3;

    public static String throwEasyItem(String trans) {

        return ChatColor.GRAY + "简单" + ChatColor.WHITE + " | " + trans;
    }

    public static String throwMediumItem(String trans) {
        Random r = new Random();
        int rand = r.nextInt(mediumItem.size());
        return ChatColor.GOLD + "中等" + ChatColor.WHITE + " | " + trans;
    }

    public static String throwDifficultItem(String trans) {
        Random r = new Random();
        int rand = r.nextInt(difficultItem.size());
        return ChatColor.DARK_RED + "困难" + ChatColor.WHITE + " | " + trans;
    }

    public static String throwEvilItem(String trans) {
        Random r = new Random();
        int rand = r.nextInt(evilItem.size());
        return ChatColor.DARK_PURPLE + "邪恶" + ChatColor.WHITE + " | " + trans;
    }

    public static LinkedList<HashMap<Translations, Integer>> generateRandomItemList(int score) {
        LinkedList<HashMap<Translations, Integer>> list = new LinkedList<>();
        int i = 0;
        int rand;
        ArrayList<Integer> contain = new ArrayList<>();
        int mode = generateMode(score);
        Random r = new Random();
        Random rmode = new Random();
        while (i < 6) {
            switch (mode) {
                case 0:
                    rand = r.nextInt(0, easyItemNum);
                    if (!contain.contains(rand)) {
                        giveItem(list, easyItem.get(rand), easyItemSign);
                        contain.add(rand);
                        i++;
                    }
                    break;
                case 1:
                    if (rmode.nextInt(0, 100) < 40) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, mediumItem.get(rand), mediumItemSign);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, easyItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, easyItem.get(rand), easyItemSign);
                            contain.add(rand);
                            i++;
                        }
                    }

                    break;
                case 2:
                    if (rmode.nextInt(0, 100) < 20) {
                        rand = r.nextInt(0, difficultItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, difficultItem.get(rand), difficultItemSign);
                            contain.add(rand);
                            i++;
                        }
                    } else if (rmode.nextInt(0, 100) < 60) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, mediumItem.get(rand), mediumItemSign);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, easyItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, easyItem.get(rand), easyItemSign);
                            contain.add(rand);
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (rmode.nextInt(0, 100) < 40) {
                        rand = r.nextInt(0, difficultItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, difficultItem.get(rand), difficultItemSign);
                            contain.add(rand);
                            i++;
                        }
                    } else if (rmode.nextInt(0, 100) < 97) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, mediumItem.get(rand), mediumItemSign);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, evilItemNum);
                        if (!contain.contains(rand)) {
                            giveItem(list, evilItem.get(rand), evilItemSign);
                            contain.add(rand);
                            i++;
                        }
                    }
                    break;
            }
        }
        return list;
    }

    public static void updateRandomItemList(ArrayList<Map.Entry<Translations, Integer>> list, String playerUUID, Team team, int score) {
        if (team.getName().equalsIgnoreCase("RED")) {
            for (int i = 5; i < 8; i++) {
                ((CustomScoreboard) GameManager.getGameByPlayerUUID(playerUUID)).getScoreboard().getTeam("" + i).setPrefix("");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                ((CustomScoreboard) GameManager.getGameByPlayerUUID(playerUUID)).getScoreboard().getTeam("" + i).setPrefix("");
            }
        }
        int i = 0;
        int rand;
        ArrayList<Integer> contain = new ArrayList<>();
        int mode = generateMode(score);
        Bukkit.broadcastMessage(mode+"");
        Random r = new Random();
        Random rmode = new Random();
        while (i < 3) {
            switch (mode) {
                case 0:
                    rand = r.nextInt(0, easyItemNum);
                    if (!contain.contains(rand)) {
                        giveLastItem(list, easyItem.get(rand), easyItemSign);
                        easyItem.remove(rand);
                        contain.add(rand);
                        i++;
                    }
                    break;
                case 1:
                    if (rmode.nextInt(0, 100) < 60) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, mediumItem.get(rand), mediumItemSign);
                            mediumItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, easyItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, easyItem.get(rand), easyItemSign);
                            easyItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    }

                    break;
                case 2:
                    if (rmode.nextInt(0, 100) < 35) {
                        rand = r.nextInt(0, difficultItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, difficultItem.get(rand), difficultItemSign);
                            difficultItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    } else if (rmode.nextInt(0, 100) < 50) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, mediumItem.get(rand), mediumItemSign);
                            mediumItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, easyItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, easyItem.get(rand), easyItemSign);
                            easyItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    }
                    break;
                case 3:
                    if (rmode.nextInt(0, 100) < 40) {
                        rand = r.nextInt(0, difficultItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, difficultItem.get(rand), difficultItemSign);
                            difficultItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    } else if (rmode.nextInt(0, 100) < 97) {
                        rand = r.nextInt(0, mediumItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, mediumItem.get(rand), mediumItemSign);
                            mediumItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    } else {
                        rand = r.nextInt(0, evilItemNum);
                        if (!contain.contains(rand)) {
                            giveLastItem(list, evilItem.get(rand), evilItemSign);
                            easyItem.remove(rand);
                            contain.add(rand);
                            i++;
                        }
                    }
                    break;
            }
            reloadItemArraySize();
        }
    }

    public static int generateMode(int score) {
        score /= 10;
        if (score < 1) {
            return 0;
        } else if (score < 2) {
            return 1;
        } else if (score < 4) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void giveLastItem(ArrayList<Map.Entry<Translations, Integer>> list, Translations t, int sign) {
        HashMap<Translations, Integer> arr = new HashMap<>();
        arr.put(t, sign);
        list.add(arr.entrySet().iterator().next());
    }

    public static void giveItem(LinkedList<HashMap<Translations, Integer>> list, Translations t, int sign) {
        HashMap<Translations, Integer> arr = new HashMap<>();
        arr.put(t, sign);
        list.addLast(arr);
    }

    public static String throwBySign(String trans, int sign) {
        switch (sign) {
            case easyItemSign:
                return throwEasyItem(trans);
            case mediumItemSign:
                return throwMediumItem(trans);
            case difficultItemSign:
                return throwDifficultItem(trans);
            case evilItemSign:
                return throwEvilItem(trans);
        }
        return "";
    }

    public static int getItemPos(Scoreboard scoreboard, String itemName, Team team) {
        if (team.getName().equalsIgnoreCase("RED")) {
            for (int i = 5; i < 8; i++) {
                String name = scoreboard.getTeam("" + i).getSuffix().substring(9);
                if (name.equalsIgnoreCase(itemName)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                String name = scoreboard.getTeam("" + i).getSuffix().substring(9);
                if (name.equalsIgnoreCase(itemName)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void reloadItemArraySize() {
        easyItemNum = easyItem.size();
        difficultItemNum = difficultItem.size();
        mediumItemNum = mediumItem.size();
        evilItemNum = evilItem.size();
    }
}
