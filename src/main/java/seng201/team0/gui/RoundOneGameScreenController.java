package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

public class RoundOneGameScreenController {
    @FXML private Button nextRoundButton;
    @FXML private ProgressBar cartOneProgressBar;
    GameManager roundOneGameScreenManager;

    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    public void initialize() {
        cartOneProgressBar. setStyle("-fx-accent: green");
        cartOneProgressBar.setProgress(1.1);
    }
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.closeGameScreen();
    }
}
