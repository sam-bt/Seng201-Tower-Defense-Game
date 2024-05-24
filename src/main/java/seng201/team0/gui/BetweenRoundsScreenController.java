package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundService;

import java.text.DecimalFormat;

/**
 * Controller for the between rounds screen in the game.
 * This class manages the user interface and interactions for the screen displayed between rounds.
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
    @FXML
    private Button trackLengthButtonThree;
    /**
     * Length of a short track in meters.
     */
    private int shortTrackLength;

    /**
     * Length of a medium track in meters.
     */
    private int mediumTrackLength;

    /**
     * Length of a long track in meters.
     */
    private int longTrackLength;

    /**
     * Shows if a track has been chosen or not.
     */
    private boolean trackChosen;

    /**
     * Number of the chosen track.
     */
    private int trackNumChosen;

    /**
     * The game manager for the round.
     */
    private final GameManager roundGameManager;


    /**
     * Constructor that sets the GameManager instance.
     *
     * @param tempRoundGameManager the GameManager instance used to retrieve and update game state
     */
    public BetweenRoundsScreenController(GameManager tempRoundGameManager) {
        roundGameManager = tempRoundGameManager;
    }

    /**
     * Initializer method that sets the labels and buttons on the screen.
     */
    public void initialize() {
        betweenRoundsTitleLabel.setText("Welcome " + roundGameManager.getName() + ", Here are your Stats for Round " + roundGameManager.getCurrRound() + " of " + roundGameManager.getRounds() + "!");
        roundsLeftLabel.setText("Rounds Left: " + (roundGameManager.getRounds() - roundGameManager.getCurrRound() + 1));
        moneyLabel.setText("Current Money: " + roundGameManager.getMoneyAmount());
        difficultyLabel.setText("Current Difficulty: " + decimalFormat.format(roundGameManager.getDifficulty()));
        trackLengthLabel.setText("Track Length: Select");
        startRoundButton.setText("Start Round " + roundGameManager.getCurrRound() + "!");
        pointsLabel.setText("Current Points: " + decimalFormat.format(roundGameManager.getPoints()));
        shortTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty()) - 10;
        mediumTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty());
        longTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty()) + 10;
        trackLengthButtonOne.setText(shortTrackLength + " m");
        trackLengthButtonTwo.setText(mediumTrackLength + " m");
        trackLengthButtonThree.setText(longTrackLength + " m");
    }

    /**
     * Sets the track length to the short length and updates the label.
     */
    @FXML
    private void setTrackLengthOne() {
        trackLengthLabel.setText("Track Length: " + shortTrackLength + "m");
        trackNumChosen = 1;
        trackChosen = true;
    }

    /**
     * Sets the track length to the medium length and updates the label.
     */
    @FXML
    private void setTrackLengthTwo() {
        trackLengthLabel.setText("Track Length: " + mediumTrackLength + "m");
        trackNumChosen = 2;
        trackChosen = true;
    }

    /**
     * Sets the track length to the long length and updates the label.
     */
    @FXML
    private void setTrackLengthThree() {
        trackLengthLabel.setText("Track Length: " + longTrackLength + "m");
        trackNumChosen = 3;
        trackChosen = true;
    }

    /**
     * Confirms the selected track length and starts the round if all conditions are met.
     */
    @FXML
    private void onConfirm() {
        System.out.println("click worked");
        if (roundGameManager.getCurrRound() == 1) {
            if (roundGameManager.isRoundOneSelectedTowerListNull()) {
                cantStartRoundLabel.setText("Cannot start the round without any towers selected! Please go to the inventory and select your towers!");
            } else if (trackNumChosen == 0) {
                cantStartRoundLabel.setText("Please select a track length for the next round!");
            } else {
                roundGameManager.setTrackLengthIndex(trackNumChosen);
                if (trackNumChosen == 1) {
                    roundGameManager.setRoundTrackLength(shortTrackLength);
                } else if (trackNumChosen == 2) {
                    roundGameManager.setRoundTrackLength(mediumTrackLength);
                } else {
                    roundGameManager.setRoundTrackLength(longTrackLength);
                }
                roundGameManager.incrementRound();
                roundGameManager.closeBetweenRoundScreen();
            }
        } else {
            Tower[] towersInSlots = roundGameManager.getTowersInSlots();
            boolean brokenTowerError = false;
            boolean notEnoughTowers = false;
            for (Tower tower : towersInSlots) {
                if (tower == null) {
                    notEnoughTowers = true;
                    break;
                } else if (tower.getBroken()) {
                    brokenTowerError = true;
                    break;
                }
            }
            if (brokenTowerError) {
                handleBrokenTowerError();
            } else if (notEnoughTowers) {
                handleNotEnoughTowersError();
            } else {
                roundGameManager.setTrackLengthIndex(trackNumChosen);
                if (trackNumChosen == 1) {
                    roundGameManager.setRoundTrackLength(shortTrackLength);
                } else if (trackNumChosen == 2) {
                    roundGameManager.setRoundTrackLength(mediumTrackLength);
                } else {
                    roundGameManager.setRoundTrackLength(longTrackLength);
                }
                roundGameManager.incrementRound();
                roundGameManager.closeBetweenRoundScreen();
            }
        }
    }

    /**
     * Handles the case where there is a broken tower.
     */
    private void handleBrokenTowerError() {
        System.out.println("broken step 1");
        if (!roundGameManager.isNotFirstTimeInInventory()) {
            System.out.println("broken step 2");
            cantStartRoundLabel.setText("Select your towers in the inventory");
        } else {
            System.out.println("broken step 3");
            cantStartRoundLabel.setText("One of your towers is broken!");
            if (getNetWorth() < roundGameManager.getCheapestTowersSum(roundGameManager.getGenericRoundTowerList()) + 100) {
                System.out.println("broken step 4");
                roundGameManager.launchLosingScreen();
                System.out.println("YOU LOSE");
            }
        }
    }

    /**
     * Handles the case where not enough towers are selected.
     */
    private void handleNotEnoughTowersError() {
        System.out.println("not enough step 1");
        if (!roundGameManager.isNotFirstTimeInInventory()) {
            cantStartRoundLabel.setText("Select your towers in the inventory");
        } else {
            System.out.println("not enough step 2");
            cantStartRoundLabel.setText("You need 5 towers selected to start the next round!");
            System.out.println(getNetWorth() + "<=" + roundGameManager.getCheapestTowersSum(roundGameManager.getGenericRoundTowerList()));
            if (getNetWorth() < roundGameManager.getCheapestTowersSum(roundGameManager.getGenericRoundTowerList())) {
                System.out.println("not enough step 3");
                roundGameManager.launchLosingScreen();
                System.out.println("YOU LOSE");
            }
        }
    }

    /**
     * Calculates the net worth of the player.
     *
     * @return the net worth
     */
    private double getNetWorth() {
        double netWorth = roundGameManager.getMoneyAmount();
        netWorth += (roundGameManager.getAvailableHeals() * 50);
        netWorth += (roundGameManager.getAvailableRevives() * 500);
        netWorth += (roundGameManager.getAvailableUpgrades() * 150);
        for (int i = 0; i < roundGameManager.getGenericRoundTowerList().size(); i++) {
            if (roundGameManager.getGenericRoundTowerList().get(i).getOwned()) {
                netWorth += roundGameManager.getGenericRoundTowerList().get(i).getBuyPrice();
            }
        }
        return netWorth;
    }

    /**
    * If the current round is 1, displays a message indicating that the shop cannot be accessed.
    * Otherwise, opens the shop screen.
    */
    @FXML
    private void onShop() {
        if (roundGameManager.getCurrRound() == 1) {
            cantAccessShopLabel.setText("Cannot access shop on round 1!");
        } else {
            roundGameManager.openShopScreen();
        }
    }

    /**
     * If the current round is 1, opens the inventory screen specific to round one.
     * Otherwise, opens the general inventory screen.
     */
    @FXML
    private void onInventory() {
        if (roundGameManager.getCurrRound() == 1) {
            roundGameManager.openRoundOneInventoryScreen();
        } else {
            roundGameManager.openInventoryScreen();
        }
    }

    /**
     * Increases the round number and closes the game screen.
     */
    @FXML
    private void onSkipRound() {
        roundGameManager.incrementRound();
        roundGameManager.closeGameScreen();
    }
}
