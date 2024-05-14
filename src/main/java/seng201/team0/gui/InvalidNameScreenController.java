package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class InvalidNameScreenController {

    private Button returnToMainMenuButton;

    GameManager invalidNameGameManager;
    @FXML
    private Button nextRoundButton;
    public InvalidNameScreenController(GameManager tempInvalidNameGameManager){
        invalidNameGameManager = tempInvalidNameGameManager;
    }

    @FXML
    private void invalidNameOnConfirm() {
        invalidNameGameManager.closeInvalidNameScreen();
    }
}