package seng201.team0.services;


import seng201.team0.GameManager;

public class RoundService {
    public static void completeRound(GameManager roundGameManager){
        roundGameManager.incrementPoints();
        roundGameManager.getMoneyService().editMoney(100*roundGameManager.getDifficulty());
        roundGameManager.getDifficultyService().incrementDifficulty();
    }
}
