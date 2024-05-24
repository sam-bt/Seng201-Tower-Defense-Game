package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;
import seng201.team0.models.Cart;
import seng201.team0.models.RandomEvent;
import seng201.team0.models.RoundOne;
import seng201.team0.models.Tower;

import java.util.List;
import java.util.Objects;

/**
 * Controller class for the graphical user interface of Round One of the game.
 * This class handles the interaction between the game logic and the JavaFX user interface components.
 */
public class RoundOneGameScreenController {
    @FXML private Button nextRoundButton;
    @FXML private ProgressBar cartOneFillProgressBar;
    @FXML private ProgressBar cartTwoFillProgressBar;
    @FXML private ProgressBar cartThreeFillProgressBar;
    @FXML private ProgressBar cartOneTravelProgressBar;
    @FXML private ProgressBar cartTwoTravelProgressBar;
    @FXML private ProgressBar cartThreeTravelProgressBar;
    @FXML private Label nameAndRoundLabel;
    @FXML private Label moneyLabel;
    @FXML private Label pointsLabel;
    @FXML private Label difficultyLabel;
    @FXML private Label trackLengthLabel;
    @FXML private Label cartOneNameLabel;
    @FXML private Label cartTwoNameLabel;
    @FXML private Label cartThreeNameLabel;
    @FXML private Label cartOneSpeedLabel;
    @FXML private Label cartTwoSpeedLabel;
    @FXML private Label cartThreeSpeedLabel;
    @FXML private Label cartOneSizeLabel;
    @FXML private Label cartTwoSizeLabel;
    @FXML private Label cartThreeSizeLabel;
    @FXML private Label eventFrameLabel;
    @FXML private Label fillAmountLabel;
    @FXML private Label reloadSpeedLabel;
    @FXML private Label towerHealthLabel;
    @FXML private Label actionsLeftLabel;
    @FXML private Label fillCartWithTowerLabel;
    @FXML private Button towerOneButton;
    @FXML private Button towerTwoButton;
    @FXML private Button towerThreeButton;
    @FXML private Button cartOneButton;
    @FXML private Button cartTwoButton;
    @FXML private Button cartThreeButton;
    @FXML private Button confirmActionButton;
    @FXML private Button nextFrameButton;
    /**
     * Array containing the towers available for selection in the game round.
     */
    private Tower[] towerList;

    /**
     * List containing the carts present in the game round.
     */
    private List<Cart> cartList;

    /**
     * Index of the currently selected tower. Initialized to -1 indicating no tower is selected.
     */
    private int selectedTowerIndex = -1;

    /**
     * Flag indicating whether the round has been lost.
     */
    private boolean lost;

    /**
     * List of buttons representing the towers in the user interface.
     */
    List<Button> towerButtons;

    /**
     * List of buttons representing the carts in the user interface.
     */
    List<Button> cartButtons;

    /**
     * List of progress bars representing the fill levels of carts in the user interface.
     */
    List<ProgressBar> cartFillProgressBars;

    /**
     * List of progress bars representing the travel progress of carts in the user interface.
     */
    List<ProgressBar> cartProgressBars;

    /**
     * List of labels displaying the size of carts in the user interface.
     */
    List<Label> cartSizeLabels;

    /**
     * Instance of the RoundOne class managing the game round.
     */
    RoundOne roundOne;

    /**
     * Instance of the RandomEvent class handling random events during the game round.
     */
    RandomEvent randomEvent = new RandomEvent();

    /**
     * Instance of the GameManager class managing the game.
     */
    GameManager roundOneGameScreenManager;


    /**
     * Constructor for RoundOneGameScreenController.
     * @param tempRoundOneGameScreenManager The GameManager instance managing the game.
     */
    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    /**
     * Initializes the round one game screen controller and
     */
    public void initialize() {
        roundOne = new RoundOne(roundOneGameScreenManager.getMoneyService(), roundOneGameScreenManager.getPoints(), roundOneGameScreenManager.getDifficultyService(), roundOneGameScreenManager.getRoundTrackLength());
        towerList = roundOneGameScreenManager.getRoundOneSelectedTowerList();
        cartList = List.of(roundOne.getCoalCart(), roundOne.getIronCart(), roundOne.getGoldCart());

        towerButtons = List.of(towerOneButton,towerTwoButton,towerThreeButton);
        cartButtons = List.of(cartOneButton,cartTwoButton,cartThreeButton);
        cartSizeLabels = List.of(cartOneSizeLabel,cartTwoSizeLabel,cartThreeSizeLabel);
        cartFillProgressBars = List.of(cartOneFillProgressBar,cartTwoFillProgressBar,cartThreeFillProgressBar);
        cartProgressBars = List.of(cartOneTravelProgressBar,cartTwoTravelProgressBar,cartThreeTravelProgressBar);

        cartOneNameLabel.setText("Cart: "+cartList.get(0).getCartName());
        cartTwoNameLabel.setText("Cart: "+cartList.get(1).getCartName());
        cartThreeNameLabel.setText("Cart: "+cartList.get(2).getCartName());
        cartOneSpeedLabel.setText("Speed: "+cartList.get(0).getSpeed()+" m/s");
        cartTwoSpeedLabel.setText("Speed: "+cartList.get(1).getSpeed()+" m/s");
        cartThreeSpeedLabel.setText("Speed: "+cartList.get(2).getSpeed()+" m/s");
        cartOneSizeLabel.setText("Capacity: 0/"+cartList.get(0).getCapacity());
        cartTwoSizeLabel.setText("Capacity: 0/"+cartList.get(1).getCapacity());
        cartThreeSizeLabel.setText("Capacity: 0/"+cartList.get(2).getCapacity());
        cartOneFillProgressBar.setMouseTransparent(true);
        cartTwoFillProgressBar.setMouseTransparent(true);
        cartThreeFillProgressBar.setMouseTransparent(true);
        cartOneButton.setMouseTransparent(true);
        cartTwoButton.setMouseTransparent(true);
        cartThreeButton.setMouseTransparent(true);
        cartOneFillProgressBar.setStyle("-fx-accent: black");
        cartTwoFillProgressBar.setStyle("-fx-accent: silver");
        cartThreeFillProgressBar.setStyle("-fx-accent: gold");
        cartOneFillProgressBar.setProgress(0.0);
        cartTwoFillProgressBar.setProgress(0.0);
        cartThreeFillProgressBar.setProgress(0.0);
        cartOneTravelProgressBar.setProgress(0.0);
        cartTwoTravelProgressBar.setProgress(0.0);
        cartThreeTravelProgressBar.setProgress(0.0);
        nameAndRoundLabel.setText("Name: "+roundOneGameScreenManager.getName()+"   Round: "+(roundOneGameScreenManager.getCurrRound()-1));
        moneyLabel.setText("Money: "+roundOneGameScreenManager.getMoneyAmount());
        difficultyLabel.setText("Difficulty: "+roundOneGameScreenManager.getDifficulty());
        pointsLabel.setText("Points: "+roundOneGameScreenManager.getPoints());
        trackLengthLabel.setText("Track Length: "+roundOneGameScreenManager.getRoundTrackLength()+"m");
        actionsLeftLabel.setText("Actions Left This Frame: "+roundOne.getActionsLeft());
        towerOneButton.setText(towerList[0].getTowerName());
        towerTwoButton.setText(towerList[1].getTowerName());
        towerThreeButton.setText(towerList[2].getTowerName());

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
                    }
                    else {button.setStyle("-fx-background-color: #FF7F7F; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");}
                });
            });
        }
    }

    /**
     * Updates the stats of the selected tower.
     * @param tower The selected tower to update the stats for.
     */
    public void updateSelectedTowerStats(Tower tower) {
        fillAmountLabel.setText("Fill Amount: "+tower.getFillAmount());
        towerHealthLabel.setText("Health: "+tower.getHealth());
        if (tower.getActionsUntilUsable() == 0) {
            reloadSpeedLabel.setText("Tower Reloaded!");
            fillCartWithTowerLabel.setStyle("-fx-text-fill: black");
            fillCartWithTowerLabel.setText("Fill all "+tower.getFillType()+ " carts?");
        }
        else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("This Tower is currently reloading!");
            reloadSpeedLabel.setText("Actions until next usable: "+tower.getActionsUntilUsable());
        }
    }
    /**
     * Updates the colors of the tower buttons based on their usability status.
     */
    public void updateTowerColours(){
        for (int towerIndex = 0; towerIndex < towerList.length; towerIndex++){
            if (towerList[towerIndex].isUsable()) {
                towerButtons.get(towerIndex).setStyle("-fx-background-color: #D1FFBD; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
            }
            else {
                towerButtons.get(towerIndex).setStyle("-fx-background-color: #FF7F7F; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
            }
        }
    }
    /**
     * Fills carts with resources based on the selected tower.
     * @param selectedTower The tower selected to fill the carts.
     */
    public void fillCarts(Tower selectedTower){
        for (int cartIndex = 0; cartIndex < cartFillProgressBars.size(); cartIndex++) {
            Cart cart = cartList.get(cartIndex);
            if (Objects.equals(cart.getResourceType(), selectedTower.getFillType())) {
                cartFillProgressBars.get(cartIndex).setProgress(cart.getCurrentFillAmount());
                cartSizeLabels.get(cartIndex).setText("Capacity: "+cart.getCurrentFillDisplay()+"/"+cart.getCapacity());
            }
        }
    }
    /**
     * Updates the distances traveled by carts on the track.
     */
    public void updateCartDistances(){
        for (int cartIndex = 0; cartIndex < cartProgressBars.size(); cartIndex++) {
            cartProgressBars.get(cartIndex).setProgress(cartList.get(cartIndex).getDistanceTravelled());
        }
    }
    /**
     * Executes a random event during the round.
     * @param eventName The name of the random event.
     * @param eventText The text describing the event.
     */
    public void executeRandomEvent(String eventName, String eventText) {
        if (Objects.equals(eventName, "Cart Reset")) {
            int cartToReset = randomEvent.generateRoundOneIndex();
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
            int cartToFill = randomEvent.generateRoundOneIndex();
            Cart cart = cartList.get(cartToFill);
            if (cart.isFull()) {
                eventFrameLabel.setText("Nothing Happened");
                eventFrameLabel.setStyle("-fx-text-fill: black");
            } else {
                cart.increaseFillAmount(1000);
                eventFrameLabel.setText(eventText);
                eventFrameLabel.setStyle("-fx-text-fill: green");
            }
            cartFillProgressBars.get(cartToFill).setProgress(cart.getCurrentFillAmount());
            cartSizeLabels.get(cartToFill).setText("Capacity: "+cart.getCurrentFillDisplay()+"/"+cart.getCapacity());
        }
        else if (Objects.equals(eventName, "Nothing")){
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: black");
        }
        else if (Objects.equals(eventName, "Steal Resources")){
            for (int cartIndex = 0; cartIndex < cartFillProgressBars.size(); cartIndex++) {
                Cart cart = cartList.get(cartIndex);
                if (!cart.isFull()) {
                    cart.increaseFillAmount(-20);
                    cartFillProgressBars.get(cartIndex).setProgress(cart.getCurrentFillAmount());
                    cartSizeLabels.get(cartIndex).setText("Capacity: "+cart.getCurrentFillDisplay()+"/"+cart.getCapacity());
                }
            }
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: red");
        }
        else if (Objects.equals(eventName, "Disable Tower")) {
            int towerToDisable = randomEvent.generateRoundOneIndex();
            towerList[towerToDisable].use();
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: red");
            updateSelectedTowerStats(towerList[towerToDisable]);
        }
        else if (Objects.equals(eventName, "Actions Reset")) {
            roundOne.resetActions();
            eventFrameLabel.setText(eventText);
            eventFrameLabel.setStyle("-fx-text-fill: red");
        }
    }
    /**
     * Handles the action when the confirm button is clicked.
     * Validates the action and updates the UI accordingly.
     */
    @FXML
    private void onConfirmAction() {
        if (roundOne.getActionsLeft() == 0) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("No actions left this frame!!"); }
        else if (selectedTowerIndex != -1) {
            Tower selectedTower = towerList[selectedTowerIndex];
            if (selectedTower.isUsable()) {
                if (roundOne.isCartFillable(cartList, selectedTower)) {
                roundOne.useAction(selectedTower,cartList,towerList);
                    if (selectedTower.getBroken() && !cartList.get(selectedTowerIndex).isFull()) {
                        towerButtons.get(selectedTowerIndex).setStyle("-fx-background-color: black; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                        confirmActionButton.setDisable(true);
                        for (Button towerButton: towerButtons){
                            towerButton.setDisable(true);
                        }
                        fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                        fillCartWithTowerLabel.setText("Round Lost!!");
                        nextFrameButton.setText("View Summary");
                        lost = true;
                    }
                fillCarts(selectedTower);
                updateSelectedTowerStats(selectedTower);
                actionsLeftLabel.setText("Actions Left This Frame: "+roundOne.getActionsLeft());
                } else {
                    fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                    fillCartWithTowerLabel.setText("All the "+selectedTower.getFillType()+" Carts are full!");}
            }
            else {
                fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                fillCartWithTowerLabel.setText("This Tower is currently reloading!");}
        }
        else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please select a Tower!");}
        this.updateTowerColours();
    }
    /**
     * Handles the action when the confirm next button is clicked.
     * Proceeds to the next frame of the round and updates the UI.
     */
    @FXML
    private void onConfirmNext() {
        if (selectedTowerIndex == -1) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please select a Tower!");
        }
        else {
        if (lost) {
            roundOneGameScreenManager.openLosingScreen();
        }
        else {
        roundOne.nextFrame(cartList, towerList);
        if (roundOne.roundEnded(cartList)) {
            if (roundOne.roundWon(cartList)){
                confirmActionButton.setDisable(true);
                cartButtons.get(0).setStyle("-fx-background-color: black; -fx-background-radius: 5;");
                cartButtons.get(1).setStyle("-fx-background-color: silver; -fx-background-radius: 5;");
                cartButtons.get(2).setStyle("-fx-background-color: gold; -fx-background-radius: 5;");
                for (Button towerButton: towerButtons){
                    towerButton.setDisable(true);
                }
                fillCartWithTowerLabel.setStyle("-fx-text-fill: green");
                fillCartWithTowerLabel.setText("Round Won !!");
                nextFrameButton.setText("To next round!");
                nextFrameButton.setOnAction(event -> onConfirm());
            }
            else {
                updateCartDistances();
                confirmActionButton.setDisable(true);
                for (Button towerButton: towerButtons){
                    towerButton.setDisable(true);
                }
                fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                fillCartWithTowerLabel.setText("Round Lost !!");
                nextFrameButton.setText("View Summary");
                lost = true;
            }
        }
        else {
            randomEvent.generateRandomEvent(roundOneGameScreenManager.getDifficulty());
            executeRandomEvent(randomEvent.getEventName(),randomEvent.getEventText());
            updateCartDistances();
            updateSelectedTowerStats(towerList[selectedTowerIndex]);
            actionsLeftLabel.setText("Actions Left This Frame: " + roundOne.getActionsLeft());
        }
        }
    }
        this.updateTowerColours();
    }
    /**
     * Handles the action when the confirm button is clicked.
     * Saves the selected tower list and closes the game screen.
     */
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.setRoundOneSelectedTowerList(towerList);
        roundOneGameScreenManager.closeGameScreen();
    }
}


