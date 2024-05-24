package seng201.team0.unittests.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.services.MoneyService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Money implementation
 * @author Samuel Beattie
 */
class MoneyServiceTest {
    private MoneyService testMoneyService;

    /**
     * Setup money service before each test
     */
    @BeforeEach
    public void setupTest() {
        testMoneyService = new MoneyService();
    }

    /**
     * Test increasing the money
     */
    @Test
    void testIncrease() {
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
    }
    /**
     * Test decreasing the money
     */
    @Test
    void testDecrease(){
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(-50.00);
        assertEquals(50.00, testMoneyService.getCurrentAmount());
    }
    /**
     * Test money cannot go below zero
     */
    @Test void
    testBelowZero(){
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(-150.00);
        assertEquals(0.0, testMoneyService.getCurrentAmount());
    }
}
