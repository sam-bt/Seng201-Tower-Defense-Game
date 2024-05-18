package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.TowerService;

import java.util.List;

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
    @FXML
    private Label currTowerDamage;
    @FXML
    private Label currTowerHealth;
    @FXML
    private Label currTowerLevel;
    @FXML
    private Label UpgradesOwned;
    @FXML
    private Label healsOwned;
    @FXML
    private Label revivesOwned;

    private final Tower[] selectedTowers = new Tower[5];
    private int selectedTowerIndex = -1;

    GameManager inventoryScreenGameManager;

    public InventoryScreenController(GameManager tempInventoryScreenGameManager) {
        inventoryScreenGameManager = tempInventoryScreenGameManager;
    }

    public void initialize() {
        List<Button> towerSlotButtons = List.of(inventorySlot1Button, inventorySlot2Button, inventorySlot3Button, inventorySlot4Button, inventorySlot5Button);
        List<Button> availableTowerButtons = List.of(coalType1Button, coalType2Button, ironType1Button, ironType2Button, goldType1Button, goldType2Button, gemType1Button, gemType2Button);
        List<Button> availableItemButtons = List.of(useHealButton, useReviveButton, useUpgradeButton);
        InventoryService currentInventory = new InventoryService(inventoryScreenGameManager);
        List<Tower> towers = currentInventory.getTowerList();

//        for (int i = 0; i < availableTowerButtons.size(); i++) {
//            int finalI = i;
//            availableTowerButtons.get(i).setOnAction(event -> {
//                updateDisplayedStats(towers.get(finalI));
//                selectedTowerIndex = finalI;
//                availableTowerButtons.forEach(button -> {
//                    if (button == availableTowerButtons.get(finalI)) {
//                        button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
//                    } else {
//                        button.setStyle("");
//                    }
//                });
//            });
//        }
//        // Sets the action to add the selected tower to the selected tower slot (doesn't allow for repeats)
//        for (int i = 0; i < towerSlotButtons.size(); i++) {
//            int finalI = i;
//            towerSlotButtons.get(i).setOnAction(event -> {
//                if (selectedTowerIndex != -1) {
//                    if (!TowerService.isTowerAlreadySelected(selectedTowers, towers.get(selectedTowerIndex))) {
//                        towerSlotButtons.get(finalI).setText(towers.get(selectedTowerIndex).getTowerName());
//                        selectedTowers[finalI] = towers.get(selectedTowerIndex);
//                    }
//                }
//            });
//        }
//        List<Integer> towerListIndices = inventoryScreenGameManager.getRoundOneTowerListIndices();
//        Tower[] savedTowers = inventoryScreenGameManager.getRoundOneTowerList();
//        if (!towerListIndices.isEmpty()) {
//            for (int selectedTowerIndex : towerListIndices) {
//                towerSlotButtons.get(selectedTowerIndex).setText(savedTowers[selectedTowerIndex].getTowerName());
//                selectedTowers[selectedTowerIndex] = savedTowers[selectedTowerIndex];
//            }
//        }
    }

//    private void updateDisplayedStats(Tower tower) {
//        towerNameLabel.setText("Name: "+tower.getTowerName());
//        towerHealthLabel.setText("Health: "+tower.getHealth());
//        towerTypeLabel.setText("Resource Fill Type: "+tower.getFillType());
//        towerReloadLabel.setText("Reload Speed: "+tower.getReloadSpeed());
//    }

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
