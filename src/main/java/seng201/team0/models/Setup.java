package seng201.team0.models;

/**
 * This class contains the information for the information input in the menu screen
 */
public class Setup {
    private String playerName;
    private Long numRounds;

    /**
     * Constructor method that initialises the input variables
     */
    public Setup(String playerName, Long numRounds) {
        this.playerName = playerName;
        this.numRounds = numRounds;
    }

    public String getName() {
        return playerName;
    }

    public Long getNumRounds() {
        return numRounds;
    }
}
