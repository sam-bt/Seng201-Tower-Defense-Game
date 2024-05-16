package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class RoundOneGameScreenController {
    @FXML private Button nextRoundButton;
    GameManager roundOneGameScreenManager;

    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.closeGameScreen();
    }
}
