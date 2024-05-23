package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

public class LosingScreenController {
    @FXML
    private Label roundsCompletedLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label pointsLabel;
    GameManager losingScreenGameManager;
    public LosingScreenController(GameManager tempLosingScreenGameManager) {
        losingScreenGameManager = tempLosingScreenGameManager;

    }
    public void initialize() {
        roundsCompletedLabel.setText("You completed "+(losingScreenGameManager.getCurrRound()-2)+"/"+losingScreenGameManager.getRounds()+" Rounds!");
        pointsLabel.setText("You had "+losingScreenGameManager.getPoints()+" Points!");
        difficultyLabel.setText("You lost on difficulty "+losingScreenGameManager.getDifficulty()+"!");
    }
    public void onQuit(){
        System.exit(0);
    }

}
