package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;

public class RoundOneInventoryService {
    public RoundOneInventoryService(GameManager roundOneServiceGameManager){
        double currDifficulty = roundOneServiceGameManager.getDifficulty();
        Tower HeavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", currDifficulty);
        Tower LightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", currDifficulty);
        Tower HeavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", currDifficulty);
        Tower LightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", currDifficulty);
        Tower HeavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", currDifficulty);
        Tower LightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", currDifficulty);
    }
}
