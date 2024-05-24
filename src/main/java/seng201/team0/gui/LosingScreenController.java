package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import seng201.team0.GameManager;

/**
 * Controller class for the losing screen.
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
     * Constructor for the losing screen controllers game manager.
     *
     * @param tempLosingScreenGameManager The game manager instance associated with the losing screen.
     */
    public LosingScreenController(GameManager tempLosingScreenGameManager) {
        losingScreenGameManager = tempLosingScreenGameManager;
    }

    /**
     * Initializes the losing screen with relevant information.
     */
    public void initialize() {
        roundsCompletedLabel.setText("You completed " + (losingScreenGameManager.getCurrRound() - 2) + "/" + losingScreenGameManager.getRounds() + " Rounds!");
        pointsLabel.setText("You had " + losingScreenGameManager.getPoints() + " Points!");
        difficultyLabel.setText("You lost on difficulty " + losingScreenGameManager.getDifficulty() + "!");
    }

    /**
     * Exits the application.
     */
    public void onQuit() {
        System.exit(0);
    }
}
