package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class ErrorScreenController {


    GameManager errorGameManager;
    @FXML
    private Button nextRoundButton;
    public ErrorScreenController(GameManager tempErrorGameManager){
        errorGameManager = tempErrorGameManager;
    }

    @FXML
    private void gameOnConfirm() {
        errorGameManager.closeGameScreen();
    }
}