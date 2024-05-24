package seng201.team0.unittests.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Cart;
import seng201.team0.models.RoundOne;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test RoundOne implementation
 * @author Samuel Beattie
 */
public class RoundOneTest {
    /**
     * Difficulty Service
     */
    DifficultyService difficultyService;
    /**
     * Round One
     */
    RoundOne roundOne;
    @BeforeEach
    void setupTest(){
        difficultyService = new DifficultyService(1.0);
        roundOne = new RoundOne(difficultyService,100);
    }
    @Test
    void useActionTest(){
        Tower[] towerList = new Tower[3];
        towerList[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        towerList[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron",1.5,450);
        towerList[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        Tower selectedTower = towerList[0];
        List<Cart> cartList = List.of(roundOne.getCoalCart(),roundOne.getIronCart(),roundOne.getGoldCart());
        roundOne.useAction(selectedTower,cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 1);
        assertEquals(cartList.get(0).getCurrentFillAmount(), 25.0);
        assertEquals(cartList.get(1).getCurrentFillAmount(), 0.0);
        assertEquals(cartList.get(2).getCurrentFillAmount(), 0.0);
    }
    @Test
    void nextFrameTest(){
        Tower[] towerList = new Tower[3];
        towerList[0] = new Tower(100,true,"Coal",25,3,"Light Coal",1.2,300);
        towerList[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron",1.5,450);
        towerList[2] = new Tower(500,false,"Gold",25,3,"Light Gold",3.8,800);
        Tower selectedTower = towerList[0];
        List<Cart> cartList = List.of(roundOne.getCoalCart(),roundOne.getIronCart(),roundOne.getGoldCart());
        roundOne.useAction(selectedTower,cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 1);
        assertEquals(cartList.get(0).getCurrentFillAmount(), 25.0);
        assertEquals(cartList.get(1).getCurrentFillAmount(), 0.0);
        assertEquals(cartList.get(2).getCurrentFillAmount(), 0.0);
        roundOne.nextFrame(cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 2);
    }
}
