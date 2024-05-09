package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng201.team0.GameManager;

import java.io.IOException;

public class SetupWrapper {
    @FXML
    private Pane pane;

    private Stage stage;


    public void init(Stage stage) {
        this.stage = stage;
        new GameManager(this::launchSetupScreen, this::launchBetweenRoundsScreen, this::launchGameScreen,this::clearPane);
    }

    public void clearPane() {
        pane.getChildren().removeAll(pane.getChildren());
    }

    public void launchSetupScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new SetupScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Setup Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchBetweenRoundsScreen(GameManager setupGameManager) {
        try {
            FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/between_rounds_screen.fxml"));
            mainScreenLoader.setControllerFactory(param -> new BetweenRoundsScreenController(setupGameManager));
            Parent setupParent  = mainScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Between Rounds Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void launchGameScreen(GameManager setupGameManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/game_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new GameScreenController(setupGameManager));
            Parent setupParent  = setupScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Game Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
