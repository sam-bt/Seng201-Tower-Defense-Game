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
    private final Tower heavyCoal;

    /**
     * Light coal tower object.
     */
    private final Tower lightCoal;

    /**
     * Heavy iron tower object.
     */
    private final Tower heavyIron;

    /**
     * Light iron tower object.
     */
    private final Tower lightIron;

    /**
     * Heavy gold tower object.
     */
    private final Tower heavyGold;

    /**
     * Light gold tower object.
     */
    private final Tower lightGold;

    /**
     * Heavy gem tower object.
     */
    private final Tower heavyGem;

    /**
     * Light gem tower object.
     */
    private final Tower lightGem;

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
            heavyCoal = inventoryServiceGameManager.getRoundOneTowerList().get(0);
            lightCoal = inventoryServiceGameManager.getRoundOneTowerList().get(1);
            heavyIron = inventoryServiceGameManager.getRoundOneTowerList().get(2);
            lightIron = inventoryServiceGameManager.getRoundOneTowerList().get(3);
            heavyGold = inventoryServiceGameManager.getRoundOneTowerList().get(4);
            lightGold = inventoryServiceGameManager.getRoundOneTowerList().get(5);
            heavyGem = new Tower(TowerGenerator.heavyTowerHealthGenerator(), false, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(), TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gem", TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
            lightGem = new Tower(TowerGenerator.lightTowerHealthGenerator(), false, "Gem", TowerGenerator.lightTowerFillAmountGenerator(), TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gem", TowerGenerator.lightTowerPriceGenerator(currDifficulty));
            List<Tower> towerList = List.of(heavyCoal, lightCoal, heavyIron, lightIron, heavyGold, lightGold, heavyGem, lightGem);
            inventoryServiceGameManager.setGenericRoundTowerList(towerList);
        } else {
            availableHeals = inventoryServiceGameManager.getAvailableHeals();
            availableRevives = inventoryServiceGameManager.getAvailableRevives();
            availableUpgrades = inventoryServiceGameManager.getAvailableUpgrades();
            heavyCoal = inventoryServiceGameManager.getGenericRoundTowerList().get(0);
            lightCoal = inventoryServiceGameManager.getGenericRoundTowerList().get(1);
            heavyIron = inventoryServiceGameManager.getGenericRoundTowerList().get(2);
            lightIron = inventoryServiceGameManager.getGenericRoundTowerList().get(3);
            heavyGold = inventoryServiceGameManager.getGenericRoundTowerList().get(4);
            lightGold = inventoryServiceGameManager.getGenericRoundTowerList().get(5);
            heavyGem = inventoryServiceGameManager.getGenericRoundTowerList().get(6);
            lightGem = inventoryServiceGameManager.getGenericRoundTowerList().get(7);
        }
    }

    /**
     * Returns the list of tower objects in the inventory.
     *
     * @return a list containing all the towers
     */
    public List<Tower> getTowerList() {
        return List.of(heavyCoal, lightCoal, heavyIron, lightIron, heavyGold, lightGold, heavyGem, lightGem);
    }
}
