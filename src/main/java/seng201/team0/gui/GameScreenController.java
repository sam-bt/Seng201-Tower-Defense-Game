package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;
import seng201.team0.models.Cart;
import seng201.team0.models.Round;
import seng201.team0.models.RoundOne;
import seng201.team0.models.Tower;
import seng201.team0.services.TowerGenerator;

import java.util.List;

public class GameScreenController {
    GameManager roundGameManager;
    @FXML private Button nextRoundButton;
    @FXML private ProgressBar cartOneFillProgressBar;
    @FXML private ProgressBar cartTwoFillProgressBar;
    @FXML private ProgressBar cartThreeFillProgressBar;
    @FXML private ProgressBar cartFourFillProgressBar;
    @FXML private ProgressBar cartFiveFillProgressBar;
    @FXML private ProgressBar cartOneTravelProgressBar;
    @FXML private ProgressBar cartTwoTravelProgressBar;
    @FXML private ProgressBar cartThreeTravelProgressBar;
    @FXML private ProgressBar cartFourTravelProgressBar;
    @FXML private ProgressBar cartFiveTravelProgressBar;
    @FXML private Label nameAndRoundLabel;
    @FXML private Label moneyLabel;
    @FXML private Label pointsLabel;
    @FXML private Label difficultyLabel;
    @FXML private Label trackLengthLabel;
    @FXML private Label cartOneNameLabel;
    @FXML private Label cartTwoNameLabel;
    @FXML private Label cartThreeNameLabel;
    @FXML private Label cartFourNameLabel;
    @FXML private Label cartFiveNameLabel;
    @FXML private Label cartOneSpeedLabel;
    @FXML private Label cartTwoSpeedLabel;
    @FXML private Label cartThreeSpeedLabel;
    @FXML private Label cartFourSpeedLabel;
    @FXML private Label cartFiveSpeedLabel;
    @FXML private Label cartOneSizeLabel;
    @FXML private Label cartTwoSizeLabel;
    @FXML private Label cartThreeSizeLabel;
    @FXML private Label cartFourSizeLabel;
    @FXML private Label cartFiveSizeLabel;
    @FXML private Label eventFrameLabel;
    @FXML private Label fillAmountLabel;
    @FXML private Label reloadSpeedLabel;
    @FXML private Label towerHealthLabel;
    @FXML private Label actionsLeftLabel;
    @FXML private Label fillCartWithTowerLabel;
    @FXML private Button towerOneButton;
    @FXML private Button towerTwoButton;
    @FXML private Button towerThreeButton;
    @FXML private Button towerFourButton;
    @FXML private Button towerFiveButton;
    @FXML private Button cartOneButton;
    @FXML private Button cartTwoButton;
    @FXML private Button cartThreeButton;
    @FXML private Button cartFourButton;
    @FXML private Button cartFiveButton;
    @FXML private Button confirmActionButton;
    @FXML private Button nextFrameButton;
    private Round round;
    List<Cart> cartList;
    private Tower[] towerList = new Tower[5]; //FIXME for when finn finishes inventory
    List<Button> towerButtons;
    List<Button> cartButtons;
    List<ProgressBar> cartFillProgressBars;
    List<ProgressBar> cartProgressBars;
    List<Label> cartSizeLabels;

    public GameScreenController(GameManager tempRoundGameManager){
        roundGameManager = tempRoundGameManager;
    }
    public void initialize() {
        round = new Round(roundGameManager.getMoneyService(), roundGameManager.getPoints(), roundGameManager.getDifficultyService(), roundGameManager.getRoundTrackLength());
        cartList = List.of(round.getCoalCart(), round.getIronCart(), round.getGoldCart(), round.getGemCart(), round.getBonusCart());
        Tower[] tempTowerList = roundGameManager.getRoundOneSelectedTowerList();
        towerList[0] = tempTowerList[0];
        towerList[1] = tempTowerList[1];
        towerList[2] = tempTowerList[2];
        towerList[3] = new Tower(TowerGenerator.lightTowerHealthGenerator(),true, "Gem", TowerGenerator.lightTowerFillAmountGenerator(),  TowerGenerator.lightTowerReloadSpeedGenerator(), "Light Gem", roundGameManager.getDifficulty());
        towerList[4] = new Tower(TowerGenerator.heavyTowerHealthGenerator(),true, "Gem", TowerGenerator.heavyTowerFillAmountGenerator(),  TowerGenerator.heavyTowerReloadSpeedGenerator(), "Heavy Gem", roundGameManager.getDifficulty());

        towerButtons = List.of(towerOneButton,towerTwoButton,towerThreeButton,towerFourButton,towerFiveButton);
        cartButtons = List.of(cartOneButton,cartTwoButton,cartThreeButton,cartFourButton,cartFiveButton);
        cartSizeLabels = List.of(cartOneSizeLabel,cartTwoSizeLabel,cartThreeSizeLabel,cartFourSizeLabel,cartFiveSizeLabel);
        cartFillProgressBars = List.of(cartOneFillProgressBar,cartTwoFillProgressBar,cartThreeFillProgressBar,cartFourFillProgressBar,cartFiveFillProgressBar);
        cartProgressBars = List.of(cartOneTravelProgressBar,cartTwoTravelProgressBar,cartThreeTravelProgressBar,cartFourTravelProgressBar,cartFiveTravelProgressBar);

        cartOneNameLabel.setText("Cart: "+cartList.get(0).getCartName());
        cartTwoNameLabel.setText("Cart: "+cartList.get(1).getCartName());
        cartThreeNameLabel.setText("Cart: "+cartList.get(2).getCartName());
        cartFourNameLabel.setText("Cart: "+cartList.get(3).getCartName());
        cartFiveNameLabel.setText("Cart: "+cartList.get(4).getCartName());
        cartOneSpeedLabel.setText("Speed: "+cartList.get(0).getSpeed()+" m/s");
        cartTwoSpeedLabel.setText("Speed: "+cartList.get(1).getSpeed()+" m/s");
        cartThreeSpeedLabel.setText("Speed: "+cartList.get(2).getSpeed()+" m/s");
        cartFourSpeedLabel.setText("Speed: "+cartList.get(3).getSpeed()+" m/s");
        cartFiveSpeedLabel.setText("Speed: "+cartList.get(4).getSpeed()+" m/s");
        cartOneSizeLabel.setText("Capacity: 0/"+cartList.get(0).getCapacity()+" kg");
        cartTwoSizeLabel.setText("Capacity: 0/"+cartList.get(1).getCapacity()+" kg");
        cartThreeSizeLabel.setText("Capacity: 0/"+cartList.get(2).getCapacity()+" kg");
        cartFourSizeLabel.setText("Capacity: 0/"+cartList.get(2).getCapacity()+" kg");
        cartFiveSizeLabel.setText("Capacity: 0/"+cartList.get(2).getCapacity()+" kg");
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
        cartThreeFillProgressBar.setStyle("-fx-accent: blue");
        cartThreeFillProgressBar.setStyle("-fx-accent: green");
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
        nameAndRoundLabel.setText("Name: "+roundGameManager.getName()+"   Round: "+roundGameManager.getRounds());
        moneyLabel.setText("Money: "+roundGameManager.getMoneyAmount());
        difficultyLabel.setText("Difficulty: "+roundGameManager.getDifficulty());
        pointsLabel.setText("Points: "+roundGameManager.getPoints());
        trackLengthLabel.setText("Track Length: "+roundGameManager.getRoundTrackLength()+"m");
        actionsLeftLabel.setText("Actions Left: "+round.getActionsLeft());
        towerOneButton.setText(towerList[0].getTowerName());
        towerTwoButton.setText(towerList[1].getTowerName());
        towerThreeButton.setText(towerList[2].getTowerName());
        towerFourButton.setText(towerList[2].getTowerName());
        towerFiveButton.setText(towerList[2].getTowerName());
    }
    @FXML private void onConfirmNext(){

    }
    @FXML
    private void onConfirmAction() {

    }
    @FXML
    private void gameOnConfirm() {
        roundGameManager.closeGameScreen();
    }
}
