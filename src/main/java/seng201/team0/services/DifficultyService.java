package seng201.team0.services;

import seng201.team0.models.Difficulty;
import seng201.team0.models.Money;

public class DifficultyService {
    private final Difficulty difficulty;

    /**
     * Constructor
     */
    public DifficultyService(double initialDifficulty) {
        difficulty = new Difficulty(initialDifficulty);
    }

    /**
     * Increment our counter by one
     */
    public void incrementDifficulty() {
        difficulty.increaseDifficulty(.2);
    }

    /**
     * Get the current count of the counter
     * @return Current count
     */
    public double getDifficulty() {
        return difficulty.getDifficulty();
    }
}
