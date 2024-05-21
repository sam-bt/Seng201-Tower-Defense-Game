package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;
import seng201.team0.models.Cart;
import seng201.team0.models.RoundOne;
import seng201.team0.models.Tower;

import java.util.List;
import java.util.Objects;

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
    @FXML private Label cartOneName;
    @FXML private Label cartTwoName;
    @FXML private Label cartThreeName;
    @FXML private Label cartOneSpeed;
    @FXML private Label cartTwoSpeed;
    @FXML private Label cartThreeSpeed;
    @FXML private Label cartOneSize;
    @FXML private Label cartTwoSize;
    @FXML private Label cartThreeSize;
    @FXML private Label eventFrameLabel;
    @FXML private Label fillAmountLabel;
    @FXML private Label reloadSpeedLabel;
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
    private Tower[] towerList;
    private List<Cart> cartList;
    private int selectedTowerIndex = -1;
    private int selectedCartIndex = -1;
    List<Button> towerButtons;
    List<Button> cartButtons;
    List<ProgressBar> cartFillProgressBars;
    List<ProgressBar> cartProgressBars;
    RoundOne roundOne;


    GameManager roundOneGameScreenManager;

    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    public void initialize() {
        roundOne = new RoundOne(roundOneGameScreenManager.getMoneyService(), roundOneGameScreenManager.getPoints(), roundOneGameScreenManager.getDifficultyService(), roundOneGameScreenManager.getRoundTrackLength());
        towerList = roundOneGameScreenManager.getRoundOneSelectedTowerList();
        cartList = List.of(roundOne.getCoalCart(), roundOne.getIronCart(), roundOne.getGoldCart());
        towerButtons = List.of(towerOneButton,towerTwoButton,towerThreeButton);
        cartButtons = List.of(cartOneButton,cartTwoButton,cartThreeButton);
        cartFillProgressBars = List.of(cartOneFillProgressBar,cartTwoFillProgressBar,cartThreeFillProgressBar);
        cartProgressBars = List.of(cartOneTravelProgressBar,cartTwoTravelProgressBar,cartThreeTravelProgressBar);

        cartOneName.setText("Cart: "+cartList.get(0).getCartName());
        cartTwoName.setText("Cart: "+cartList.get(1).getCartName());
        cartThreeName.setText("Cart: "+cartList.get(2).getCartName());
        cartOneSpeed.setText("Speed: "+cartList.get(0).getSpeed()+" m/s");
        cartTwoSpeed.setText("Speed: "+cartList.get(1).getSpeed()+" m/s");
        cartThreeSpeed.setText("Speed: "+cartList.get(2).getSpeed()+" m/s");
        cartOneSize.setText("Capacity: "+cartList.get(0).getCapacity()+" kg");
        cartTwoSize.setText("Capacity: "+cartList.get(1).getCapacity()+" kg");
        cartThreeSize.setText("Capacity: "+cartList.get(2).getCapacity()+" kg");
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
        nameAndRoundLabel.setText("Name: "+roundOneGameScreenManager.getName()+"   Round: "+roundOneGameScreenManager.getRounds());
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
                    int buttonIndex = towerButtons.indexOf(button); //TODO update tower stats on next action/frame to update the colours
                    if (button == towerButtons.get(finalI) && towerList[finalI].isUsable()) {
                        button.setStyle("-fx-background-color: #99FF99; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    } else if (towerList[buttonIndex].isUsable()) {
                        button.setStyle("-fx-background-color: #D1FFBD; -fx-background-radius: 5; -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 1;");
                    }
                    else {button.setStyle("");}
                });
            });
        }
    }

    public void updateSelectedTowerStats(Tower tower) {
        fillAmountLabel.setText("Fill Amount: "+tower.getFillAmount());
        if (tower.getActionsUntilUsable() == 0) {
            reloadSpeedLabel.setText("Tower is usable!");
            fillCartWithTowerLabel.setStyle("-fx-text-fill: black");
            fillCartWithTowerLabel.setText("Fill all "+tower.getFillType()+ " carts?");
        }
        else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("This Tower is currently reloading!");
            reloadSpeedLabel.setText("Actions until next usable: "+tower.getActionsUntilUsable());}
    }
    public void updateSelectedCartStats() {
        if (Objects.equals(cartList.get(selectedCartIndex).getResourceType(), towerList[selectedTowerIndex].getFillType())) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: black");
            fillCartWithTowerLabel.setText("Fill "+cartList.get(selectedCartIndex).getResourceType()+" Cart with "+towerList[selectedTowerIndex].getTowerName()+"?");}
        else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Cannot fill " +cartList.get(selectedCartIndex).getResourceType()+" Cart with "+towerList[selectedTowerIndex].getTowerName()+"!!");}
    }
    public void fillCarts(){
        for (int cartIndex = 0; cartIndex < cartFillProgressBars.size(); cartIndex++) {
            Cart cart = cartList.get(cartIndex);
            cartFillProgressBars.get(cartIndex).setProgress(cart.getCurrentFillAmount());
        }
    }
    public void updateCartDistances(){
        for (int cartIndex = 0; cartIndex < cartProgressBars.size(); cartIndex++) {
            cartProgressBars.get(cartIndex).setProgress(cartList.get(cartIndex).getDistanceTravelled()); //TODO update for carts at random indices and special cart for actual game
        }
    }
    @FXML
    private void onConfirmAction() {
        if (roundOne.getActionsLeft() == 0) {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("No actions left this frame!!"); }
        else if (selectedTowerIndex != -1) {
            Tower selectedTower = towerList[selectedTowerIndex];
            if (selectedTower.isUsable()) {
                roundOne.useAction(selectedTower,cartList,towerList);
                fillCarts();
                updateSelectedTowerStats(selectedTower);
                actionsLeftLabel.setText("Actions Left This Frame: "+roundOne.getActionsLeft());
            }
            else {
                fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
                fillCartWithTowerLabel.setText("This Tower is currently reloading!");}
        }
        else {
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please select a Tower!");}
    }
    @FXML
    private void onConfirmNext() {
        if (roundOne.roundEnded(cartList)) {
            if (roundOne.roundWon(cartList)){
                System.out.println("round WONNNN"); //TODO make this do something, (maybe check after action executed not before)
            }
            else {
                System.out.println("round LOSTTTT LOSERRR");
            }
        }
        else {
            if (roundOne.getActionsLeft() == roundOne.getNumActions()) { //TODO do something about this
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Please Use an Action!!");} //TODO let them do what they want
        else {
        roundOne.nextFrame(cartList, towerList);
        updateCartDistances();
        actionsLeftLabel.setText("Actions Left This Frame: "+roundOne.getActionsLeft());
        }
        }
    }
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.closeGameScreen();
    }
}

