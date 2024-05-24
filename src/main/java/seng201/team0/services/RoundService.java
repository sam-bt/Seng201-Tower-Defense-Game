package seng201.team0.services;


import seng201.team0.GameManager;

/**
 * Service class for managing rounds in the game.
 */
public class RoundService {
    /**
     * Empty Constructor for RoundService.
     */
    public RoundService() { }

    /**
     * Completes a round in the game.
     *
     * @param roundGameManager The GameManager object representing the current round's game state.
     */
    public static void completeRound(final GameManager roundGameManager) {
        TowerService.breakTowers(roundGameManager.getRoundOneTowerList());
        roundGameManager.incrementPoints();
        roundGameManager.setTrackLengthIndex(0);
        roundGameManager.getMoneyService().editMoney(1500 - (100 * roundGameManager.getDifficulty()));
        roundGameManager.getDifficultyService().incrementDifficulty();
    }

    /**
     * Calculates the track length based on the difficulty level.
     *
     * @param difficulty The difficulty level of the game.
     * @return The track length for the next round.
     */
    public static int trackLengthCalculator(final double difficulty) {
        if (difficulty <= 1.0) {
            return 100;
        } else if (difficulty <= 2.0) {
            return 90;
        } else if (difficulty <= 5.0) {
            return 80;
        } else if (difficulty <= 8.0) {
            return 70;
        } else {
            return 60;
        }
    }
}

