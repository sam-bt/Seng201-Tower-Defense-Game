package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seng201.team0.GameManager;

public class WinningScreenController {
    GameManager winningScreenGameManager;
    @FXML
    private Label roundsCompletedLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label moneyLabel;
    public WinningScreenController(GameManager tempWinningScreenGameManager){
        winningScreenGameManager = tempWinningScreenGameManager;
    }
    public void initialize() {
        roundsCompletedLabel.setText("You completed "+(winningScreenGameManager.getCurrRound()-2)+"/"+winningScreenGameManager.getRounds()+" Rounds!");
        moneyLabel.setText("You won with "+winningScreenGameManager.getMoneyAmount()+"$ left!");
        pointsLabel.setText("You had "+winningScreenGameManager.getPoints()+" Points!");
        difficultyLabel.setText("You won on difficulty "+winningScreenGameManager.getDifficulty()+"!");
    }
    public void onQuit(){
        System.exit(0);
    }
}
