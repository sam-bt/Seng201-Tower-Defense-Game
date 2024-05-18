package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;

import java.util.List;

public class InventoryService {
    Tower HeavyCoal;
    Tower LightCoal;
    Tower HeavyIron;
    Tower LightIron;
    Tower HeavyGold;
    Tower LightGold;
    Tower HeavyGem;
    Tower LightGem;
    public int availableRevives;
    public int availableHeals;
    public int availableUpgrades;
    public InventoryService(GameManager inventoryServiceGameManager){
        double currDifficulty = inventoryServiceGameManager.getDifficulty();
        availableHeals = 0;
        availableRevives = 0;
        availableUpgrades = 0;
        HeavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", currDifficulty);
        LightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", currDifficulty);
        HeavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", currDifficulty);
        LightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", currDifficulty);
        HeavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", currDifficulty);
        LightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", currDifficulty);
        HeavyGem = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gem", currDifficulty);
        LightGem = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gem", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gem", currDifficulty);

    }
    public List<Tower> getTowerList(){
        return List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold,HeavyGem,LightGem);
    }

}
