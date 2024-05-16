package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

public class InventoryScreenController {

    @FXML
    private Button inventorySlot1;

    @FXML
    private Button inventorySlot10;

    @FXML
    private Button inventorySlot2;

    @FXML
    private Button inventorySlot3;

    @FXML
    private Button inventorySlot4;

    @FXML
    private Button inventorySlot5;

    @FXML
    private Button inventorySlot6;

    @FXML
    private Button inventorySlot7;

    @FXML
    private Button inventorySlot8;

    @FXML
    private Button inventorySlot9;

    @FXML
    private Button inventoryToShopButton;

    @FXML
    private Button useHealButton;

    @FXML
    private Button useReviveButton;

    @FXML
    private Button useUpgradeButton;
    GameManager inventoryScreenGameManager;

    InventoryScreenController(GameManager tempInventoryScreenGameManager) {
        this.inventoryScreenGameManager = tempInventoryScreenGameManager;
    }
}




