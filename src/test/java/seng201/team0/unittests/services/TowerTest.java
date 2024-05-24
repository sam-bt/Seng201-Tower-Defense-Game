package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Tower;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Tower implementation
 * @author Samuel Beattie
 */

public class TowerTest {
    Tower testTower;

    @BeforeEach void setupTest(){
        testTower = new Tower(100,false,"Coal",30,5,"Light Coal",1.5,500);
    }
    @Test void breakTest(){
        assertEquals(testTower.getBroken(), false);
        testTower.breakTower();
        assertEquals(testTower.getBroken(), true);
    }
    @Test void buyTest(){
        assertEquals(testTower.getOwned(), false);
        testTower.buy();
        assertEquals(testTower.getBroken(), true);
    }
    @Test void sellTest(){
        testTower.buy();
        assertEquals(testTower.getOwned(), true);
        testTower.sell();
        assertEquals(testTower.getBroken(), false);
    }
    @Test void ugradeTest(){
        assertEquals(testTower.getLevel(), 1);
        assertEquals(testTower.getMaxHealth(), 100);
        assertEquals(testTower.getFillAmount(), 30);
        testTower.useUpgrade();
        assertEquals(testTower.getLevel(), 2);
        assertEquals(testTower.getMaxHealth(), 105);
        assertEquals(testTower.getFillAmount(), 32);
    }
}
