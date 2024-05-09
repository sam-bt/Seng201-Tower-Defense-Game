package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import seng201.team0.GameManager;
import seng201.team0.models.Setup;

/**
 *
 * This class is the controller for the setup screen (the screen opened when the app is initialized)
 *
 */

public class SetupScreenController {
    private GameManager setupGameManager;
    @FXML
    private TextField playerName;
    @FXML private Button setupAccept;
    @FXML private Slider numRoundsSlider;
    @FXML private Slider difficultySlider;

    /**
     *
     * Sole constructor that initialises a game manager instance
     *
     */

    public SetupScreenController(GameManager tempSetupGameManager){
            setupGameManager = tempSetupGameManager;
    }

    /**
     *
     * Method that calls the GameManager setSetup method with a
     *
     */

    @FXML
    private void onConfirm() {
        Long numRoundsValue = Math.round(numRoundsSlider.getValue());
        Long difficultyValue = Math.round(numRoundsSlider.getValue());
        String playerText = playerName.getText();
        Setup setup = new Setup(playerText,numRoundsValue,difficultyValue);
        setupGameManager.setSetup(setup);
        setupGameManager.closeSetupScreen();
    }
}
