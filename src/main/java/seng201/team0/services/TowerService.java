package seng201.team0.services;

import seng201.team0.models.Tower;

import java.util.*;

public class TowerService {
    private static final Random rnd = new Random();
    public static boolean areAllTowersSelected(Tower[] selectedTowers) {
        for (Tower tower : selectedTowers) {
            if (tower == null) {
                return false;
            }
        }
        return true;
    }
    public static boolean isTowerAlreadySelected(Tower[] selectedTowers, Tower tower) {
        for (Tower selectedTower: selectedTowers){
            if (selectedTower == null) {continue;}
            if (Objects.equals(selectedTower.getTowerName(), tower.getTowerName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean areAllRoundOneTowersTypesSelected(Tower[] selectedTowers) {
        HashSet<String> roundOneTowers = new HashSet<>(Arrays.asList("Coal", "Iron", "Gold"));
        for (Tower tower : selectedTowers) {
            if (tower == null) {return false;}
            roundOneTowers.remove(tower.getFillType());
        }
        return roundOneTowers.isEmpty();
    }
    public static boolean shouldTowerBreak(Tower tower){
        int likelihood = rnd.nextInt(101);
        return tower.getBreakChance() > likelihood;
    }
    public static void breakTowers(List<Tower> towerList){
        for (Tower tower: towerList) {
            if (tower.getOwned() && shouldTowerBreak(tower)) {
                tower.breakTower();
            }
        }
    }
}