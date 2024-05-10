package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.GameManager;

public class FinishedScreenController {
    GameManager roundGameManager;
    public FinishedScreenController(GameManager tempRoundGameManager){
        roundGameManager = tempRoundGameManager;
    }

//    @FXML
//    private void onConfirm() {
////            String playerText = playerName.getText();
////            Setup setup = new Setup(playerText,numRoundsValue,difficultyValue);
//        roundGameManager.closeGameScreen();
//    }
}
