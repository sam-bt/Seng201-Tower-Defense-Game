package seng201.team0.services;

import seng201.team0.models.Tower;

import java.util.List;

public class RoundOneInventoryService {
    Tower heavycoal;
    Tower lightCoal;
    Tower heavyIron;
    Tower lightIron;
    Tower heavyGold;
    Tower lightGold;
    public RoundOneInventoryService(double difficulty){
        double currDifficulty = difficulty;
        heavycoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", currDifficulty, TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
        heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", currDifficulty,TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
        heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", currDifficulty,TowerGenerator.heavyTowerPriceGenerator(currDifficulty));
        lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", currDifficulty,TowerGenerator.lightTowerPriceGenerator(currDifficulty));
    }
    public List<Tower> getTowerList(){
        return List.of(heavycoal, lightCoal, heavyIron, lightIron, heavyGold, lightGold);
    }

}
