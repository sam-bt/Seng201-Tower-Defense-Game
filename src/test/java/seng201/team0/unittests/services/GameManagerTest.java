package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.GameManager;
import seng201.team0.models.Setup;
import seng201.team0.models.Tower;
import seng201.team0.services.MoneyService;
import seng201.team0.services.TowerGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test GameManager implementation
 * @author Samuel Beattie
 */

public class GameManagerTest {
    /**
     * Empty Constructor for GameManagerTest.
     */
    public GameManagerTest(){}

    /**
     * Game Manager
     */
    GameManager gameManager;
    /**
     * Set up each test
     */
    @BeforeEach
    void setupTest(){
        gameManager = new GameManager();
    }
    /**
     * Tests the set setup method
     */
    @Test
    void setSetupTest(){
        Setup setup = new Setup("Test Name", 5L);
        gameManager.setMoney(new MoneyService());
        gameManager.setSetup(setup);
        assertEquals(gameManager.getName(), "Test Name");
        assertEquals(gameManager.getRounds(), 5L);
        assertEquals(gameManager.getMoneyAmount(),1500);
    }
    /**
     * tests the cheapest towers sum method
     */
    @Test
    void getCheapestTowersSumTest(){
        Tower heavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", 100);
        Tower lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", 100);
        Tower heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", 100);
        Tower lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", 100);
        Tower heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),false, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", 100);
        Tower lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),false, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", 200);
        Tower heavyGem = new Tower(TowerGenerator.heavyTowerHealthGenerator(), false, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(),TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gem", 250);
        Tower lightGem = new Tower(TowerGenerator.lightTowerHealthGenerator(), false, "Gem", TowerGenerator.lightTowerFillAmountGenerator(), TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gem", 300);
        List<Tower> towerList = List.of(heavyCoal, lightCoal, heavyIron, lightIron, heavyGold, lightGold, heavyGem, lightGem);
        assertEquals(gameManager.getCheapestTowersSum(towerList),500.0);
    }
    /**
     * tests the get round one tower list indices method with two towers selected
     */
    @Test
    void getRoundOneTowerListIndicesTwoTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,1,"Light Gold", 800);
        gameManager.setRoundOneSelectedTowerList(selectedTowers);
        assertEquals(gameManager.getRoundOneTowerListIndices(),List.of(0,2));
    }
    /**
     * tests the get round one tower list indices method with no tower selected
     */
    @Test
    void getRoundOneTowerListIndicesNoneTest(){
        Tower[] selectedTowers = new Tower[3];
        gameManager.setRoundOneSelectedTowerList(selectedTowers);
        assertEquals(gameManager.getRoundOneTowerListIndices(),List.of());
    }
    /**
     * tests the get generic round tower list indices method with four towers selected
     */
    @Test
    void getRoundTowerListIndicesFourTest(){
        Tower lightCoal = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        Tower lightGold = new Tower(500,false,"Gold",25,1,"Light Gold", 800);
        Tower heavyIron = new Tower(500,true,"Iron",50,4,"Heavy Iron", 1200);
        Tower lightGem = new Tower(500,false,"Gem",25,1,"Light Gem", 800);
        List<Tower> selectedTowers = new ArrayList<>();
        selectedTowers.add(lightCoal);
        selectedTowers.add(null);
        selectedTowers.add(lightGold);
        selectedTowers.add(heavyIron);
        selectedTowers.add(lightGem);
        gameManager.setGenericRoundTowerList(selectedTowers);
        assertEquals(gameManager.getGenericRoundTowerListIndices(),List.of(0,2,3,4));
    }
    /**
     * tests the get generic round tower list indices method with no towers selected
     */
    @Test
    void getRoundTowerListIndicesNoneTest(){
        List<Tower> selectedTowers = new ArrayList<>();
        selectedTowers.add(null);
        selectedTowers.add(null);
        selectedTowers.add(null);
        selectedTowers.add(null);
        selectedTowers.add(null);
        gameManager.setGenericRoundTowerList(selectedTowers);
        assertEquals(gameManager.getGenericRoundTowerListIndices(),List.of());
    }
}
