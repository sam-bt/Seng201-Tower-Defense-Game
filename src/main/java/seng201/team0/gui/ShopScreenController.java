package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.ShopService;

import java.util.List;

public class ShopScreenController {

    @FXML
    private Button buyButton;

    @FXML
    private Button coalTower1ShopButton;

    @FXML
    private Button coalTower2ShopButton;

    @FXML
    private Button gemTower1ShopButton;

    @FXML
    private Button gemTower2ShopButton;

    @FXML
    private Button goldTower1ShopButton;

    @FXML
    private Button goldTower2ShopButton;

    @FXML
    private Button ironTower1ShopButton;

    @FXML
    private Button ironTower2ShopButton;

    @FXML
    private Button sellButton;

    @FXML
    private Button shopToInventoryButton;

    @FXML
    private Button shopToMenuButton;

    @FXML
    private Button towerHealShopButton;

    @FXML
    private Button towerReviveShopButton;

    @FXML
    private Button towerUpgradeShopButton;
    private GameManager shopScreenGameManager;

    private ShopService shopService;
    private int selectedTowerIndex = -1;

    public ShopScreenController(GameManager tempShopScreenGameManager) {
        shopScreenGameManager = tempShopScreenGameManager;
    }

//    public void initialize() {
//        List<Button> availableTowerButtons = List.of(coalTower1ShopButton, coalTower2ShopButton, ironTower1ShopButton, ironTower2ShopButton, goldTower1ShopButton, goldTower2ShopButton, gemTower1ShopButton, gemTower2ShopButton);
//        shopService = new ShopService(shopScreenGameManager);
//
//        for (int i = 0; i < availableTowerButtons.size(); i++) {
//            int finalI = i;
//            availableTowerButtons.get(i).setOnAction(event -> {
//                if (selectedTowerIndex == finalI) {
//                    resetTowerSelection();
//                } else {
//                    updateDisplayedStats(towers.get(finalI));
//                    selectedTowerIndex = finalI;
//                    selectedItem = null;
//                    resetItemButtonStyles();
//                    availableTowerButtons.forEach(button -> {
//                    });
//                }
//            });
//        }
//    }

//    private void resetTowerSelection() {
//        selectedTowerIndex = -1;
//        resetTowerButtonStyles();
//    }
//    private void resetItemButtonStyles() {
//        useHealButton.setStyle("");
//        useReviveButton.setStyle("");
//        useUpgradeButton.setStyle("");
//    }
//
//    private void resetTowerButtonStyles() {
//        List<Button> availableTowerButtons = List.of(coalTower1ShopButton, coalTower2ShopButton, ironTower1ShopButton, ironTower2ShopButton, goldTower1ShopButton, goldTower2ShopButton, gemTower1ShopButton, gemTower2ShopButton);
//        List<Tower> towers = currentInventory.getTowerList();
//        for (int i = 0; i < availableTowerButtons.size(); i++) {
//            if (towers.get(i).getOwned() == true) {
//                availableTowerButtons.get(i).setStyle("");
//            }
//        }
//    }

    @FXML
    private void onInventory() {
        shopScreenGameManager.launchInventoryScreen();
    }

    @FXML
    private void onMenu() {
        shopScreenGameManager.launchBetweenRoundsScreen();
    }

    @FXML
    private void onSell() {

    }
    @FXML
    private void onBuy() {

    }

}
