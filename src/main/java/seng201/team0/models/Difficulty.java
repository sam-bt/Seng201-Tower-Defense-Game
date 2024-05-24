package seng201.team0.models;

/**
 * Difficulty model class
 */
public class Difficulty {

    /**
     * Difficulty number
     */
    private double difficulty;

    /**
     * Constructor
     *
     * @param initialDifficulty the initial difficulty of the Difficulty instance
     */
    public Difficulty(double initialDifficulty) {
        this.difficulty = initialDifficulty;
    }

    /**
     * Get current counter count
     *
     * @return Current count
     */
    public double getDifficulty() {
        return difficulty;
    }

    /**
     * Set current counter count
     *
     * @param difficultyIncrease Value of counter
     */
    public void increaseDifficulty(double difficultyIncrease) {
        difficulty += difficultyIncrease;
    }
}
