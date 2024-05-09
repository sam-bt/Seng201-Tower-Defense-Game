package seng201.team0.models;

public class Difficulty {
    private double difficulty;

    /**
     * Constructor
     */
    public Difficulty(double initialDifficulty) {
        this.difficulty = initialDifficulty;
    }

    /**
     * Get current counter count
     * @return Current count
     */
    public double getDifficulty() {
        return difficulty;
    }

    /**
     * Set current counter count
     * @param difficultyIncrease Value of counter
     */
    public void increaseDifficulty(double difficultyIncrease) {
        difficulty += difficultyIncrease;
    }
}
