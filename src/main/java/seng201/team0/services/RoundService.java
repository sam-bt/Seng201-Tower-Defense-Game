package seng201.team0.services;


import seng201.team0.GameManager;

public class RoundService {
    public static void completeRound(GameManager roundGameManager){
        roundGameManager.incrementPoints();
        roundGameManager.getMoneyService().editMoney(100*roundGameManager.getDifficulty());
        roundGameManager.getDifficultyService().incrementDifficulty();
    }
    public static int trackLengthCalculator(double difficulty){
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

