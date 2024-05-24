package seng201.team0.services;


import seng201.team0.GameManager;

/**
 * Service class for managing rounds in the game.
 */
public class RoundService {

    /**
     * Completes a round in the game.
     *
     * @param roundGameManager The GameManager object representing the current round's game state.
     */
    public static void completeRound(GameManager roundGameManager) {
        TowerService.breakTowers(roundGameManager.getRoundOneTowerList());
        roundGameManager.incrementPoints();
        roundGameManager.setTrackLengthIndex(0);
        roundGameManager.getMoneyService().editMoney(1000 - (100 * roundGameManager.getDifficulty()));
        roundGameManager.getDifficultyService().incrementDifficulty();
    }

    /**
     * Calculates the track length based on the difficulty level.
     *
     * @param difficulty The difficulty level of the game.
     * @return The track length for the next round.
     */
    public static int trackLengthCalculator(double difficulty) {
        if (difficulty <= 1.0) {
            return 100;
        } else if (difficulty <= 2.0) {
            return 90;
        } else if (difficulty <= 3.0) {
            return 80;
        } else if (difficulty <= 4.0) {
            return 70;
        } else if (difficulty <= 5.0) {
            return 60;
        } else if (difficulty <= 6.0) {
            return 50;
        } else if (difficulty <= 7.0) {
            return 40;
        } else if (difficulty <= 8.0) {
            return 30;
        } else {
            return 20;
        }
    }
}

