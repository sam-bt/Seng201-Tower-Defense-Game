package seng201.team0.unittests.services;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Tower;
import seng201.team0.services.TowerService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Test TowerService implementation
 * @author Samuel Beattie
 */

public class TowerServiceTest {

    /**
     * Test if all towers are selected with a towerlist that should return true
     */
    @Test
    void areAllTowersSelectedAllTrueTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertTrue(TowerService.areAllTowersSelected(selectedTowers));
    }
    /**
     * Test if all towers are selected with an empty towerlist
     */
    @Test
    void areAllTowersSelectedAllFalseTest(){
        Tower[] selectedTowers = new Tower[3];
        assertFalse(TowerService.areAllTowersSelected(selectedTowers));
    }
    /**
     * Test if all towers are selected with a partially empty towerlist
     */
    @Test
    void areAllTowersSelectedSomeFalseTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,1,"Light Gold",3.8,800);
        assertFalse(TowerService.areAllTowersSelected(selectedTowers));
    }
    /**
     * Test if the tower is already selected, with a tower that is already selected
     */
    @Test
    void isTowerAlreadySelectedOneTrueTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,3,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    /**
     * Test if the tower is already selected, with all towers already selected
     */
    @Test
    void isTowerAlreadySelectedAllTrueTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,3,"Light Coal",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Coal",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    /**
     * Test if the tower is already selected, with an empty tower slot
     */
    @Test
    void isTowerAlreadySelectedAllTrueNullTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Coal",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    /**
     * Test if the tower is already selected, with a tower that is not selected
     */
    @Test
    void isTowerAlreadySelectedFalseTest(){
        Tower queryTower = new Tower(99,true,"Coal",25,5,"Heavy Coal",1.2,760);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,1,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    /**
     * Test if the tower is already selected, with an empty tower slot
     */
    @Test
    void isTowerAlreadySelectedFalseNullTest(){
        Tower queryTower = new Tower(99,true,"Coal",25,5,"Heavy Coal",1.2,760);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    /**
     * Test if all round one tower types are selected when they are
     */
    @Test
    void areAllRoundOneTowersTypesSelectedTrueTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,1,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertTrue(TowerService.areAllRoundOneTowersTypesSelected(selectedTowers));
    }
    /**
     * Test if all round one tower types are selected when they aren't
     */
    @Test
    void areAllRoundOneTowersTypesSelectedFalseTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Gold",25,1,"Heavy Gold",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.areAllRoundOneTowersTypesSelected(selectedTowers));
    }
    /**
     * Test if all round one tower types are selected when a slot is empty
     */
    @Test
    void areAllRoundOneTowersTypesSelectedFalseNullTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.areAllRoundOneTowersTypesSelected(selectedTowers));
    }
}
