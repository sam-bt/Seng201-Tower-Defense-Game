package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

/**
 * Controller class for the LosingScreen.fxml file.
 * Handles actions and interactions on the screen displayed when the player loses the game.
 */
public class LosingScreenController {

    @FXML
    private Label roundsCompletedLabel;

    @FXML
    private Label difficultyLabel;

    @FXML
    private Label pointsLabel;

    /**
     * Game manager for the losing screen.
     */
    GameManager losingScreenGameManager;

    /**
     * Constructor for the LosingScreenController class.
     * @param tempLosingScreenGameManager The game manager instance associated with the losing screen.
     */
    public LosingScreenController(GameManager tempLosingScreenGameManager) {
        losingScreenGameManager = tempLosingScreenGameManager;
    }

    /**
     * Initializes the losing screen with relevant information such as rounds completed, points earned, and difficulty level.
     */
    public void initialize() {
        roundsCompletedLabel.setText("You completed " + (losingScreenGameManager.getCurrRound() - 2) + "/" + losingScreenGameManager.getRounds() + " Rounds!");
        pointsLabel.setText("You had " + losingScreenGameManager.getPoints() + " Points!");
        difficultyLabel.setText("You lost on difficulty " + losingScreenGameManager.getDifficulty() + "!");
    }

    /**
     * Event handler for quitting the game.
     * Exits the application when called.
     */
    public void onQuit() {
        System.exit(0);
    }
}
