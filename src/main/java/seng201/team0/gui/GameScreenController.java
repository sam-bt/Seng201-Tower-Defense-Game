package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.GameManager;

public class GameScreenController {
    GameManager roundGameManager;
    public GameScreenController(GameManager tempRoundGameManager){
        roundGameManager = tempRoundGameManager;
    }
    public void initialize() {}

    @FXML
    private void onConfirm() {
//            String playerText = playerName.getText();
//            Setup setup = new Setup(playerText,numRoundsValue,difficultyValue);
        roundGameManager.closeGameScreen();
    }
}
