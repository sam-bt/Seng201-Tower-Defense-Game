package seng201.team0.unittests.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Cart;
import seng201.team0.models.RoundOne;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;

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
    /**
     * Cart List
     */
    List<Cart> cartList;
    /**
     * Sets up each test
     */
    @BeforeEach
    void setupTest(){
        difficultyService = new DifficultyService(1.0);
        roundOne = new RoundOne(difficultyService,100);
        cartList = List.of(roundOne.getCoalCart(),roundOne.getIronCart(),roundOne.getGoldCart());
    }
    /**
     * Tests if actions are being used as expected
     */
    @Test
    void useActionTest(){
        Tower[] towerList = new Tower[3];
        towerList[0] = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        towerList[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron", 450);
        towerList[2] = new Tower(500,false,"Gold",25,3,"Light Gold", 800);
        Tower selectedTower = towerList[0];
        roundOne.useAction(selectedTower,cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 1);
        assertEquals(cartList.get(0).getCurrentFillDisplay(), 25);
        assertEquals(cartList.get(1).getCurrentFillDisplay(), 0);
        assertEquals(cartList.get(2).getCurrentFillDisplay(), 0);
    }
    /**
     * Tests if the next frame is being executed as expected
     */
    @Test
    void nextFrameTest(){
        Tower[] towerList = new Tower[3];
        towerList[0] = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        towerList[1] = new Tower(250,true,"Iron",25,9,"Heavy Iron", 450);
        towerList[2] = new Tower(500,false,"Gold",25,3,"Light Gold", 800);
        Tower selectedTower = towerList[0];
        roundOne.useAction(selectedTower,cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 1);
        assertEquals(cartList.get(0).getCurrentFillDisplay(), 25);
        assertEquals(cartList.get(1).getCurrentFillDisplay(), 0);
        assertEquals(cartList.get(2).getCurrentFillDisplay(), 0);
        roundOne.nextFrame(cartList,towerList);
        assertEquals(roundOne.getActionsLeft(), 2);
    }
    /**
     * Tests if the round ended is true when all carts have reached the end
     */
    @Test
    void roundEndedTrueOneTest(){
        cartList.get(0).fillCart();
        cartList.get(0).setEndReached();
        cartList.get(1).setEndReached();
        cartList.get(2).setEndReached();
        assertEquals(roundOne.roundEnded(cartList), true);
    }
    /**
     * Tests if the round ended is true when all carts are full
     */
    @Test
    void roundEndedTrueAllTest(){
        cartList.get(0).fillCart();
        cartList.get(1).fillCart();
        cartList.get(2).fillCart();
        assertEquals(roundOne.roundEnded(cartList), true);
    }
    /**
     * Tests if the round ended is false when none of the carts are full nor end reached
     */
    @Test
    void roundEndedFalseTest(){
        assertEquals(roundOne.roundEnded(cartList), false);
    }
    /**
     * Tests if a coal cart is fillable with a coal tower
     */
    @Test
    void isCartFillableTrueTest(){
        Tower selectedTower = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        cartList.get(1).fillCart();
        cartList.get(2).fillCart();
        assertEquals(roundOne.isCartFillable(cartList,selectedTower), true);
    }
    /**
     * Tests if a full cart can be filled
     */
    @Test
    void isCartFillableFullFalseTest(){
        Tower selectedTower = new Tower(100,true,"Coal",25,3,"Light Coal", 300);
        cartList.get(0).fillCart();
        cartList.get(1).fillCart();
        cartList.get(2).fillCart();
        assertEquals(roundOne.isCartFillable(cartList,selectedTower), false);
    }
    /**
     * Tests if a cart of the wrong type can be filled
     */
    @Test
    void isCartFillableEmptyFalseTest(){
        Tower selectedTower = new Tower(100,true,"Gem",25,3,"Light Gem", 300);
        assertEquals(roundOne.isCartFillable(cartList,selectedTower), false);
    }
    /**
     * Tests if round is won with all carts successful
     */
    @Test
    void roundWonTrueTest(){
        cartList.get(0).setCartSuccess();
        cartList.get(1).setCartSuccess();
        cartList.get(2).setCartSuccess();
        assertEquals(roundOne.roundWon(cartList), true);
    }
    /**
     * Tests if round is won with not all carts successful
     */
    @Test
    void roundWonFalseTest(){
        cartList.get(0).setCartSuccess();
        cartList.get(1).setCartSuccess();
        assertEquals(roundOne.roundWon(cartList), false);
    }
}
