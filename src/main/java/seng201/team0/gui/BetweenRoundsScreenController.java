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
    public final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @FXML
    private Label betweenRoundsTitleLabel;
    @FXML
    private Label betweenRoundMoneyLabel;
    @FXML
    private Label betweenRoundDifficultyLabel;
    @FXML
    private Button startRoundButton;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label roundsLeftLabel;
    @FXML
    private Label cantAccessShopLabel;
    @FXML
    private Button goToShopButton;
    @FXML
    private Button goToInventoryButton;

    private GameManager roundGameManager;

    /**
     * Sole constructor that sets the GameManager instance
     */

    public BetweenRoundsScreenController(GameManager tempRoundGameManager) {
        roundGameManager = tempRoundGameManager;
    }

    /**
     * Initializer method that sets the Title Label
     */


    public void initialize() {
        betweenRoundsTitleLabel.setText("Weclome " + roundGameManager.getName() + ", Here are your Stats for Round " + roundGameManager.getCurrRound() + " of " + roundGameManager.getRounds() + "!");
        roundsLeftLabel.setText("Rounds Left: " + (roundGameManager.getRounds() - roundGameManager.getCurrRound() + 1));
        betweenRoundMoneyLabel.setText("Current Money: " + roundGameManager.getMoney());
        betweenRoundDifficultyLabel.setText("Current Difficulty: " + decimalFormat.format(roundGameManager.getDifficulty()));
        startRoundButton.setText("Start Round " + roundGameManager.getCurrRound() + "!");
        pointsLabel.setText("Current Points: " + decimalFormat.format(roundGameManager.getPoints()));
    }

    /**
     * Method that TODO
     */

    @FXML
    private void onConfirm() {
        roundGameManager.incrementRound();
        roundGameManager.closeBetweenRoundScreen();
    }

    @FXML
    private void onShop() { // TODO go to shop
        if (roundGameManager.getCurrRound() == 1) {
            cantAccessShopLabel.setText("Cannot access shop on round 1!");
        } else {
            roundGameManager.openShopScreen();
            // go to shop screen
        }

    }
    @FXML
    private void onInventory() { // TODO go to inventory
        if (roundGameManager.getCurrRound() == 1) {
            roundGameManager.openRoundOneInventoryScreen();
        }
            else {
            roundGameManager.openInventoryScreen();
        }
    }
}
