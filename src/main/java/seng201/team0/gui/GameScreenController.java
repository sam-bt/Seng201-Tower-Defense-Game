package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;
import seng201.team0.models.*;
import seng201.team0.services.CartService;

import java.util.List;
import java.util.Objects;

/**
 * Controller class for the main game screen in the game GUI.
 * Handles user interactions and updating the game display.
 */
public class GameScreenController {
    /**
     * The GameManager instance for the current game round.
     */
    GameManager roundGameManager;
    @FXML
    private ProgressBar cartOneFillProgressBar;
    @FXML
    private ProgressBar cartTwoFillProgressBar;
    @FXML
    private ProgressBar cartThreeFillProgressBar;
    @FXML
    private ProgressBar cartFourFillProgressBar;
    @FXML
    private ProgressBar cartFiveFillProgressBar;
    @FXML
    private ProgressBar cartOneTravelProgressBar;
    @FXML
    private ProgressBar cartTwoTravelProgressBar;
    @FXML
    private ProgressBar cartThreeTravelProgressBar;
    @FXML
    private ProgressBar cartFourTravelProgressBar;
    @FXML
    private ProgressBar cartFiveTravelProgressBar;
    @FXML
    private Label nameAndRoundLabel;
    @FXML
    private Label moneyLabel;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label trackLengthLabel;
    @FXML
    private Label cartOneNameLabel;
    @FXML
    private Label cartTwoNameLabel;
    @FXML
    private Label cartThreeNameLabel;
    @FXML
    private Label cartFourNameLabel;
    @FXML
    private Label cartFiveNameLabel;
    @FXML
    private Label cartOneSpeedLabel;
    @FXML
    private Label cartTwoSpeedLabel;
    @FXML
    private Label cartThreeSpeedLabel;
    @FXML
    private Label cartFourSpeedLabel;
    @FXML
    private Label cartFiveSpeedLabel;
    @FXML
    private Label cartOneSizeLabel;
    @FXML
    private Label cartTwoSizeLabel;
    @FXML
    private Label cartThreeSizeLabel;
    @FXML
    private Label cartFourSizeLabel;
    @FXML
    private Label cartFiveSizeLabel;
    @FXML
    private Label eventFrameLabel;
    @FXML
    private Label fillAmountLabel;
    @FXML
    private Label reloadSpeedLabel;
    @FXML
    private Label towerHealthLabel;
    @FXML
    private Label actionsLeftLabel;
    @FXML
    private Label fillCartWithTowerLabel;
    @FXML
    private Label bonusTowerLabel;
    @FXML
    private Button towerOneButton;
    @FXML
    private Button towerTwoButton;
    @FXML
    private Button towerThreeButton;
    @FXML
    private Button towerFourButton;
    @FXML
    private Button towerFiveButton;
    @FXML
    private Button cartOneButton;
    @FXML
    private Button cartTwoButton;
    @FXML
    private Button cartThreeButton;
    @FXML
    private Button cartFourButton;
    @FXML
    private Button cartFiveButton;
    @FXML
    private Button confirmActionButton;
    @FXML
    private Button nextFrameButton;
    /**
     * The current round being played.
     */
    private Round round;

    /**
     * List of carts available in the game.
     */
    private List<Cart> cartList;

    /**
     * Index of the selected tower.
     */
    private int selectedTowerIndex = -1;

    /**
     * Indicates if the bonus is unlocked.
     */
    private boolean bonusUnlocked;

    /**
     * Indicates if the game is lost.
     */
    private boolean lost;

    /**
     * Array containing tower objects.
     */
    private final Tower[] towerList = new Tower[5];

    /**
     * Instance of RandomEvent class.
     */
    RandomEvent randomEvent = new RandomEvent();
    /**
     * List of buttons representing towers.
     */
    private List<Button> towerButtons;

    /**
     * List of buttons representing carts.
     */
    private List<Button> cartButtons;

    /**
     * List of progress bars representing fill level of carts.
     */
    private List<ProgressBar> cartFillProgressBars;

    /**
     * List of progress bars representing travel progress of carts.
     */
    private List<ProgressBar> cartProgressBars;

    /**
     * List of labels displaying the size of carts.
     */
    private List<Label> cartSizeLabels;

    /**
     * Constructor for the GameScreenController generating the game manager.
     *
     * @param tempRoundGameManager The GameManager instance managing the current game round.
     */
    public GameScreenController(GameManager tempRoundGameManager) {
        roundGameManager = tempRoundGameManager;
    }

    /**
     * Initializes the game screen and sets up initial game state.
     * Called automatically after FXML file is loaded.
     */
    public void initialize() {
        round = new Round(roundGameManager.getDifficultyService(), roundGameManager.getRoundTrackLength());
        cartList = List.of(round.getCoalCart(), round.getIronCart(), round.getGoldCart(), round.getGemCart(), round.getBonusCart());
        Tower[] tempTowerList = roundGameManager.getTowersInSlots();
        towerList[0] = tempTowerList[0];
        towerList[1] = tempTowerList[1];
        towerList[2] = tempTowerList[2];
        towerList[3] = tempTowerList[3];
        towerList[4] = tempTowerList[4];

        towerButtons = List.of(towerOneButton, towerTwoButton, towerThreeButton, towerFourButton, towerFiveButton);
        cartButtons = List.of(cartOneButton, cartTwoButton, cartThreeButton, cartFourButton, cartFiveButton);
        cartSizeLabels = List.of(cartOneSizeLabel, cartTwoSizeLabel, cartThreeSizeLabel, cartFourSizeLabel, cartFiveSizeLabel);
        cartFillProgressBars = List.of(cartOneFillProgressBar, cartTwoFillProgressBar, cartThreeFillProgressBar, cartFourFillProgressBar, cartFiveFillProgressBar);
        cartProgressBars = List.of(cartOneTravelProgressBar, cartTwoTravelProgressBar, cartThreeTravelProgressBar, cartFourTravelProgressBar, cartFiveTravelProgressBar);

        cartOneNameLabel.setText("Cart: " + cartList.get(0).getCartName());
        cartTwoNameLabel.setText("Cart: " + cartList.get(1).getCartName());
        cartThreeNameLabel.setText("Cart: " + cartList.get(2).getCartName());
        cartFourNameLabel.setText("Cart: " + cartList.get(3).getCartName());
        cartFiveNameLabel.setText("Cart: " + cartList.get(4).getCartName());
        cartOneSpeedLabel.setText("Speed: " + cartList.get(0).getSpeed() + " m/s");
        cartTwoSpeedLabel.setText("Speed: " + cartList.get(1).getSpeed() + " m/s");
        cartThreeSpeedLabel.setText("Speed: " + cartList.get(2).getSpeed() + " m/s");
        cartFourSpeedLabel.setText("Speed: " + cartList.get(3).getSpeed() + " m/s");
        cartFiveSpeedLabel.setText("Speed: " + cartList.get(4).getSpeed() + " m/s");
        cartOneSizeLabel.setText("Filled: 0/" + cartList.get(0).getCapacity());
        cartTwoSizeLabel.setText("Filled: 0/" + cartList.get(1).getCapacity());
        cartThreeSizeLabel.setText("Filled: 0/" + cartList.get(2).getCapacity());
        cartFourSizeLabel.setText("Filled: 0/" + cartList.get(2).getCapacity());
        cartFiveSizeLabel.setText("Filled: 0/" + cartList.get(2).getCapacity());
        cartOneFillProgressBar.setMouseTransparent(true);
        cartTwoFillProgressBar.setMouseTransparent(true);
        cartThreeFillProgressBar.setMouseTransparent(true);
        cartFourFillProgressBar.setMouseTransparent(true);
        cartFiveFillProgressBar.setMouseTransparent(true);
        cartOneButton.setMouseTransparent(true);
        cartTwoButton.setMouseTransparent(true);
        cartThreeButton.setMouseTransparent(true);
        cartFourButton.setMouseTransparent(true);
        cartFiveButton.setMouseTransparent(true);
        cartOneFillProgressBar.setStyle("-fx-accent: black");
        cartTwoFillProgressBar.setStyle("-fx-accent: silver");
        cartThreeFillProgressBar.setStyle("-fx-accent: gold");
        cartFourFillProgressBar.setStyle("-fx-accent: blue");
        cartFiveFillProgressBar.setStyle("-fx-accent: red");
        cartOneFillProgressBar.setProgress(0.0);
        cartTwoFillProgressBar.setProgress(0.0);
        cartThreeFillProgressBar.setProgress(0.0);
        cartFourFillProgressBar.setProgress(0.0);
        cartFiveFillProgressBar.setProgress(0.0);
        cartOneTravelProgressBar.setProgress(0.0);
        cartTwoTravelProgressBar.setProgress(0.0);
        cartThreeTravelProgressBar.setProgress(0.0);
        cartFourTravelProgressBar.setProgress(0.0);
        cartFiveTravelProgressBar.setProgress(0.0);
        nameAndRoundLabel.setText("Name: " + roundGameManager.getName() + "   Round: " + (roundGameManager.getCurrRound() - 1));
        moneyLabel.setText("Money: " + roundGameManager.getMoneyAmount());
        difficultyLabel.setText("Difficulty: " + roundGameManager.getDifficulty());
        pointsLabel.setText("Points: " + roundGameManager.getPoints());
        trackLengthLabel.setText("Track Length: " + roundGameManager.getRoundTrackLength() + "m");
        actionsLeftLabel.setText("Actions Left: " + round.getActionsLeft());
        towerOneButton.setText(towerList[0].getTowerName());
        towerTwoButton.setText(towerList[1].getTowerName());
        towerThreeButton.setText(towerList[2].getTowerName());
        towerFourButton.setText(towerList[3].getTowerName());
        towerFiveButton.setText(towerList[4].getTowerName());

        for (int i = 0; i < towerButtons.size(); i++) {
            int finalI = i;
            towerButtons.get(i).setOnAction(event -> {
                selectedTowerIndex = finalI;
                updateSelectedTowerStats(towerList[finalI]);
                towerButtons.forEach(button -> {
                    int buttonIndex = towerButtons.indexOf(button);
                    if (button == towerButtons.get(finalI) && towerList[finalI].isUsable()) {
                        button.setStyle("-fx-background-color: #99FF99; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    } else if (towerList[buttonIndex].isUsable()) {
                        button.setStyle("-fx-background-color: #D1FFBD; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    } else {
                        button.setStyle("-fx-background-color: #FF7F7F; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    }
                });
            });
        }
    }

    /**
     * Updates the selected tower's displayed statistics.
     *
     * @param tower The tower whose stats need to be updated.
     */
    public void updateSelectedTowerStats(Tower tower) {
        fillAmountLabel.setText("Fill Amount: " + tower.getFillAmount());
        towerHealthLabel.setText("Health: " + tower.getHealth());
        if (tower.getActionsUntilUsable() == 0) {
            reloadSpeedLabel.setText("Tower Reloaded!");
            fillCartWithTowerLabel.setStyle("-fx-text-fill: black");
            fillCartWithTowerLabel.setText("Fill all " + tower.getFillType() + " carts?");
        } else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Tower reloading!");
            reloadSpeedLabel.setText("Usable in: " + tower.getActionsUntilUsable() + " Actions");
        }
    }

    /**
     * Updates the colors and styles of tower buttons based on their usability.
     */
    public void updateTowerColours() {
        for (int towerIndex = 0; towerIndex < towerList.length; towerIndex++) {
            if (towerList[towerIndex].isUsable()) {
                towerButtons.get(towerIndex).setStyle("-fx-background-color: #D1FFBD; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
            } else {
                towerButtons.get(towerIndex).setStyle("-fx-background-color: #FF7F7F; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
            }
        }
    }

    /**
     * Fills the carts with resources based on the selected tower.
     * Updates the progress bars and size labels accordingly.
     *
     * @param selectedTower The tower selected by the player to fill the carts.
     */
    public void fillCarts(Tower selectedTower) {
        for (int cartIndex = 0; cartIndex < cartFillProgressBars.size(); cartIndex++) {
            Cart cart = cartList.get(cartIndex);
            if (Objects.equals(cart.getResourceType(), selectedTower.getFillType())) {
                cartFillProgressBars.get(cartIndex).setProgress(cart.getCurrentFillAmount());
                cartSizeLabels.get(cartIndex).setText("Filled: " + cart.getCurrentFillDisplay() + "/" + cart.getCapacity());
            }
        }
    }

    /**
     * Fills the bonus cart regardless of resource
     * Updates its progress bar and size label accordingly
     */
    public void fillBonusCart() {
        Cart cart = cartList.get(4);
        cartFillProgressBars.get(4).setProgress(cart.getCurrentFillAmount());
        cartSizeLabels.get(4).setText("Filled: " + cart.getCurrentFillDisplay() + "/" + cart.getCapacity());
    }

    /**
     * Updates the distances traveled by the carts.
     */
    public void updateCartDistances() {
        for (int cartIndex = 0; cartIndex < cartProgressBars.size(); cartIndex++) {
            cartProgressBars.get(cartIndex).setProgress(cartList.get(cartIndex).getDistanceTravelled());
        }
    }

    /**
     * Sets the bonus unlocked and updates the UI accordingly.
     */
    public void setBonus() {
        this.bonusUnlocked = true;
        cartOneNameLabel.setText("");
        cartTwoNameLabel.setText("");
        cartThreeNameLabel.setText("");
        cartFourNameLabel.setText("");
        cartOneSpeedLabel.setText("");
        cartTwoSpeedLabel.setText("");
        cartThreeSpeedLabel.setText("");
        cartFourSpeedLabel.setText("");
        cartOneSizeLabel.setText("");
        cartTwoSizeLabel.setText("");
        cartThreeSizeLabel.setText("");
        cartFourSizeLabel.setText("");
        bonusTowerLabel.setText("BONUS TOWER UNLOCKED!!");

    }

    /**
     * Executes a random event in the game and updates the UI accordingly.
     *
     * @param eventName The name of the random event.
     * @param eventText The description text of the random event.
     */
    public void executeRandomEvent(String eventName, String eventText) {
        if (Objects.equals(eventName, "Cart Reset")) {
            int cartToReset = randomEvent.generateRoundIndex();
            cartList.get(cartToReset).resetDistance();
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: green");
        } else if (Objects.equals(eventName, "Reset Towers")) {
            for (Tower tower : towerList) {
                tower.setUsable();
            }
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: green");
        } else if (Objects.equals(eventName, "Fill Cart")) {
            int cartToFill = randomEvent.generateRoundIndex();
            Cart cart = cartList.get(cartToFill);
            if (cart.isFull() || (Objects.equals(cart.getCartName(), "Bonus") && !bonusUnlocked)) {
                eventFrameLabel.setText("Nothing Happened");
                eventFrameLabel.setStyle("-fx-text-fill: black");
            } else {
                cart.increaseFillAmount(1000);
                eventFrameLabel.setText(eventText);
                eventFrameLabel.setStyle("-fx-text-fill: green");
            }
            cartFillProgressBars.get(cartToFill).setProgress(cart.getCurrentFillAmount());
            cartSizeLabels.get(cartToFill).setText("Filled: " + cart.getCurrentFillDisplay() + "/" + cart.getCapacity());
        } else if (Objects.equals(eventName, "Nothing")) {
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: black");
        } else if (Objects.equals(eventName, "Steal Resources")) {
            for (int cartIndex = 0; cartIndex < cartFillProgressBars.size(); cartIndex++) {
                Cart cart = cartList.get(cartIndex);
                if (!cart.isFull()) {
                    cart.increaseFillAmount(-20);
                    cartFillProgressBars.get(cartIndex).setProgress(cart.getCurrentFillAmount());
                    cartSizeLabels.get(cartIndex).setText("Filled: " + cart.getCurrentFillDisplay() + "/" + cart.getCapacity());
                }
            }
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: red");
        } else if (Objects.equals(eventName, "Disable Tower")) {
            int towerToDisable = randomEvent.generateRoundIndex();
            towerList[towerToDisable].use();
            eventFrameLabel.setText(eventText);
            updateSelectedTowerStats(towerList[towerToDisable]);
            eventFrameLabel.setStyle("-fx-text-fill: red");
        } else if (Objects.equals(eventName, "Actions Reset")) {
            round.resetActions();
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: red");
        }
        this.updateTowerColours();
    }

    /**
     * Executes the selected action by the player.
     */
    @FXML
    private void onConfirmAction() {
        if (round.getActionsLeft() == 0) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("No actions left this frame!!");
        } else if (selectedTowerIndex != -1) {
            Tower selectedTower = towerList[selectedTowerIndex];
            if (bonusUnlocked) {
                round.useBonusAction(selectedTower, cartList, towerList);
                if (selectedTower.getBroken() && !cartList.get(selectedTowerIndex).isFull()) {
                    towerButtons.get(selectedTowerIndex).setStyle("-fx-background-color: black; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    confirmActionButton.setDisable(true);
                    for (Button towerButton : towerButtons) {
                        towerButton.setDisable(true);
                    }
                    fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                    fillCartWithTowerLabel.setText("Round Lost !!");
                    nextFrameButton.setText("View Summary");
                    lost = true;
                } else if (selectedTower.getBroken() && cartList.get(selectedTowerIndex).isFull()) {
                    towerButtons.get(selectedTowerIndex).setDisable(true);
                }
                fillBonusCart();
                updateSelectedTowerStats(towerList[selectedTowerIndex]);
                actionsLeftLabel.setText("Actions Left: " + round.getActionsLeft());
            } else {
                if (selectedTower.isUsable()) {
                    if (round.isCartFillable(cartList, selectedTower)) {
                        round.useAction(selectedTower, cartList, towerList);
                        if (selectedTower.getBroken() && !cartList.get(selectedTowerIndex).isFull()) {
                            towerButtons.get(selectedTowerIndex).setStyle("-fx-background-color: black; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                            confirmActionButton.setDisable(true);
                            for (Button towerButton : towerButtons) {
                                towerButton.setDisable(true);
                            }
                            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                            fillCartWithTowerLabel.setText("Round Lost!!");
                            nextFrameButton.setText("View Summary");
                            lost = true;
                        } else if (selectedTower.getBroken() && cartList.get(selectedTowerIndex).isFull()) {
                            towerButtons.get(selectedTowerIndex).setDisable(true);
                        }
                        fillCarts(selectedTower);
                        updateSelectedTowerStats(towerList[selectedTowerIndex]);
                        actionsLeftLabel.setText("Actions Left: " + round.getActionsLeft());
                        if (CartService.areAllCartsFull(cartList)) {
                            this.setBonus();
                            cartButtons.get(0).setStyle("-fx-background-color: black; -fx-background-radius: 5;");
                            cartButtons.get(1).setStyle("-fx-background-color: silver; -fx-background-radius: 5;");
                            cartButtons.get(2).setStyle("-fx-background-color: gold; -fx-background-radius: 5;");
                            cartButtons.get(3).setStyle("-fx-background-color: blue; -fx-background-radius: 5;");
                        }
                    } else {
                        fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                        fillCartWithTowerLabel.setText("All the " + selectedTower.getFillType() + " Carts are full!");
                    }
                } else {
                    fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                    fillCartWithTowerLabel.setText("Tower reloading!");
                }
            }
            updateSelectedTowerStats(selectedTower);
        } else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please select a Tower!");
        }
        this.updateTowerColours();
    }

    /**
     * Confirms the next action in the game round.
     */
    @FXML
    private void onConfirmNext() {
        if (selectedTowerIndex == -1) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please select a Tower!");
        } else {
            if (lost) {
                roundGameManager.openLosingScreen();
            } else {
                round.nextFrame(cartList, towerList);
                if (round.roundEnded(cartList)) {
                    if (round.roundWon(cartList)) {
                        cartButtons.get(4).setStyle("-fx-background-color: red; -fx-background-radius: 5;");
                        confirmActionButton.setDisable(true);
                        for (Button towerButton : towerButtons) {
                            towerButton.setDisable(true);
                        }
                        fillCartWithTowerLabel.setStyle("-fx-text-fill: green");
                        fillCartWithTowerLabel.setText("Round Won !!");
                        if (roundGameManager.getCurrRound() - 1 == roundGameManager.getRounds()) {
                            nextFrameButton.setText("View Summary");
                        } else {
                            nextFrameButton.setText("To next round!");
                        }
                        nextFrameButton.setOnAction(event -> onConfirm());
                    } else {
                        updateCartDistances();
                        confirmActionButton.setDisable(true);
                        for (Button towerButton : towerButtons) {
                            towerButton.setDisable(true);
                        }
                        fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                        fillCartWithTowerLabel.setText("Round Lost !!");
                        nextFrameButton.setText("View Summary");
                        lost = true;
                    }
                } else {
                    randomEvent.generateRandomEvent(roundGameManager.getDifficulty());
                    executeRandomEvent(randomEvent.getEventName(), randomEvent.getEventText());
                    updateSelectedTowerStats(towerList[selectedTowerIndex]);
                    updateCartDistances();
                    actionsLeftLabel.setText("Actions Left This Frame: " + round.getActionsLeft());
                }
            }
        }
    }

    /**
     * Closes the game screen and launches the between round screen.
     */
    @FXML
    private void onConfirm() {
        roundGameManager.closeGameScreen();
    }
}
