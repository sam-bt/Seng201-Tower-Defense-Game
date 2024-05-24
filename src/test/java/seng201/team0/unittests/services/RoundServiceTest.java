package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;
import seng201.team0.services.RoundService;
import seng201.team0.services.TowerGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test RoundService implementation
 * @author Samuel Beattie
 */
public class RoundServiceTest {
    /**
     * Empty Constructor for RoundServiceTest.
     */
    public RoundServiceTest(){}

    /**
     * Test 100m track length calculator implementation
     */
    @Test
    void trackLengthTestOne(){
        assertEquals(RoundService.trackLengthCalculator(-10.0),100);
        assertEquals(RoundService.trackLengthCalculator(0.5),100);
        assertEquals(RoundService.trackLengthCalculator(1.0),100);
    }
    /**
     * Test 90m track length calculator implementation
     */
    @Test
    void trackLengthTestTwo(){
        assertEquals(RoundService.trackLengthCalculator(1.5),90);
        assertEquals(RoundService.trackLengthCalculator(2.0),90);
    }
    /**
     * Test 80m track length calculator implementation
     */
    @Test
    void trackLengthTestFive(){
        assertEquals(RoundService.trackLengthCalculator(2.7),80);
        assertEquals(RoundService.trackLengthCalculator(5.0),80);
    }
    /**
     * Test 70m track length calculator implementation
     */
    @Test
    void trackLengthTestEight(){
        assertEquals(RoundService.trackLengthCalculator(5.5),70);
        assertEquals(RoundService.trackLengthCalculator(8.0),70);
    }
    /**
     * Test 60m track length calculator implementation
     */
    @Test
    void trackLengthTestElse(){
        assertEquals(RoundService.trackLengthCalculator(9.0),60);
        assertEquals(RoundService.trackLengthCalculator(11.0),60);
    }
    /**
     * Test if the round is completed properly
     */
    @Test
    void testCompleteRound(){
        GameManager gameManager = new GameManager();

        Tower heavyCoal = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Coal", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Coal", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightCoal = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Coal", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Coal", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyIron = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Iron", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Iron", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightIron = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Iron", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Iron", TowerGenerator.lightTowerPriceGenerator(1.5));
        Tower heavyGold = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gold", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gold", TowerGenerator.heavyTowerPriceGenerator(1.5));
        Tower lightGold = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gold", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gold", TowerGenerator.lightTowerPriceGenerator(1.5));
        gameManager.setRoundOneTowerList(List.of(heavyCoal,lightCoal,heavyIron,lightIron,heavyGold,lightGold));

        gameManager.startPoints();
        gameManager.setTrackLengthIndex(3);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        gameManager.setDifficulty(new DifficultyService(1.0));
        RoundService.completeRound(gameManager);
        assertEquals(gameManager.getPoints(), 100.0);
        assertEquals(gameManager.getTrackLengthIndex(), 0);
        assertEquals(gameManager.getMoneyAmount(), 2400);
        assertEquals(gameManager.getDifficulty(), 1.4);
    }
}
