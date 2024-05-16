package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class InventoryScreenController {



    @FXML
    private Button coalType1Button;

    @FXML
    private Button coalType2Button;

    @FXML
    private Button gemType1Button;

    @FXML
    private Button gemType2Button;

    @FXML
    private Button goldType1Button;

    @FXML
    private Button goldType2Button;

    @FXML
    private Button inventorySlot1Button;

    @FXML
    private Button inventorySlot2Button;

    @FXML
    private Button inventorySlot3Button;

    @FXML
    private Button inventorySlot4Button;

    @FXML
    private Button inventorySlot5Button;

    @FXML
    private Button inventoryToMenuButton;

    @FXML
    private Button inventoryToShopButton;

    @FXML
    private Button ironType1Button;

    @FXML
    private Button ironType2Button;

    @FXML
    private Button useHealButton;

    @FXML
    private Button useReviveButton;

    @FXML
    private Button useUpgradeButton;
    private GameManager inventoryScreenGameManager;

    public InventoryScreenController(GameManager tempInventoryScreenGameManager) {
        inventoryScreenGameManager = tempInventoryScreenGameManager;
    }

    @FXML
    private void onMenu() {
        inventoryScreenGameManager.launchBetweenRoundsScreen();
    }

    @FXML
    private void onShop() {
        inventoryScreenGameManager.openShopScreen();
    }

    @FXML
    void onUseHeal() {

    } //TODO implement

    @FXML
    void onUseRevive() {

    } //TODO implement

    @FXML
    void onUseUpgrade() {

    } //TODO implement
}




