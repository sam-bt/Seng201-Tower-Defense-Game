package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundService;
import seng201.team0.services.ShopService;

import java.text.DecimalFormat;
import java.util.List;


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
    @FXML
    private Button trackLengthButtonThree;
    int shortTrackLength;
    int mediumTrackLength;
    int longTrackLength;
    boolean trackChosen;
    int trackNumChosen;
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
//        if (roundGameManager.getCurrRound() != 1) {
//            List<Tower> towerList = roundGameManager.getRoundOneSelectedTowerList();
//            for (Tower tower : towerList) {
//                System.out.println(tower.getBreakChance());
//            }
//        }
        betweenRoundsTitleLabel.setText("Weclome " + roundGameManager.getName() + ", Here are your Stats for Round " + roundGameManager.getCurrRound() + " of " + roundGameManager.getRounds() + "!");
        roundsLeftLabel.setText("Rounds Left: " + (roundGameManager.getRounds() - roundGameManager.getCurrRound() + 1));
        moneyLabel.setText("Current Money: " + roundGameManager.getMoneyAmount());
        difficultyLabel.setText("Current Difficulty: " + decimalFormat.format(roundGameManager.getDifficulty()));
        trackLengthLabel.setText("Track Length: Select");
        startRoundButton.setText("Start Round " + roundGameManager.getCurrRound() + "!");
        pointsLabel.setText("Current Points: " + decimalFormat.format(roundGameManager.getPoints()));
        shortTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty())-10;
        mediumTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty());
        longTrackLength = RoundService.trackLengthCalculator(roundGameManager.getDifficulty())+10;
        trackLengthButtonOne.setText(shortTrackLength+" m");
        trackLengthButtonTwo.setText(mediumTrackLength+" m");
        trackLengthButtonThree.setText(longTrackLength+" m");
//        trackNumChosen = roundGameManager.getTrackLengthIndex();
//        System.out.println(trackNumChosen);
    }

    /**
     * Method that TODO
     */
    @FXML
    private void setTrackLengthOne(){
        trackLengthLabel.setText("Track Length: " + shortTrackLength + "m");
        trackNumChosen = 1;
        trackChosen = true;
    }
    @FXML
    private void setTrackLengthTwo(){
        trackLengthLabel.setText("Track Length: " + mediumTrackLength + "m");
        trackNumChosen = 2;
        trackChosen = true;
    }
    @FXML
    private void setTrackLengthThree(){
        trackLengthLabel.setText("Track Length: " + longTrackLength + "m");
        trackNumChosen = 3;
        trackChosen = true;
    }
    @FXML
    private void onConfirm() {
        System.out.println("click worked");
        if (roundGameManager.getCurrRound() == 1) {
            if (roundGameManager.isRoundOneSelectedTowerListNull()) {
                cantStartRoundLabel.setText("Cannot start the round without any towers selected! Please go to the inventory and select your towers!"); }
            else if ( trackNumChosen==0 ) {
                cantStartRoundLabel.setText("Please select a track length for the next round!");
            }
            else {
                roundGameManager.incrementRound();
                roundGameManager.closeBetweenRoundScreen();
                roundGameManager.setTrackLengthIndex(trackNumChosen);
                if (trackNumChosen==1) {
                    roundGameManager.setRoundTrackLength(shortTrackLength); }
                else if (trackNumChosen==2){
                    roundGameManager.setRoundTrackLength(mediumTrackLength);}
                else{roundGameManager.setRoundTrackLength(longTrackLength);}}
        } else {
            Tower[] towersInSlots = roundGameManager.getTowersInSlots();
            boolean brokenTowerError = false;
            boolean notEnoughTowers = false;
            for (int i = 0; i < towersInSlots.length; i++) {
                if (towersInSlots[i] == null) {
                    notEnoughTowers = true;
                    break;
                } else if (towersInSlots[i].getBroken() == true) {
                    brokenTowerError = true;
                    break;
                }
            }
            if (brokenTowerError) {
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

            } else if (notEnoughTowers) {
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
            } else {
                roundGameManager.incrementRound();
                roundGameManager.closeBetweenRoundScreen();
                roundGameManager.setTrackLengthIndex(trackNumChosen);
                if (trackNumChosen==1) {
                    roundGameManager.setRoundTrackLength(shortTrackLength); }
                else if (trackNumChosen==2){
                    roundGameManager.setRoundTrackLength(mediumTrackLength);}
                else{roundGameManager.setRoundTrackLength(longTrackLength);}
            }
        }
    }

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
    @FXML
    private void onShop() {
        if (roundGameManager.getCurrRound() == 1) {
            cantAccessShopLabel.setText("Cannot access shop on round 1!");
        } else {
            roundGameManager.openShopScreen();
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
