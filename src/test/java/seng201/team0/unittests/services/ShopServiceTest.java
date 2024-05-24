package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.services.ShopService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test ShopService implementation
 * @author Samuel Beattie
 */
public class ShopServiceTest {
    /**
     * Test heal price correct
     */
    @Test void healPriceTest(){
        assertEquals(ShopService.getItemCost("heal"), 50);
    }
    /**
     * Test revive price correct
     */
    @Test void revivePriceTest(){
        assertEquals(ShopService.getItemCost("revive"), 500);
    }
    /**
     * Test upgrade price correct
     */
    @Test void upgradePriceTest(){
        assertEquals(ShopService.getItemCost("upgrade"), 150);
    }
    /**
     * Test default price correct
     */
    @Test void defaultPriceTest(){
        assertEquals(ShopService.getItemCost(""), 0);
    }
    /**
     * Test heal sell price correct
     */
    @Test void healSellTest(){
        assertEquals(ShopService.getItemSellValue("heal"), 50);
    }
    /**
     * Test revive sell price correct
     */
    @Test void reviveSellTest(){
        assertEquals(ShopService.getItemCost("revive"), 500);
    }
    /**
     * Test upgrade sell price correct
     */
    @Test void ugradeSellTest(){
        assertEquals(ShopService.getItemCost("upgrade"), 150);
    }
    /**
     * Test default sell price correct
     */
    @Test void defaultSellTest(){
        assertEquals(ShopService.getItemCost(""), 0);
    }
}
