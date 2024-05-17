package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;

import java.util.List;

public class RoundOneInventoryService {
    Tower HeavyCoal;
    Tower LightCoal;
    Tower HeavyIron;
    Tower LightIron;
    Tower HeavyGold;
    Tower LightGold;
    public RoundOneInventoryService(GameManager roundOneServiceGameManager){
        double currDifficulty = roundOneServiceGameManager.getDifficulty();
        HeavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", currDifficulty);
        LightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", currDifficulty);
        HeavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", currDifficulty);
        LightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", currDifficulty);
        HeavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", currDifficulty);
        LightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", currDifficulty);
    }
    public List<Tower> getTowerList(){
        return List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold);
    }

}
