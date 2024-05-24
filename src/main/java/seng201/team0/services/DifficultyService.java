package seng201.team0.services;

import seng201.team0.models.Difficulty;

/**
 * Class to handle game difficulty related processes.
 */
public class DifficultyService {
    private final Difficulty difficulty;

    /**
     * Constructor.
     *
     * @param initialDifficulty the initial difficulty for the DifficultyService.
     */
    public DifficultyService(final double initialDifficulty) {
        difficulty = new Difficulty(initialDifficulty);
    }

    /**
     * Increment the counter by one.
     */
    public void incrementDifficulty() {
        difficulty.increaseDifficulty(.4);
    }

    /**
     * Get the current count of the counter.
     *
     * @return Current count
     */
    public double getDifficulty() {
        return Math.round(difficulty.getDifficulty() * 10) / 10.0;
    }
}
