package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.GameManager;

/**
 * Controller class for the InvalidNameScreen.
 * Handles actions and interactions on the screen where an invalid name is entered.
 */
public class InvalidNameScreenController {


    /**
     * Instance of the game manager.
     */
    private GameManager invalidNameGameManager;

    /**
     * Constructor for the InvalidNameScreenController class.
     *
     * @param tempInvalidNameGameManager The game manager instance associated with the screen.
     */
    public InvalidNameScreenController(final GameManager tempInvalidNameGameManager) {
        invalidNameGameManager = tempInvalidNameGameManager;
    }

    /**
     * Closes the screen invalid name screen, Launches setup screen.
     */
    @FXML
    private void invalidNameOnConfirm() {
        invalidNameGameManager.closeInvalidNameScreen();
    }
}
