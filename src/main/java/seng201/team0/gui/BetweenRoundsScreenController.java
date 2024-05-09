package seng201.team0.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import seng201.team0.GameManager;
import seng201.team0.models.Setup;

/**
 *
 * This class is the controller for the between rounds screen
 *
 */

public class BetweenRoundsScreenController {
    @FXML private Label betweenRoundsTitleLabel;

//    @FXML private Label currTowerType;
//    @FXML private Label currTowerXP;
//    @FXML private Button nextRoundButton;
//    @FXML private Button selectedTowerSellButton;
//    @FXML private Button selectedTowerUpgradeButton;
//    @FXML private Button towerButton1;
//    @FXML private Button towerButton2;
//    @FXML private Button towerButton3;

    private GameManager setupGameManager;

        /**
         *
         * Sole constructor that sets the GameManager instance
         *
         */

        public BetweenRoundsScreenController(GameManager tempSetupGameManager){
            setupGameManager = tempSetupGameManager;
        }

    /**
     *
     * Initializer method that sets the Title Label
     *
     */


    public void initialize() { // TODO fix this somehow, currently not being called, however setupscreencontroller one is
            betweenRoundsTitleLabel.setText("Weclome "+setupGameManager.getName()+", Select your Setup for round "+setupGameManager.getCurrRound()+" of "+setupGameManager.getRounds()+"!");
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
            setupGameManager.incrementRound();
            setupGameManager.closeSetupScreen();
        }
}
