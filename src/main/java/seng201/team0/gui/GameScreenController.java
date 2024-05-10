package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class GameScreenController {
    GameManager roundGameManager;
    @FXML private Button nextRoundButton;
    public GameScreenController(GameManager tempRoundGameManager){
        roundGameManager = tempRoundGameManager;
    }

    @FXML
    private void gameOnConfirm() {
//            String playerText = playerName.getText();
//            Setup setup = new Setup(playerText,numRoundsValue,difficultyValue);
        roundGameManager.closeGameScreen();
    }
}
