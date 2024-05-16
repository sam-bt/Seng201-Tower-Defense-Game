package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;

public class GameScreenController {
    GameManager roundGameManager;
    @FXML private Button nextRoundButton;
//    @FXML private Label cartOneTravel;
//    @FXML private Label cartTwoTravel;
//    @FXML private Label cartThreeTravel;
//    @FXML private Label cartFourTravel;
//    @FXML private Label cartFiveTravel;


    public GameScreenController(GameManager tempRoundGameManager){
        roundGameManager = tempRoundGameManager;
    }

    @FXML
    private void gameOnConfirm() {
        roundGameManager.closeGameScreen();
    }
}
