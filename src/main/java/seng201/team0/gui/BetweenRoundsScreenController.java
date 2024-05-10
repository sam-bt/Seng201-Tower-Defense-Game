package seng201.team0.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import seng201.team0.GameManager;
import seng201.team0.models.Setup;

import java.text.DecimalFormat;

/**
 *
 * This class is the controller for the between rounds screen
 *
 */

public class BetweenRoundsScreenController {
    public final DecimalFormat decimalFormat  = new DecimalFormat("0.00");

    @FXML private Label betweenRoundsTitleLabel;
    @FXML private Label betweenRoundMoneyLabel;
    @FXML private Label betweenRoundDifficultyLabel;
    @FXML private Button startRoundButton;
    @FXML private Label pointsLabel;
//    @FXML private Label currTowerType;
//    @FXML private Label currTowerXP;
//    @FXML private Button nextRoundButton;
//    @FXML private Button selectedTowerSellButton;
//    @FXML private Button selectedTowerUpgradeButton;
//    @FXML private Button towerButton1;
//    @FXML private Button towerButton2;
//    @FXML private Button towerButton3;

    private GameManager roundGameManager;

        /**
         *
         * Sole constructor that sets the GameManager instance
         *
         */

        public BetweenRoundsScreenController(GameManager tempRoundGameManager){
            roundGameManager = tempRoundGameManager;
        }

    /**
     *
     * Initializer method that sets the Title Label
     *
     */


    public void initialize() {
            betweenRoundsTitleLabel.setText("Weclome "+roundGameManager.getName()+", Select your Setup for round "+roundGameManager.getCurrRound()+" of "+roundGameManager.getRounds()+"!");
            betweenRoundMoneyLabel.setText("Current Money: "+roundGameManager.getMoney());
            betweenRoundDifficultyLabel.setText("Current Difficulty: "+decimalFormat.format(roundGameManager.getDifficulty()));
            startRoundButton.setText("Start Round "+roundGameManager.getCurrRound()+"!");
            pointsLabel.setText("Current Points: "+decimalFormat.format(roundGameManager.getPoints()));
        }

        /**
         *
         * Method that TODO
         *
         */

        @FXML
        private void onConfirm() {
//            String playerText = playerName.getText();
//            Setup setup = new Setup(playerText,numRoundsValue,difficultyValue);
            roundGameManager.incrementRound();
            roundGameManager.closeBetweenRoundScreen();
        }
}
