package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.RandomEvent;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Test RandomEvent implementation
 * @author Samuel Beattie
 */
public class RandomEventTest {
    RandomEvent randomEvent;
    @BeforeEach
    void setupTest(){
        randomEvent = new RandomEvent();
    }
    /**
     * Generate event in either good or neutral range
     */
    @Test
    void generateGoodOrNeutralEvent() {
        randomEvent.generateRandomEvent(0.0);
        assertTrue(randomEvent.getEventName() == "Cart Reset" || randomEvent.getEventName() == "Reset Towers" || randomEvent.getEventName() == "Fill Cart" || randomEvent.getEventName() == "Nothing");
    }
    /**
     * Generate event in either good (first case), neutral or bad range
     */
    @Test
    void generateOneGoodNeutralBadEvent() {
        randomEvent.generateRandomEvent(10.0);
        assertTrue(randomEvent.getEventName() == "Cart Reset" || randomEvent.getEventName() == "Nothing" || randomEvent.getEventName() == "Steal Resources" || randomEvent.getEventName() == "Disable Tower" || randomEvent.getEventName() == "Actions Reset");
    }
    /**
     * Test range of round one index is as expected
     */
    @Test
    void generateRoundOneIndexTest(){
        randomEvent.generateRandomEvent(0);
        int generated = randomEvent.generateRoundOneIndex();
        assertTrue(generated >= 0 && generated <= 2);
    }
    /**
     * Test range of round index is as expected
     */
    @Test
    void generateRoundIndexTest(){
        randomEvent.generateRandomEvent(10.0);
        int generated = randomEvent.generateRoundIndex();
        assertTrue(generated >= 0 && generated <= 4);
    }
}
