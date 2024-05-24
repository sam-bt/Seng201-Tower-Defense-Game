package seng201.team0.services;

import seng201.team0.models.Tower;

import java.util.List;

/**
 * Service class for initializing the towers available in the inventory for the first round.
 */
public class RoundOneInventoryService {
    /**
     * Tower for heavy coal.
     */
    private final Tower heavyCoal;

    /**
     * Tower for light coal.
     */
    private final Tower lightCoal;

    /**
     * Tower for heavy iron.
     */
    private final Tower heavyIron;

    /**
     * Tower for light iron.
     */
    private final Tower lightIron;

    /**
     * Tower for heavy gold.
     */
    private final Tower heavyGold;

    /**
     * Tower for light gold.
     */
    private final Tower lightGold;

    /**
     * Constructs a RoundOneInventoryService and initializes towers based on the specified difficulty.
     *
     * @param difficulty The difficulty level of the game.
     */
    public RoundOneInventoryService(double difficulty) {
        heavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(), false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(), TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", TowerGenerator.heavyTowerPriceGenerator(difficulty));
        lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(), false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(), TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", TowerGenerator.lightTowerPriceGenerator(difficulty));
        heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(), false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(), TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", TowerGenerator.heavyTowerPriceGenerator(difficulty));
        lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(), false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(), TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", TowerGenerator.lightTowerPriceGenerator(difficulty));
        heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(), false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(), TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", TowerGenerator.heavyTowerPriceGenerator(difficulty));
        lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(), false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(), TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", TowerGenerator.lightTowerPriceGenerator(difficulty));
    }

    /**
     * Gets the list of towers available in the inventory for the first round.
     *
     * @return A list of towers available in the inventory for the first round.
     */
    public List<Tower> getTowerList() {
        return List.of(heavyCoal, lightCoal, heavyIron, lightIron, heavyGold, lightGold);
    }

}
