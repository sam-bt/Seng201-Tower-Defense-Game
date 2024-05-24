package seng201.team0.services;

import seng201.team0.models.Tower;

import java.util.*;

/**
 * Class for tower-related operations.
 */
public class TowerService {

    /**
     * Random object used for generating random numbers.
     */
    private static final Random rnd = new Random();

    /**
     * Checks if all towers in the given array are selected.
     *
     * @param selectedTowers The array of selected towers.
     * @return True if all towers are selected, otherwise false.
     */
    public static boolean areAllTowersSelected(Tower[] selectedTowers) {
        for (Tower tower : selectedTowers) {
            if (tower == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the given tower is already selected among the selected towers.
     *
     * @param selectedTowers The array of selected towers.
     * @param tower The tower to check.
     * @return True if the tower is already selected, otherwise false.
     */
    public static boolean isTowerAlreadySelected(Tower[] selectedTowers, Tower tower) {
        for (Tower selectedTower: selectedTowers){
            if (selectedTower == null) {continue;}
            if (Objects.equals(selectedTower.getTowerName(), tower.getTowerName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if all types of round one towers are selected among the selected towers.
     *
     * @param selectedTowers The array of selected towers.
     * @return True if all round one tower types are selected, otherwise false.
     */
    public static boolean areAllRoundOneTowersTypesSelected(Tower[] selectedTowers) {
        HashSet<String> roundOneTowers = new HashSet<>(Arrays.asList("Coal", "Iron", "Gold"));
        for (Tower tower : selectedTowers) {
            if (tower == null) {return false;}
            roundOneTowers.remove(tower.getFillType());
        }
        return roundOneTowers.isEmpty();
    }

    /**
     * Determines if a tower should break based on its break chance.
     *
     * @param tower The tower to check.
     * @return True if the tower should break, otherwise false.
     */
    public static boolean shouldTowerBreak(Tower tower){
        int likelihood = rnd.nextInt(101);
        return tower.getBreakChance() > likelihood;
    }

    /**
     * Breaks towers in the given list if they are owned and should break.
     *
     * @param towerList The list of towers to check and break.
     */
    public static void breakTowers(List<Tower> towerList){
        for (Tower tower: towerList) {
            if (tower.getOwned() && shouldTowerBreak(tower)) {
                tower.breakTower();
            }
        }
    }
}