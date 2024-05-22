package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

public class LosingScreenController {
    @FXML
    private Label statsLabel;
    GameManager losingScreenGameManager;
    public LosingScreenController(GameManager tempLosingScreenGameManager) {
        losingScreenGameManager = tempLosingScreenGameManager;
    }
    public void initialize() {
        statsLabel.setText("LOOOOOOOOOOSEEEEEERRRR");
    }
    public void onQuit(){
        System.exit(0);
    }

}
