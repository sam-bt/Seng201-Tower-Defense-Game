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
        new GameManager(this::launchSetupScreen, this::launchMainScreen, this::clearPane);
    }

    public void clearPane() {
        pane.getChildren().removeAll(pane.getChildren());
    }

    public void launchSetupScreen(GameManager setupScreenManager) {
        try {
            FXMLLoader setupScreenLoader = new FXMLLoader(getClass().getResource("/fxml/setup_screen.fxml"));
            setupScreenLoader.setControllerFactory(param -> new SetupScreenController(setupScreenManager));
            Parent setupParent  = setupScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Setup Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void launchMainScreen(RocketManager rocketManager) {
//        System.out.println("Main screen would launch here.");
//        // For now, do nothing or just print a message.
//    }

    public void launchMainScreen(GameManager setupScreenManager) {
        try {
            FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("/fxml/main_screen.fxml"));
//            mainScreenLoader.setControllerFactory(param -> new MainScreenController(rocketManager));
            Parent setupParent  = mainScreenLoader.load();
            pane.getChildren().add(setupParent);
            stage.setTitle("Rocket Manager Main Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
