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
//        System.out.println("round one tower list:");                       //i was testing
//        for (int i = 0; i < inventoryServiceGameManager.getRoundOneTowerList().size(); i++) {
//            System.out.println(inventoryServiceGameManager.getRoundOneTowerList().get(i).getTowerName());
//        }

        availableHeals = 0;
        availableRevives = 0;
        availableUpgrades = 0;
        HeavyCoal = inventoryServiceGameManager.getRoundOneTowerList().get(0);
        LightCoal = inventoryServiceGameManager.getRoundOneTowerList().get(1);
        HeavyIron = inventoryServiceGameManager.getRoundOneTowerList().get(2);
        LightIron = inventoryServiceGameManager.getRoundOneTowerList().get(3);
        HeavyGold = inventoryServiceGameManager.getRoundOneTowerList().get(4);
        LightGold = inventoryServiceGameManager.getRoundOneTowerList().get(5);
        HeavyGem = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gem", currDifficulty);
        LightGem = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gem", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gem", currDifficulty);

    }
    public List<Tower> getTowerList(){
        return List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold,HeavyGem,LightGem);
    }

}
