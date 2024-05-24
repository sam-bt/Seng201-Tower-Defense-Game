package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.TowerService;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * The InventoryScreenController class controls the user interface for the inventory screen in the game.
 * It handles interactions between the user and the inventory system, displaying tower information,
 * managing tower slots, and applying selected items such as heals, revives, and upgrades to towers.
 */
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
    private Label currTowerBreakChance;
    @FXML
    private Label upgradesOwned;
    @FXML
    private Label healsOwned;
    @FXML
    private Label revivesOwned;
    /**
     * Array to store selected towers, with a fixed size of 5.
     */
    private final Tower[] selectedTowers = new Tower[5];

    /**
     * Array to store towers in slots, with a fixed size of 5.
     */
    private Tower[] towersInSlots = new Tower[5];

    /**
     * Index indicating the currently selected tower (-1 if none selected).
     */
    private int selectedTowerIndex = -1;

    /**
     * The currently selected item (null if none selected).
     */
    private String selectedItem = null;

    /**
     * List of indices representing towers in a tower list.
     */
    List<Integer> towerListIndices;

    /**
     * Array to store saved towers.
     */
    Tower[] savedTowers;

    /**
     * GameManager instance for the inventory screen.
     */
    GameManager inventoryScreenGameManager;

    /**
     * The current inventory service.
     */
    private InventoryService currentInventory;

    /**
     * Constructor
     * @param tempInventoryScreenGameManager
     */
    public InventoryScreenController(GameManager tempInventoryScreenGameManager) {
        inventoryScreenGameManager = tempInventoryScreenGameManager;
    }
    /**
     * Initializes the inventory screen by setting up various UI elements and event handlers.
     * It populates the inventory with available towers and items, updates displayed stats,
     * and sets up button actions for tower selection, item usage, etc.
     */
    public void initialize() {
        List<Button> towerSlotButtons = List.of(inventorySlot1Button, inventorySlot2Button, inventorySlot3Button, inventorySlot4Button, inventorySlot5Button);
        List<Button> availableTowerButtons = List.of(coalType1Button, coalType2Button, ironType1Button, ironType2Button, goldType1Button, goldType2Button, gemType1Button, gemType2Button);
        List<Button> availableItemButtons = List.of(useHealButton, useReviveButton, useUpgradeButton);
        currentInventory = new InventoryService(inventoryScreenGameManager);
        List<Tower> towers = currentInventory.getTowerList();
        List<Tower> genericTowers = inventoryScreenGameManager.getGenericRoundTowerList();

        clearDisplayedStats();

        healsOwned.setText("Heals Owned: " + inventoryScreenGameManager.getAvailableHeals());
        revivesOwned.setText("Revives Owned: " + inventoryScreenGameManager.getAvailableRevives());
        upgradesOwned.setText("Upgrades Owned: " + inventoryScreenGameManager.getAvailableUpgrades());

        towerListIndices = inventoryScreenGameManager.getGenericRoundTowerListIndices();
        if (!inventoryScreenGameManager.isGenericRoundTowerListNull()) {
            if (inventoryScreenGameManager.getRoundOneSelectedTowerList()!=null){
                savedTowers = inventoryScreenGameManager.getRoundOneSelectedTowerList();
                towerListIndices = inventoryScreenGameManager.getGenericRoundTowerListIndices();
            }
        }
        else {
            towerListIndices = emptyList();
        }
        List<Button> savedTowerButtons = inventoryScreenGameManager.getRoundOneSelectedTowerButtons();
        // Load towers from slots if any
        towersInSlots = inventoryScreenGameManager.getTowersInSlots();
        for (int i = 0; i < towersInSlots.length; i++) {
            if (towersInSlots[i] != null) {
                if (towersInSlots[i].getOwned()) {
                    towerSlotButtons.get(i).setText(towersInSlots[i].getTowerName());
                    if (towersInSlots[i].getBroken()) {
                        towerSlotButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                    }
                    selectedTowers[i] = towersInSlots[i];
                } else {
                    towerSlotButtons.get(i).setText("Slot " + (i + 1));
                    towersInSlots[i] = null;
                }

            }
        }

        // Sets non-owned tower buttons to black and broken towers to red
        for (int i = 0; i < availableTowerButtons.size(); i++) {
            Tower tower = inventoryScreenGameManager.getGenericRoundTowerList().get(i);
            if (!tower.getOwned()) {
                availableTowerButtons.get(i).setDisable(true);
                availableTowerButtons.get(i).setStyle("-fx-background-color: #000000; -fx-background-radius: 5;");
            } else {
                availableTowerButtons.get(i).setDisable(false);
                availableTowerButtons.get(i).setStyle("");
            }
            if (tower.getBroken()) {
                System.out.println(tower.getTowerName() + " is broken");
                availableTowerButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
            }
        }

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
                            if (towers.get(buttonIndex).getOwned()) {
                                if (towers.get(buttonIndex).getBroken()) {
                                    button.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                                } else {
                                    button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                                }
                            }
                        } else {
                            if (towers.get(buttonIndex).getOwned()) {
                                if (towers.get(buttonIndex).getBroken()) {
                                    button.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                                } else {
                                    button.setStyle("");
                                }
                            }
                        }
                    });
                }
            });
        }

        for (int i = 0; i < towerSlotButtons.size(); i++) {
            int finalI = i;
            towerSlotButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex != -1 && towers.get(selectedTowerIndex).getOwned()) {
                    if (!TowerService.isTowerAlreadySelected(selectedTowers, towers.get(selectedTowerIndex))) {
                        towerSlotButtons.get(finalI).setText(towers.get(selectedTowerIndex).getTowerName());
                        selectedTowers[finalI] = towers.get(selectedTowerIndex);
                        towersInSlots[finalI] = towers.get(selectedTowerIndex);  // Save the tower to towersInSlots array
                        if (towers.get(selectedTowerIndex).getBroken()) {
                            towerSlotButtons.get(finalI).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                        } else {
                            towerSlotButtons.get(finalI).setStyle("");
                        }
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
        updateSlotButtonStyles();
    }
    /**
     * Applies the selected item action to the specified tower.
     * @param tower The tower to apply the selected item action to.
     */
    private void applySelectedItem(Tower tower) {
        switch (selectedItem) {
            case "heal":
                if (inventoryScreenGameManager.getAvailableHeals() > 0 && tower.getMaxHealth() > tower.getHealth()) {
                    tower.useHeal();
                    inventoryScreenGameManager.consumeHeal();
                    healsOwned.setText("Heals Owned: " + inventoryScreenGameManager.getAvailableHeals());
                }
                break;
            case "revive":
                if (inventoryScreenGameManager.getAvailableRevives() > 0) {
                    for (int i = 0; i < inventoryScreenGameManager.getGenericRoundTowerList().size(); i++) {
                        inventoryScreenGameManager.getGenericRoundTowerList().get(i).useRevive();
                    }
                    inventoryScreenGameManager.consumeRevive();
                    revivesOwned.setText("Revives Owned: " + inventoryScreenGameManager.getAvailableRevives());
                    resetTowerButtonStyles();
                    updateSlotButtonStyles();
                }
                break;
            case "upgrade":
                if (inventoryScreenGameManager.getAvailableUpgrades() > 0) {
                    tower.useUpgrade();
                    inventoryScreenGameManager.consumeUpgrade();
                    upgradesOwned.setText("Upgrades Owned: " + inventoryScreenGameManager.getAvailableUpgrades());
                }
                break;
        }
        updateDisplayedStats(tower);
    }
    /**
     * Resets the styles of item buttons.
     */
    private void resetItemButtonStyles() {
        useHealButton.setStyle("");
        useReviveButton.setStyle("");
        useUpgradeButton.setStyle("");
    }
    /**
     * Resets the styles of tower buttons based on their availability and broken status.
     */
    private void resetTowerButtonStyles() {
        List<Button> availableTowerButtons = List.of(coalType1Button, coalType2Button, ironType1Button, ironType2Button, goldType1Button, goldType2Button, gemType1Button, gemType2Button);
        List<Tower> towers = currentInventory.getTowerList();
        for (int i = 0; i < availableTowerButtons.size(); i++) {
            Tower tower = towers.get(i);
            if (tower.getOwned()) {
                if (tower.getBroken()) {
                    availableTowerButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                } else {
                    availableTowerButtons.get(i).setStyle("");
                }
            } else {
                if (tower.getBroken()) {
                    availableTowerButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                    availableTowerButtons.get(i).setDisable(true);
                } else {
                    availableTowerButtons.get(i).setStyle("-fx-background-color: #000000; -fx-background-radius: 5;");
                    availableTowerButtons.get(i).setDisable(true);
                }

            }
        }
    }
    /**
     * Resets the tower selection by clearing displayed stats and resetting tower button styles.
     */
    private void resetTowerSelection() {
        selectedTowerIndex = -1;
        clearDisplayedStats();
        resetTowerButtonStyles();
    }
    /**
     * Resets the selected item.
     */
    private void resetItemSelection() {
        selectedItem = null;
        resetItemButtonStyles();
    }
    /**
     * Clears the displayed tower statistics.
     */
    private void clearDisplayedStats() {
        currTowerHealth.setText(" ");
        currTowerLevel.setText(" ");
        currTowerReload.setText(" ");
        currTowerType.setText(" ");
        currTowerFillAmount.setText(" ");
        currTowerBreakChance.setText(" ");
    }
    /**
     * Updates the displayed statistics for the specified tower.
     * @param tower The tower whose statistics to display.
     */
    private void updateDisplayedStats(Tower tower) {
        currTowerHealth.setText(" " + tower.getHealth() +"/"+ tower.getMaxHealth());
        currTowerLevel.setText(" " + tower.getLevel());
        currTowerReload.setText(" " + tower.getReloadSpeed());
        currTowerType.setText(" " + tower.getTowerName());
        currTowerFillAmount.setText(" " + tower.getFillAmount());
        currTowerBreakChance.setText(" " + tower.getBreakChance() + "%");
        // Update the tower slot button color based on the broken status
        for (int i = 0; i < selectedTowers.length; i++) {
            if (selectedTowers[i] != null && selectedTowers[i].equals(tower)) {
                if (tower.getBroken()) {
                    getTowerSlotButton(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                } else {
                    getTowerSlotButton(i).setStyle("");
                }
            }
        }
    }
    /**
     * Updates the styles of tower slot buttons based on the towers in the slots.
     */
    private void updateSlotButtonStyles() {
        List<Button> towerSlotButtons = List.of(inventorySlot1Button, inventorySlot2Button, inventorySlot3Button, inventorySlot4Button, inventorySlot5Button);
        for (int i = 0; i < towersInSlots.length; i++) {
            Tower tower = towersInSlots[i];
            if (tower != null) {
                if (tower.getBroken()) {
                    towerSlotButtons.get(i).setStyle("-fx-background-color: #ff0000; -fx-background-radius: 5;");
                } else {
                    towerSlotButtons.get(i).setStyle("");
                }
            }
        }
    }

    /**
     * Retrieves the tower slot button corresponding to the given index.
     * @param index The index of the tower slot button to retrieve.
     * @return The tower slot button corresponding to the given index.
     */
    private Button getTowerSlotButton(int index) {
        return switch (index) {
            case 0 -> inventorySlot1Button;
            case 1 -> inventorySlot2Button;
            case 2 -> inventorySlot3Button;
            case 3 -> inventorySlot4Button;
            case 4 -> inventorySlot5Button;
            default -> null;
        };
    }
    /**
     * Saves the towers currently in slots to the GameManager.
     */
    private void saveTowersInSlots() {
        for (int i = 0; i < selectedTowers.length; i++) {
            towersInSlots[i] = selectedTowers[i];
        }
        inventoryScreenGameManager.setTowersInSlots(towersInSlots);
    }

    /**
     * Handles the action when the menu button is clicked.
     * Saves towers in slots and launches the between rounds screen.
     */
    @FXML
    private void onMenu() {
        saveTowersInSlots();
        inventoryScreenGameManager.launchBetweenRoundsScreen();
    }

    /**
     * Handles the action when the shop button is clicked.
     * Saves towers in slots and opens the shop screen.
     */
    @FXML
    private void onShop() {
        saveTowersInSlots();
        inventoryScreenGameManager.openShopScreen();
    }
}
