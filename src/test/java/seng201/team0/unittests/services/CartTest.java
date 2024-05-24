package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Cart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Cart implementation
 * @author Samuel Beattie
 */
public class CartTest {
    /**
     * Empty Constructor for CartServiceTest.
     */
    public CartTest(){}
    /**
     * Cart
     */
    Cart cart;
    /**
     * Sets up each test
     */
    @BeforeEach
    void setupTest(){
        cart = new Cart("TestCart", "Gold", 1.2, 100);
    }
    /**
     * Tests the increase distance travelled function
     */
    @Test
    void increaseDistanceTest(){
        for (int i = 0; i <= 20; i++) {
            cart.increaseDistance();
        }
        assertTrue(cart.getDistanceTravelled() > 0);
    }
    /**
     * Tests the distance reset function
     */
    @Test
    void distanceResetTest(){
        cart.setDistanceTravelled(100.0);
        assertEquals(cart.getDistanceTravelled(), 100);
        cart.increaseDistance();
        assertEquals(cart.isCartSuccess(), false);
        assertEquals(cart.isEndReached(), true);
        cart.resetDistance();
        assertEquals(cart.getDistanceTravelled(), 0);
        assertEquals(cart.isEndReached(), false);
    }
    /**
     * Tests increasing the fill amount, while still not being filled
     */
    @Test
    void increaseFillAmountTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
    }
    /**
     * Tests decreasing the fill amount, while still not being emptied
     */
    @Test
    void decreaseFillAmountTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
        cart.increaseFillAmount(-20);
        assertEquals(cart.getCurrentFillDisplay(), 5);
    }
    /**
     * Tests increasing the fill amount past the capacity
     */
    @Test
    void fullCartTest(){
        cart.increaseFillAmount(1000);
        assertEquals(cart.getCurrentFillDisplay(), cart.getCapacity());
        assertEquals(cart.isFull(),true);
    }
    /**
     * Tests emptying the cart by filling with a negative value
     */
    @Test
    void emptyCartTest(){
        cart.increaseFillAmount(25);
        assertEquals(cart.getCurrentFillDisplay(), 25);
        cart.increaseFillAmount(-30);
        assertEquals(cart.getCurrentFillDisplay(), 0);
        assertEquals(cart.getCurrentFillAmount(), 0.0);
    }
}
