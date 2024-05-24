package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Tower;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Tower implementation
 * @author Samuel Beattie
 */

public class TowerTest {
    /**
     * The tower to test
     */
    Tower testTower;
    /**
     * Set up a tower before each test
     */
    @BeforeEach void setupTest(){
        testTower = new Tower(100,false,"Coal",30,5,"Light Coal", 500);
    }
    /**
     * Test tower break implementation
     */
    @Test void breakTest(){
        assertEquals(testTower.getBroken(), false);
        testTower.breakTower();
        assertEquals(testTower.getBroken(), true);
    }
    /**
     * Test buying a tower
     */
    @Test void buyTest(){
        assertEquals(testTower.getOwned(), false);
        testTower.buy();
        assertEquals(testTower.getOwned(), true);
    }
    /**
     * Test selling a tower
     */
    @Test void sellTest(){
        testTower.buy();
        assertEquals(testTower.getOwned(), true);
        testTower.sell();
        assertEquals(testTower.getOwned(), false);
    }
    /**
     * Test upgrading a tower
     */
    @Test void upgradeTest(){
        assertEquals(testTower.getLevel(), 1);
        assertEquals(testTower.getMaxHealth(), 100);
        assertEquals(testTower.getFillAmount(), 30);
        testTower.useUpgrade();
        assertEquals(testTower.getLevel(), 2);
        assertEquals(testTower.getMaxHealth(), 105);
        assertEquals(testTower.getFillAmount(), 32);
    }
    /**
     * Test reviving a tower
     */
    @Test void reviveTest(){
        testTower.breakTower();
        assertEquals(testTower.getBroken(), true);
        testTower.useRevive();
        assertEquals(testTower.getBroken(), false);
        assertEquals(testTower.getBreakChance(), 0);
        assertEquals(testTower.getHealth(), 100);
    }
    /**
     * Test reviving a tower with 0 health
     */
    @Test void reviveDeadTest(){
        testTower.breakTower();
        testTower.setHealth(0);
        assertEquals(testTower.getBroken(), true);
        assertEquals(testTower.getHealth(), 0);
        testTower.useRevive();
        assertEquals(testTower.getBroken(), false);
        assertEquals(testTower.getBreakChance(), 0);
        assertEquals(testTower.getHealth(), 5);
    }
    /**
     * Test healing a tower
     */
    @Test void healTest(){
        testTower.setHealth(0);
        assertEquals(testTower.getHealth(), 0);
        testTower.useHeal();
        assertEquals(testTower.getHealth(), 5);
    }
    /**
     * Test buying a tower that is already on max health
     */
    @Test void healMaxHealthTest(){
        testTower.setHealth(99);
        assertEquals(testTower.getHealth(), 99);
        testTower.useHeal();
        assertEquals(testTower.getHealth(), 100);
    }
    /**
     * Test using a tower
     */
    @Test void useTowerTest(){
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.getBreakChance(), 0);
        assertEquals(testTower.getHealth(), 100);
        assertEquals(testTower.getBroken(),false);
        assertEquals(testTower.isUsable(),true);
        testTower.use();
        assertEquals(testTower.getActionsUntilUsable(), 5);
        assertTrue(testTower.getBreakChance()>=0 && testTower.getBreakChance() <= 3);
        assertTrue(testTower.getHealth()>=91);
        assertEquals(testTower.isUsable(),false);
    }
    /**
     * Test using a tower when it is going to break after use
     */
    @Test void useTowerBreakTest(){
        testTower.setHealth(-1);
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.getBreakChance(), 0);
        assertEquals(testTower.getHealth(), -1);
        assertEquals(testTower.getBroken(),false);
        assertEquals(testTower.isUsable(),true);
        testTower.use();
        assertEquals(testTower.getActionsUntilUsable(), 5);
        assertTrue(testTower.getBreakChance()>=0 && testTower.getBreakChance() <= 3);
        assertEquals(testTower.getHealth(),0);
        assertEquals(testTower.isUsable(),false);
        assertEquals(testTower.getBroken(),true);
    }
    /**
     * Test using one action
     */
    @Test void actionUsedOneTest(){
        testTower.use();
        assertEquals(testTower.getActionsUntilUsable(), 5);
        assertEquals(testTower.isUsable(), false);
        testTower.actionUsed();
        assertEquals(testTower.getActionsUntilUsable(), 4);
        assertEquals(testTower.isUsable(), false);
    }
    /**
     * Test using enough actions to reset the towers
     */
    @Test void actionUsedNotOneTest(){
        testTower.use();
        assertEquals(testTower.getActionsUntilUsable(), 5);
        assertEquals(testTower.isUsable(), false);
        testTower.actionUsed();
        testTower.actionUsed();
        testTower.actionUsed();
        testTower.actionUsed();
        testTower.actionUsed();
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.isUsable(), true);
    }
    /**
     * Test using an action when the tower is already usable
     */
    @Test void actionUsedAlreadyUsableTest(){
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.isUsable(), true);
        testTower.actionUsed();
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.isUsable(), true);
    }
    /**
     * Test towers are set to usable
     */
    @Test void setUsableTest(){
        testTower.use();
        assertEquals(testTower.getActionsUntilUsable(), 5);
        assertEquals(testTower.isUsable(), false);
        testTower.setUsable();
        assertEquals(testTower.getActionsUntilUsable(), 0);
        assertEquals(testTower.isUsable(), true);
    }
}
