package seng201.team0.models;

/**
 *
 * This class contains the information for the information input in the menu screen
 *
 */
public class Setup {
    private String playerName;
    private Long numRounds;
    private Long difficulty;
    /**
     *
     * Constructor method that initialises the input variables
     *
     */
    public Setup(String playerName, Long numRounds, Long difficulty) {
        this.playerName = playerName;
        this.numRounds = numRounds;
        this.difficulty = difficulty;
    }
    public String getName() {
        return playerName;
    }
    public Long getNumRounds() {
        return numRounds;
    }
    public Long getDifficulty() {
        return difficulty;
    }
}
