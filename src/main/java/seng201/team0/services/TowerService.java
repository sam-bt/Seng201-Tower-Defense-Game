package seng201.team0.services;

import seng201.team0.models.Tower;

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
    public static boolean isTowerAlreadySelected(Tower[] selectedTowers, Tower tower) {
        for (Tower selectedTower: selectedTowers){
            if (selectedTower == tower) {
                return true;
            }
        }
        return false;
    }
}