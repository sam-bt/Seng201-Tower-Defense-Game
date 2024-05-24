package seng201.team0.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class starts the javaFX application window
 *
 * @author seng202 teaching team
 */
public class SetupWindow extends Application {
    /**
     * Opens the gui with the fxml content specified in resources/fxml/main.fxml
     *
     * @param primaryStage The current fxml stage, handled by javaFX Application class
     * @throws IOException if there is an issue loading fxml file
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader baseLoader = new FXMLLoader(getClass().getResource("/fxml/fx_wrapper.fxml"));
        Parent root = baseLoader.load();
        SetupWrapper setupWrapper = baseLoader.getController();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Setup Wrapper");
        primaryStage.setScene(scene);
        primaryStage.show();
        setupWrapper.init(primaryStage);
    }

    /**
     * Launches the FXML application, this must be called from another class (in this cass App.java) otherwise JavaFX
     * errors out and does not run
     *
     * @param args command line arguments
     */
    public static void launchWrapper(String[] args) {
        launch(args);
    }

}