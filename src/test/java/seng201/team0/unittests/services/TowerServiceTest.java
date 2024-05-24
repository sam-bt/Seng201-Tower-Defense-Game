package seng201.team0.unittests.services;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Tower;
import seng201.team0.services.TowerService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TowerServiceTest {
    @Test
    void areAllTowersSelectedAllTrueTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertTrue(TowerService.areAllTowersSelected(selectedTowers));
    }
    @Test
    void areAllTowersSelectedAllFalseTest(){
        Tower[] selectedTowers = new Tower[3];
        assertFalse(TowerService.areAllTowersSelected(selectedTowers));
    }
    @Test
    void areAllTowersSelectedSomeFalseTest(){
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,1,"Light Gold",3.8,800);
        assertFalse(TowerService.areAllTowersSelected(selectedTowers));
    }
    @Test
    void isTowerAlreadySelectedOneTrueTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,3,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    @Test
    void isTowerAlreadySelectedAllTrueTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,3,"Light Coal",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Coal",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    @Test
    void isTowerAlreadySelectedAllTrueNullTest(){
        Tower queryTower = new Tower(10,false,"Coal",25,3,"Light Coal",1.2,900);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,2,"Light Coal",1.2,300);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Coal",3.8,800);
        assertTrue(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    @Test
    void isTowerAlreadySelectedFalseTest(){
        Tower queryTower = new Tower(99,true,"Coal",25,5,"Heavy Coal",1.2,760);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        selectedTowers[1] = new Tower(250,true,"Iron",25,1,"Heavy Iron",1.5,450);
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }
    @Test
    void isTowerAlreadySelectedFalseNullTest(){
        Tower queryTower = new Tower(99,true,"Coal",25,5,"Heavy Coal",1.2,760);
        Tower[] selectedTowers = new Tower[3];
        selectedTowers[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        assertFalse(TowerService.isTowerAlreadySelected(selectedTowers, queryTower));
    }

}
