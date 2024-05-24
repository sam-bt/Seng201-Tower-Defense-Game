package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seng201.team0.GameManager;

/**
 * Controller class for the winning screen in the game GUI.
 * Responsible for displaying information about the completed game, such as rounds completed, points, money, and difficulty level.
 */
public class WinningScreenController {
    GameManager winningScreenGameManager;
    @FXML
    private Label roundsCompletedLabel;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label moneyLabel;

    /**
     * Constructor for the WinningScreenController game manager.
     *
     * @param tempWinningScreenGameManager The GameManager instance managing the game.
     */
    public WinningScreenController(GameManager tempWinningScreenGameManager) {
        winningScreenGameManager = tempWinningScreenGameManager;
    }

    /**
     * Initializes the winning screen with the relevant game information.
     * Sets the text of labels to display game statistics.
     */
    public void initialize() {
        roundsCompletedLabel.setText("You completed " + (winningScreenGameManager.getCurrRound() - 1) + "/" + winningScreenGameManager.getRounds() + " Rounds!");
        moneyLabel.setText("You won with $" + winningScreenGameManager.getMoneyAmount() + " left!");
        pointsLabel.setText("You had " + winningScreenGameManager.getPoints() + " Points!");
        difficultyLabel.setText("You won on difficulty " + winningScreenGameManager.getDifficulty() + "!");
    }

    /**
     * Exits the application when the button is clicked.
     */
    public void onQuit() {
        System.exit(0);
    }
}
