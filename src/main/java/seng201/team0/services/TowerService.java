package seng201.team0.services;

import seng201.team0.models.Tower;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TowerService {
    public static boolean areAllTowersSelected(Tower[] selectedTowers) {
        for (Tower tower : selectedTowers) {
            if (tower == null) {
                return false;
            }
        }
        return true;
    }
    public static boolean isTowerAlreadySelected(Tower[] selectedTowers, Tower[] gameSelectedTowers, Tower tower) {
        for (Tower selectedTower: selectedTowers){
            if (selectedTower == tower) {
                return true;
            }
        }
        if (gameSelectedTowers == null) {return false;}
        for (Tower gameSelectedTower: gameSelectedTowers){
            if (gameSelectedTower == tower) {
                return true;
            }
        }
        return false;
    }
    public static boolean areAllTowersTypesSelected(Tower[] selectedTowers) {
        HashSet<String> roundOneTowers = new HashSet<>(Arrays.asList("Coal", "Iron", "Gold", "Gem"));
        for (Tower tower : selectedTowers) {
            if (tower == null) {return false;}
            roundOneTowers.remove(tower.getFillType());
        }
        return roundOneTowers.isEmpty();
    }
    public static boolean areAllRoundOneTowersTypesSelected(Tower[] selectedTowers) {
        HashSet<String> roundOneTowers = new HashSet<>(Arrays.asList("Coal", "Iron", "Gold"));
        for (Tower tower : selectedTowers) {
            if (tower == null) {return false;}
            roundOneTowers.remove(tower.getFillType());
        }
        return roundOneTowers.isEmpty();
    }
}