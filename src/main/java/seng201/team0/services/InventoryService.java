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


        System.out.println(inventoryServiceGameManager.getCurrRound());
        if (inventoryServiceGameManager.getCurrRound() == 2) {
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
    public List<Tower> getTowerList(){
        return List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold,HeavyGem,LightGem);
    }
    public void consumeHeal() {
        availableHeals -= 1;
    }
    public void consumeRevive() { availableRevives -= 1; }
    public void consumeUpgrade() {
        availableUpgrades -= 1;
    }

    public void addHeal() {
        availableHeals += 1;
    }
    public void addRevive() { availableRevives += 1;}
    public void addUpgrade() {
        availableUpgrades += 1;
    }

    public int getAvailableHeals() {
        return availableHeals;
    }

    public int getAvailableRevives() {
        return availableRevives;
    }

    public int getAvailableUpgrades() {
        return availableUpgrades;
    }
}
