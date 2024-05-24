package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.services.DifficultyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test Difficulty implementation
 * @author Samuel Beattie
 */

public class DifficultyServiceTest {
    private DifficultyService testDifficultyService;

    /**
     * Set up a difficulty service before each test
     */
    @BeforeEach
    public void setupTest() {
        testDifficultyService = new DifficultyService(1.0);
    }

    /**
     * Test incrementing the difficulty
     */
    @Test
    void testIncrement() {
        assertEquals(1.0, testDifficultyService.getDifficulty());
        testDifficultyService.incrementDifficulty();
        assertEquals(1.4, testDifficultyService.getDifficulty());
    }
    /**
     * Test incrementing the difficulty 5 times
     */
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
