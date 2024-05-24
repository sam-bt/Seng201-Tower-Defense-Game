package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import seng201.team0.GameManager;
import seng201.team0.models.Setup;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

/**
 * This class is the controller for the setup screen (the screen opened when the app is initialized)
 */

public class SetupScreenController {
    private GameManager setupGameManager;
    @FXML
    private TextField playerName;
    @FXML
    private Slider numRoundsSlider;
    @FXML
    private Slider difficultySlider;

    /**
     * Sole constructor that sets the GameManager instance
     */

    public SetupScreenController(GameManager tempSetupGameManager) {
        setupGameManager = tempSetupGameManager;
    }


    /**
     * Method that calls the GameManager setSetup method with a setup object containing the setup info
     * Also calls setCurrRound to set the current round to 0
     */

    @FXML
    private void onConfirm() {
        Long numRoundsValue = Math.round(numRoundsSlider.getValue());
        double difficultyValue = Math.round(difficultySlider.getValue());
        String playerText = playerName.getText();
        Setup setup = new Setup(playerText, numRoundsValue);
        setupGameManager.startPoints();
        setupGameManager.setCurrRound();
        setupGameManager.setMoney(new MoneyService());
        setupGameManager.setDifficulty(new DifficultyService(difficultyValue));
        setupGameManager.setSetup(setup);
        setupGameManager.closeSetupScreen();
    }
}
