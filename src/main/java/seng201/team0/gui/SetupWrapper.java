package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import seng201.team0.GameManager;

import java.io.IOException;

/**
 * Wrapper class for managing the setup of different screens in the game GUI.
 * Responsible for loading and displaying different screens based on game events.
 */
public class SetupWrapper {
    @FXML
    private BorderPane borderpane;

    /**
     * Stage for the application window.
     */
    private Stage stage;

    /**
     * Initializes the SetupWrapper with the specified Stage.
     * @param stage The Stage for the application window.
     */
    public void init(Stage stage) {
        this.stage = stage;
        new GameManager(this::launchSetupScreen, this::launchBetweenRoundsScreen, this::launchGameScreen,this::launchInventoryScreen,this::launchShopScreen,this::launchRoundOneInventoryScreen,this::launchRoundOneGameScreen,this::launchErrorScreen,this::launchFinishedScreen,this::launchLoseScreen,this::clearPane);
    }
    /**
     * Clears the content of the BorderPane.
     * FIXME - Change/delete as now not needed.
     */
    public void clearPane() { // TODO - change/delete as now not needed
        borderpane.getChildren().removeAll(borderpane.getChildren());
    }

    /**
     * Launches the setup screen.
     * @param setupGameManager The GameManager instance managing the game.
     */
    public void launchSetupScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new SetupScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Setup Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the between rounds screen.
     * @param setupGameManager The GameManager instance managing the game.
     */
    public void launchBetweenRoundsScreen(GameManager setupGameManager) {
        try {
            FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/between_rounds_screen.fxml"));
            mainScreenLoader.setControllerFactory(param -> new BetweenRoundsScreenController(setupGameManager));
            Parent setupParent  = mainScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Between Rounds Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Launches the game screen.
     * @param launchGameManager The GameManager instance managing the game.
     */
    public void launchGameScreen(GameManager launchGameManager) {
        try {
            FXMLLoader gameScreenLoader = new FXMLLoader(getClass().getResource("/fxml/game_screen.fxml"));
            gameScreenLoader.setControllerFactory(param -> new GameScreenController(launchGameManager));
            Parent setupParent  = gameScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Game Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the round one inventory screen.
     * @param roundOneInventoryGameManager The GameManager instance managing the game.
     */
    public void launchRoundOneInventoryScreen(GameManager roundOneInventoryGameManager) {
        try {
            FXMLLoader roundOneInventoryScreenLoader = new FXMLLoader(getClass().getResource("/fxml/round_one_inventory_screen.fxml"));
            roundOneInventoryScreenLoader.setControllerFactory(param -> new RoundOneInventoryScreenController(roundOneInventoryGameManager));
            Parent setupParent  = roundOneInventoryScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round 1 Inventory Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the shop screen.
     * @param shopScreenGameManager The GameManager instance managing the game.
     */
    public void launchShopScreen(GameManager shopScreenGameManager) {
        try {
            FXMLLoader shopScreenLoader = new FXMLLoader(getClass().getResource("/fxml/shop_screen.fxml"));
            shopScreenLoader.setControllerFactory(param -> new ShopScreenController(shopScreenGameManager));
            Parent setupParent  = shopScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Shop Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the inventory screen.
     * @param inventoryScreenGameManager The GameManager instance managing the game.
     */
    public void launchInventoryScreen(GameManager inventoryScreenGameManager) {
        try {
            FXMLLoader inventoryScreenLoader = new FXMLLoader(getClass().getResource("/fxml/inventory_screen.fxml"));
            inventoryScreenLoader.setControllerFactory(param -> new InventoryScreenController(inventoryScreenGameManager));
            Parent setupParent  = inventoryScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round Inventory Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the round one game screen.
     * @param roundOneGameManager The GameManager instance managing the game.
     */
    public void launchRoundOneGameScreen(GameManager roundOneGameManager) {
        try {
            FXMLLoader roundOneGameScreenLoader = new FXMLLoader(getClass().getResource("/fxml/round_one_game_screen.fxml"));
            roundOneGameScreenLoader.setControllerFactory(param -> new RoundOneGameScreenController(roundOneGameManager));
            Parent setupParent  = roundOneGameScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Round 1 Game Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the error screen.
     * @param errorScreenGameManager The GameManager instance managing the game.
     */
    public void launchErrorScreen(GameManager errorScreenGameManager) {
        try {
            FXMLLoader errorScreenLoader = new FXMLLoader(getClass().getResource("/fxml/error_screen.fxml"));
            errorScreenLoader.setControllerFactory(param -> new InvalidNameScreenController(errorScreenGameManager));
            Parent setupParent  = errorScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Error Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the finished screen.
     * @param finishedScreenGameManager The GameManager instance managing the game.
     */
    public void launchFinishedScreen(GameManager finishedScreenGameManager) {
        try {
            FXMLLoader finishedScreenLoader = new FXMLLoader(getClass().getResource("/fxml/winning_screen.fxml"));
            finishedScreenLoader.setControllerFactory(param -> new WinningScreenController(finishedScreenGameManager));
            Parent setupParent  = finishedScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Winning Screen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Launches the lose screen.
     * @param loseScreenGameManager The GameManager instance managing the game.
     */
    public void launchLoseScreen(GameManager loseScreenGameManager) {
        try {
            FXMLLoader losingScreenLoader = new FXMLLoader(getClass().getResource("/fxml/losing_screen.fxml"));
            losingScreenLoader.setControllerFactory(param -> new LosingScreenController(loseScreenGameManager));
            Parent setupParent  = losingScreenLoader.load();
            borderpane.setCenter(setupParent);
            stage.setTitle("Losing Screen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
