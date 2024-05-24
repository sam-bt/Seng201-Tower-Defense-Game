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
    void trackLengthTestThree(){
        assertEquals(RoundService.trackLengthCalculator(2.7),80);
        assertEquals(RoundService.trackLengthCalculator(3.0),80);
    }
    /**
     * Test 70m track length calculator implementation
     */
    @Test
    void trackLengthTestFour(){
        assertEquals(RoundService.trackLengthCalculator(3.1),70);
        assertEquals(RoundService.trackLengthCalculator(4),70);
    }
    /**
     * Test 60m track length calculator implementation
     */
    @Test
    void trackLengthTestOFive(){
        assertEquals(RoundService.trackLengthCalculator(4.3),60);
        assertEquals(RoundService.trackLengthCalculator(5),60);
    }
    /**
     * Test 50m track length calculator implementation
     */
    @Test
    void trackLengthTestSix(){
        assertEquals(RoundService.trackLengthCalculator(5.4),50);
        assertEquals(RoundService.trackLengthCalculator(6.0),50);
    }
    /**
     * Test 40m track length calculator implementation
     */
    @Test
    void trackLengthTestSeven(){
        assertEquals(RoundService.trackLengthCalculator(6.1),40);
        assertEquals(RoundService.trackLengthCalculator(7.0),40);
    }
    /**
     * Test 30m track length calculator implementation
     */
    @Test
    void trackLengthTestEight(){
        assertEquals(RoundService.trackLengthCalculator(7.9),30);
        assertEquals(RoundService.trackLengthCalculator(8.0),30);
    }
    /**
     * Test 20m track length calculator implementation
     */
    @Test
    void trackLengthTestNine(){
        assertEquals(RoundService.trackLengthCalculator(9.0),20);
        assertEquals(RoundService.trackLengthCalculator(11.0),20);
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
        assertEquals(gameManager.getMoneyAmount(), 1900.0);
        assertEquals(gameManager.getDifficulty(), 1.4);
    }
}
