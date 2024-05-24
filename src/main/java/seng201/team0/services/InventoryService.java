package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;

import java.util.List;

/**
 * Service for managing the inventory in the game.
 * This includes tracking and initializing various types of towers,
 * and the available revives, heals, and upgrades.
 */
public class InventoryService {
    /**
     * Heavy coal tower object.
     */
    private Tower HeavyCoal;

    /**
     * Light coal tower object.
     */
    private Tower LightCoal;

    /**
     * Heavy iron tower object.
     */
    private Tower HeavyIron;

    /**
     * Light iron tower object.
     */
    private Tower LightIron;

    /**
     * Heavy gold tower object.
     */
    private Tower HeavyGold;

    /**
     * Light gold tower object.
     */
    private Tower LightGold;

    /**
     * Heavy gem tower object.
     */
    private Tower HeavyGem;

    /**
     * Light gem tower object.
     */
    private Tower LightGem;

    /**
     * The number of available revives in the inventory.
     */
    public int availableRevives;

    /**
     * The number of available heals in the inventory.
     */
    public int availableHeals;

    /**
     * The number of available upgrades in the inventory.
     */
    public int availableUpgrades;

    /**
     * Constructor for InventoryService.
     * Initializes the inventory based on whether it's the first time entering the inventory or not.
     *
     * @param inventoryServiceGameManager the game manager instance used to retrieve game-related information
     */
    public InventoryService(GameManager inventoryServiceGameManager) {
        double currDifficulty = inventoryServiceGameManager.getDifficulty();

        if (!inventoryServiceGameManager.isNotFirstTimeInInventory()) {
            inventoryServiceGameManager.setNotFirstTimeInInventory(true);
            availableHeals = 0;
            availableRevives = 0;
            availableUpgrades = 0;
            HeavyCoal = inventoryServiceGameManager.getRoundOneTowerList().get(0);
            LightCoal = inventoryServiceGameManager.getRoundOneTowerList().get(1);
            HeavyIron = inventoryServiceGameManager.getRoundOneTowerList().get(2);
            LightIron = inventoryServiceGameManager.getRoundOneTowerList().get(3);
            HeavyGold = inventoryServiceGameManager.getRoundOneTowerList().get(4);
            LightGold = inventoryServiceGameManager.getRoundOneTowerList().get(5);
            HeavyGem = new Tower(
                    TowerGenerator.heavyTowerHealthGenerator(),
                    false,
                    "Gem",
                    TowerGenerator.heavyTowerFillAmountGenerator(),
                    TowerGenerator.heavyTowerReloadSpeedGenerator(),
                    "Heavy Gem",
                    currDifficulty,
                    TowerGenerator.heavyTowerPriceGenerator(currDifficulty)
            );
            LightGem = new Tower(
                    TowerGenerator.lightTowerHealthGenerator(),
                    false,
                    "Gem",
                    TowerGenerator.lightTowerFillAmountGenerator(),
                    TowerGenerator.lightTowerReloadSpeedGenerator(),
                    "Light Gem",
                    currDifficulty,
                    TowerGenerator.lightTowerPriceGenerator(currDifficulty)
            );
            List<Tower> towerList = List.of(HeavyCoal, LightCoal, HeavyIron, LightIron, HeavyGold, LightGold, HeavyGem, LightGem);
            inventoryServiceGameManager.setGenericRoundTowerList(towerList);
        } else {
            availableHeals = inventoryServiceGameManager.getAvailableHeals();
            availableRevives = inventoryServiceGameManager.getAvailableRevives();
            availableUpgrades = inventoryServiceGameManager.getAvailableUpgrades();
            HeavyCoal = inventoryServiceGameManager.getGenericRoundTowerList().get(0);
            LightCoal = inventoryServiceGameManager.getGenericRoundTowerList().get(1);
            HeavyIron = inventoryServiceGameManager.getGenericRoundTowerList().get(2);
            LightIron = inventoryServiceGameManager.getGenericRoundTowerList().get(3);
            HeavyGold = inventoryServiceGameManager.getGenericRoundTowerList().get(4);
            LightGold = inventoryServiceGameManager.getGenericRoundTowerList().get(5);
            HeavyGem = inventoryServiceGameManager.getGenericRoundTowerList().get(6);
            LightGem = inventoryServiceGameManager.getGenericRoundTowerList().get(7);
        }
    }

    /**
     * Returns the list of towers in the inventory.
     *
     * @return a list containing all the towers
     */
    public List<Tower> getTowerList() {
        return List.of(HeavyCoal, LightCoal, HeavyIron, LightIron, HeavyGold, LightGold, HeavyGem, LightGem);
    }
}
