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
    private Label currTowerHealth;
    @FXML
    private Label currTowerLevel;
    @FXML
    private Label currTowerReload;
    @FXML
    private Label currTowerType;
    @FXML
    private Label currTowerFillAmount;
    @FXML
    private Label upgradesOwned;
    @FXML
    private Label healsOwned;
    @FXML
    private Label revivesOwned;

    private final Tower[] selectedTowers = new Tower[5];
    private int selectedTowerIndex = -1;
    private String selectedItem = null;

    GameManager inventoryScreenGameManager;
    private InventoryService currentInventory;
    public InventoryScreenController(GameManager tempInventoryScreenGameManager) {
        inventoryScreenGameManager = tempInventoryScreenGameManager;
    }

    public void initialize() {
        List<Button> towerSlotButtons = List.of(inventorySlot1Button, inventorySlot2Button, inventorySlot3Button, inventorySlot4Button, inventorySlot5Button);
        List<Button> availableTowerButtons = List.of(coalType1Button, coalType2Button, ironType1Button, ironType2Button, goldType1Button, goldType2Button, gemType1Button, gemType2Button);
        List<Button> availableItemButtons = List.of(useHealButton, useReviveButton, useUpgradeButton);
        currentInventory = new InventoryService(inventoryScreenGameManager);
        List<Tower> towers = currentInventory.getTowerList();


        // Sets non owned tower buttons to black and broken towers to red
        for (int i = 0; i < availableTowerButtons.size(); i++) {
            if (!towers.get(i).getOwned()) {
                availableTowerButtons.get(i).setStyle("-fx-background-color: #000000; -fx-background-radius: 5;");
            }
            if (towers.get(i).getBroken()) {
                availableItemButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
            }
        }

        healsOwned.setText("Owned:" + currentInventory.getAvailableHeals());
        revivesOwned.setText("Owned:" + currentInventory.getAvailableRevives());
        upgradesOwned.setText("Owned:" + currentInventory.getAvailableUpgrades());


        // Sets the action to display the selected towers information when it is clicked on, and to show that it is selected
        for (int i = 0; i < availableTowerButtons.size(); i++) {
            int finalI = i;
            availableTowerButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex == finalI) {
                    resetTowerSelection();
                } else {
                    updateDisplayedStats(towers.get(finalI));
                    selectedTowerIndex = finalI;
                    selectedItem = null;
                    resetItemButtonStyles();
                    availableTowerButtons.forEach(button -> {
                        int buttonIndex = availableTowerButtons.indexOf(button);
                        if (button == availableTowerButtons.get(finalI)) {
                            if (towers.get(buttonIndex).getOwned() == true) {
                                button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                            }
                        } else {
                            if (towers.get(buttonIndex).getOwned() == true) {
                                button.setStyle("");
                            }
                        }
                    });
                }
            });
        }



        for (int i = 0; i < towerSlotButtons.size(); i++) {
            int finalI = i;
            towerSlotButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex != -1 && towers.get(selectedTowerIndex).getOwned() == true) {
                    if (!TowerService.isTowerAlreadySelected(selectedTowers, towers.get(selectedTowerIndex))) {
                        towerSlotButtons.get(finalI).setText(towers.get(selectedTowerIndex).getTowerName());
                        selectedTowers[finalI] = towers.get(selectedTowerIndex);
                        resetTowerSelection();
                    }

                } else if (selectedItem != null && selectedTowers[finalI] != null) {
                    applySelectedItem(selectedTowers[finalI]);
                    selectedItem = null;
                    resetItemButtonStyles();
                } else if (selectedTowers[finalI] != null) {
                    updateDisplayedStats(selectedTowers[finalI]);
                }
            });
        }

        useHealButton.setOnAction(event -> {
            if ("heal".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "heal";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                useHealButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
            }
        });

        useReviveButton.setOnAction(event -> {
            if ("revive".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "revive";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                useReviveButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
            }
        });

        useUpgradeButton.setOnAction(event -> {
            if ("upgrade".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "upgrade";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                useUpgradeButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
            }
        });
    }


    private void applySelectedItem(Tower tower) {
        switch (selectedItem) {
            case "heal":
                if (currentInventory.getAvailableHeals() > 0) {
                    tower.useHeal(currentInventory);
                    healsOwned.setText("Owned:" + currentInventory.getAvailableHeals());
                }
                break;
            case "revive":
                if (currentInventory.getAvailableRevives() > 0) {
                    tower.useRevive(currentInventory);
                    revivesOwned.setText("Owned:" + currentInventory.getAvailableRevives());
                }
                break;
            case "upgrade":
                if (currentInventory.getAvailableUpgrades() > 0) {
                    tower.useUpgrade(currentInventory);
                    upgradesOwned.setText("Owned:" + currentInventory.getAvailableUpgrades());
                }
                break;
        }
        updateDisplayedStats(tower);
    }

    private void resetItemButtonStyles() {
        useHealButton.setStyle("");
        useReviveButton.setStyle("");
        useUpgradeButton.setStyle("");
    }

    private void resetTowerButtonStyles() {
        List<Button> availableTowerButtons = List.of(coalType1Button, coalType2Button, ironType1Button, ironType2Button, goldType1Button, goldType2Button, gemType1Button, gemType2Button);
        List<Tower> towers = currentInventory.getTowerList();
        for (int i = 0; i < availableTowerButtons.size(); i++) {
            if (towers.get(i).getOwned() == true) {
                availableTowerButtons.get(i).setStyle("");
            }
        }
    }

    private void resetTowerSelection() {
        selectedTowerIndex = -1;
        resetTowerButtonStyles();
    }

    private void resetItemSelection() {
        selectedItem = null;
        resetItemButtonStyles();
    }

    private void updateDisplayedStats(Tower tower) {
        currTowerHealth.setText("Health: " + tower.getHealth() +"/"+ tower.getMaxHealth());
        currTowerLevel.setText("Level: " + tower.getLevel());
        currTowerReload.setText("Reload Speed:" + tower.getReloadSpeed());
        currTowerType.setText("Name:" + tower.getTowerName());
        currTowerFillAmount.setText("Fill Amount:" + tower.getFillAmount());
    }

    @FXML
    private void onMenu() {
        inventoryScreenGameManager.launchBetweenRoundsScreen();
    }

    @FXML
    private void onShop() {
        inventoryScreenGameManager.openShopScreen();
    }
}
