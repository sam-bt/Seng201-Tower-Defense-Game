package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.services.DifficultyService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyServiceTest {
    private DifficultyService testDifficultyService;

    /**
     * Setup before each test, we create two objects, one an actual
     * instance of our CounterService class, and another a mocked version
     * that has overridden methods.
     */
    @BeforeEach
    public void setupTest() {
        testDifficultyService = new DifficultyService(1.0);
    }

    /**
     * Test incrementing the counter by one, normal JUnit test
     */
    @Test
    void testIncrement() {
        assertEquals(1.0, testDifficultyService.getDifficulty());
        testDifficultyService.incrementDifficulty();
        assertEquals(1.4, testDifficultyService.getDifficulty());
    }
    @Test
    void testLotsOfIncrement() {
        assertEquals(1.0, testDifficultyService.getDifficulty());
        testDifficultyService.incrementDifficulty();
        testDifficultyService.incrementDifficulty();
        testDifficultyService.incrementDifficulty();
        testDifficultyService.incrementDifficulty();
        testDifficultyService.incrementDifficulty();
        assertEquals(3.0, testDifficultyService.getDifficulty());
    }
}
