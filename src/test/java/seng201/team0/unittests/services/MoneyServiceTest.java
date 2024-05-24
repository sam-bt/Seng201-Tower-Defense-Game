package seng201.team0.unittests.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.services.MoneyService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Counter implementation
 * @author seng201 teaching team
 */
class MoneyServiceTest {
    private MoneyService testMoneyService;

    /**
     * Setup before each test, we create two objects, one an actual
     * instance of our CounterService class, and another a mocked version
     * that has overridden methods.
     */
    @BeforeEach
    public void setupTest() {
        testMoneyService = new MoneyService();
    }

    /**
     * Test incrementing the counter by one, normal JUnit test
     */
    @Test
    void testIncrease() {
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
    }
    @Test
    void testDecrease(){
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(-50.00);
        assertEquals(50.00, testMoneyService.getCurrentAmount());
    }
    @Test void
    testBelowZero(){
        assertEquals(0, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(100.00);
        assertEquals(100.00, testMoneyService.getCurrentAmount());
        testMoneyService.editMoney(-150.00);
        assertEquals(0.0, testMoneyService.getCurrentAmount());
    }
}
