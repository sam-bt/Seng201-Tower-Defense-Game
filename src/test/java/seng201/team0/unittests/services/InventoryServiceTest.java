package seng201.team0.unittests.services;
import org.junit.jupiter.api.Test;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.InventoryService;
import seng201.team0.services.TowerGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test InventoryService implementation
 * @author Samuel Beattie
 */
public class InventoryServiceTest {
    /**
     * Test getting the tower list if it is the first time in the inventory
     */

    @Test void getTowerListFirstTime(){
        GameManager gameManager = new GameManager();
        gameManager.setNotFirstTimeInInventory(false);
        gameManager.setDifficulty(new DifficultyService(1.0));
        Tower heavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", TowerGenerator.lightTowerPriceGenerator(1.5));
        gameManager.setRoundOneTowerList(List.of(heavyCoal,lightCoal,heavyIron,lightIron,heavyGold,lightGold));
        InventoryService inventoryService = new InventoryService(gameManager);
        List<Tower> firstTimeTowerList = inventoryService.getTowerList();
        assertEquals(firstTimeTowerList.get(6).getTowerName(), "Heavy Gem");
        assertEquals(firstTimeTowerList.get(7).getTowerName(), "Light Gem");
    }
    /**
     * Test getting the tower list if it is not the first time in the inventory
     */
    @Test void getTowerListNotFirstTime(){
        GameManager gameManager = new GameManager();
        gameManager.setNotFirstTimeInInventory(true);
        gameManager.setDifficulty(new DifficultyService(1.0));
        Tower heavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower lightGem = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Test Light Gem", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower heavyGem = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gem", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Test Heavy Gem", TowerGenerator.lightTowerPriceGenerator(1.5));
        gameManager.setGenericRoundTowerList(List.of(heavyCoal,lightCoal,heavyIron,lightIron,heavyGold,lightGold,lightGem,heavyGem));
        InventoryService inventoryService = new InventoryService(gameManager);
        List<Tower> firstTimeTowerList = inventoryService.getTowerList();
        assertEquals(firstTimeTowerList.get(6).getTowerName(), "Test Light Gem");
        assertEquals(firstTimeTowerList.get(7).getTowerName(), "Test Heavy Gem");
    }
}
