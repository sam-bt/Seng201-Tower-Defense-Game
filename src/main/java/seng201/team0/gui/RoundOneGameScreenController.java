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
    private boolean fillable = false;

    GameManager roundOneGameScreenManager;

    public RoundOneGameScreenController(GameManager tempRoundOneGameScreenManager){
        roundOneGameScreenManager = tempRoundOneGameScreenManager;
    }
    public void initialize() {
        RoundOne roundOne = new RoundOne(roundOneGameScreenManager.getMoneyService(), roundOneGameScreenManager.getPoints(), roundOneGameScreenManager.getDifficultyService(), roundOneGameScreenManager.getRoundTrackLength());
        towerList = roundOneGameScreenManager.getRoundOneSelectedTowerList();
        cartList = List.of(roundOne.getCoalCart(), roundOne.getIronCart(), roundOne.getGoldCart());
        List<Button> towerButtons = List.of(towerOneButton,towerTwoButton,towerThreeButton);
        List<Button> cartButtons = List.of(cartOneButton,cartTwoButton,cartThreeButton);

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
        trackLengthLabel.setText("Track Length: "+roundOneGameScreenManager.getRoundTrackLength());
        towerOneButton.setText(towerList[0].getTowerName());
        towerTwoButton.setText(towerList[1].getTowerName());
        towerThreeButton.setText(towerList[2].getTowerName());

        for (int i = 0; i < towerButtons.size(); i++) {
            int finalI = i;
            towerButtons.get(i).setOnAction(event -> {
                selectedTowerIndex = finalI;
                if (selectedCartIndex != -1) {updateSelectedCartStats();}
                //TODO check if the cart and tower types match
                updateDisplayedStats(towerList[finalI]);
                towerButtons.forEach(button -> {
                    if (button == towerButtons.get(finalI)) {
                        button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                    } else {
                        button.setStyle("");
                    }
                });
            });
        }
        for (int i = 0; i < cartButtons.size(); i++) {
            int finalI = i;
            cartButtons.get(i).setOnAction(event -> {
                selectedCartIndex = finalI;
                if (selectedTowerIndex == -1) {}
                //TODO check if the cart and tower types match
                else {
                    updateSelectedCartStats();
                    cartButtons.forEach(button -> {
                        if (button == cartButtons.get(finalI)) {
                            button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                        } else {
                            button.setStyle("");
                        }
                    });
                }});
        }
    }

    public void updateDisplayedStats(Tower tower) {
        fillAmountLabel.setText("Fill Amount: "+tower.getFillAmount());
        reloadSpeedLabel.setText("Frames until next fill: "+tower.getReloadSpeed());
    }
    public void updateSelectedCartStats() {
        if (Objects.equals(cartList.get(selectedCartIndex).getResourceType(), towerList[selectedTowerIndex].getFillType())) {
            fillable = true;
            fillCartWithTowerLabel.setStyle("-fx-text-fill: black");
        fillCartWithTowerLabel.setText("Fill "+cartList.get(selectedCartIndex).getResourceType()+" Cart with "+towerList[selectedTowerIndex].getTowerName()+"?");}
        else {
            fillable = false;
            fillCartWithTowerLabel.setStyle("-fx-text-fill: red");
            fillCartWithTowerLabel.setText("Cannot fill " +cartList.get(selectedCartIndex).getResourceType()+" Cart with "+towerList[selectedTowerIndex].getTowerName()+"!!");}
    }
    @FXML
    private void onConfirmAction() {
    }
    @FXML
    private void onConfirmNext() {}
    @FXML
    private void onConfirm() {
        roundOneGameScreenManager.closeGameScreen();
    }
}

