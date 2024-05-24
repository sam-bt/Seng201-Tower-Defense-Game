package seng201.team0.unittests.services;
import org.junit.jupiter.api.Test;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.TowerGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class InventoryServiceTest {
    @Test void getTowerListFirstTime(){
        GameManager gameManager = new GameManager();
        gameManager.setNotFirstTimeInInventory(false);
        Tower HeavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", 1.5, TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower LightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", 1.5,TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower HeavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", 1.5,TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower LightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", 1.5,TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower HeavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", 1.5,TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower LightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", 1.5,TowerGenerator.lightTowerPriceGenerator(1.5));
        gameManager.setRoundOneTowerList(List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold));
        InventoryService inventoryService = new InventoryService(gameManager);
    }
}
