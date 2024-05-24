package seng201.team0.models;

/**
 * This class contains the information for the information input in the menu screen.
 */
public class Setup {
    /**
     * Players name.
     */
    private final String playerName;
    /**
     * Number of rounds in the game
     */
    private final Long numRounds;

    /**
     * Constructor method that initialises the input variables.
     */
    public Setup(String playerName, Long numRounds) {
        this.playerName = playerName;
        this.numRounds = numRounds;
    }

    /**
     * Returns the players name.
     * @return the players name.
     */
    public String getName() {
        return playerName;
    }

    /**
     * Returns the number of rounds left.
     * @return number of rounds left.
     */
    public Long getNumRounds() {
        return numRounds;
    }
}
