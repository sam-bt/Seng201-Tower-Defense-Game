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
    public RoundOneInventoryService(double difficulty){
        double currDifficulty = difficulty;
        HeavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", currDifficulty, TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        LightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
        HeavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", currDifficulty,TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        LightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
        HeavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", currDifficulty,TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        LightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
    }
    public List<Tower> getTowerList(){
        return List.of(HeavyCoal,LightCoal,HeavyIron,LightIron,HeavyGold,LightGold);
    }

}
