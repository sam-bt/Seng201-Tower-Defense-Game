package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import seng201.team0.GameManager;
import seng201.team0.services.RoundService;

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
    private Label moneyLabel;
    @FXML
    private Label trackLengthLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Button startRoundButton;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label roundsLeftLabel;
    @FXML
    private Label cantAccessShopLabel;
    @FXML
    private Label cantStartRoundLabel;
    @FXML
    private TextFlow cantStartRoundTextFlow;
    @FXML
    private Button goToShopButton;
    @FXML
    private Button goToInventoryButton;
    @FXML
    private Button skipRoundButton;
    @FXML
    private Button trackLengthButtonOne;
    @FXML
    private Button trackLengthButtonTwo;
    int shortTrackLength;
    int longTrackLength;
    boolean longTrackChosen;

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
        moneyLabel.setText("Current Money: " + roundGameManager.getMoneyAmount());
        difficultyLabel.setText("Current Difficulty: " + decimalFormat.format(roundGameManager.getDifficulty()));
        trackLengthLabel.setText("Current Track Length: Select");
        startRoundButton.setText("Start Round " + roundGameManager.getCurrRound() + "!");
        pointsLabel.setText("Current Points: " + decimalFormat.format(roundGameManager.getPoints()));
        shortTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty());
        longTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty())-10;
        trackLengthButtonOne.setText(shortTrackLength+" m");
        trackLengthButtonTwo.setText(longTrackLength+" m");
    }

    /**
     * Method that TODO
     */
    @FXML
    private void setTrackLengthOne(){
        trackLengthLabel.setText("Current Track Length: " + shortTrackLength + "m");
        longTrackChosen = false;
    }
    @FXML
    private void setTrackLengthTwo(){
        trackLengthLabel.setText("Current Track Length: " + longTrackLength + "m");
        longTrackChosen = true;
    }
    @FXML
    private void onConfirm() { // TODO wrap text
        if (roundGameManager.getRoundOneSelectedTowerList() == null) {
            cantStartRoundLabel.setText("Cannot start the round without any towers selected! Please go to the inventory and select your towers!"); }
        else if (shortTrackLength == 0 && longTrackLength == 0) {cantStartRoundLabel.setText("Please select a track length for the next round!");}
        else {
            if (longTrackChosen) {
            roundGameManager.setRoundTrackLength(longTrackLength); }
            else {
                roundGameManager.setRoundTrackLength(shortTrackLength);}
            roundGameManager.incrementRound();
            roundGameManager.closeBetweenRoundScreen();
        }
    }


    @FXML
    private void onShop() { // TODO wrap text
        if (roundGameManager.getCurrRound() == 1) {
            cantAccessShopLabel.setText("Cannot access shop on round 1!");
        } else {
            roundGameManager.openShopScreen();
            // go to shop screen
        }

    }
    @FXML
    private void onInventory() {
        if (roundGameManager.getCurrRound() == 1) {
            roundGameManager.openRoundOneInventoryScreen();
        }
            else {
            roundGameManager.openInventoryScreen();
        }
    }
    @FXML
    private void onSkipRound() {
        roundGameManager.incrementRound();
        roundGameManager.closeGameScreen();
    }
}
