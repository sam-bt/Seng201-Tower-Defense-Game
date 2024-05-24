package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.ShopService;

import java.util.List;

/**
 * Controller class for the shop screen in the game.
 * This class manages the interactions between the shop screen's UI elements.
 * It handles the selection of towers and items, and the actions of buying and selling these entities.
 */
public class ShopScreenController {
    @FXML
    private Label amountOwnedLabel;
    @FXML
    private Label buyPriceLabel;
    @FXML
    private Label selectedLabel;
    @FXML
    private Label moneyLabel;

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
    private Button towerHealShopButton;

    @FXML
    private Button towerReviveShopButton;

    @FXML
    private Button towerUpgradeShopButton;

    /**
     * Manages the game logic and states related to the shop screen.
     */
    private final GameManager shopScreenGameManager;
    /**
     * The index of the tower currently selected by the player. Initialized to -1.
     */
    private int selectedTowerIndex = -1;
    /**
     * The currently selected item in the shop screen. Initialized to null.
     */
    private String selectedItem = null;
    /**
     * The inventory service that handles the player's current inventory.
     */
    private InventoryService currentInventory;
    /**
     * The shop service that manages the operations and data related to the shop.
     */
    private ShopService shopService;

    /**
     * Constructor for the ShopScreenController game manager.
     *
     * @param tempShopScreenGameManager The GameManager instance for the shop screen.
     */
    public ShopScreenController(final GameManager tempShopScreenGameManager) {
        shopScreenGameManager = tempShopScreenGameManager;
    }

    /**
     * Initializes the shop screen by setting up button actions and labels.
     */
    public void initialize() {

        List<Button> availableTowerButtons = List.of(coalTower1ShopButton, coalTower2ShopButton, ironTower1ShopButton, ironTower2ShopButton, goldTower1ShopButton, goldTower2ShopButton, gemTower1ShopButton, gemTower2ShopButton);
        currentInventory = new InventoryService(shopScreenGameManager);
        shopService = new ShopService(shopScreenGameManager);

        moneyLabel.setText("Money: " + shopScreenGameManager.getMoneyAmount());

        for (int i = 0; i < availableTowerButtons.size(); i++) {
            int finalI = i;
            availableTowerButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex == finalI) {
                    resetTowerSelection();
                } else {
                    selectedTowerIndex = finalI;
                    selectedItem = null;
                    resetItemButtonStyles();
                    availableTowerButtons.forEach(button -> {
                        if (button == availableTowerButtons.get(finalI)) {
                            button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                        } else {
                            button.setStyle("");
                        }
                    });
                    updateLabels();
                }
            });
        }

        towerHealShopButton.setOnAction(event -> {
            if ("heal".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "heal";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                towerHealShopButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                updateLabels();
            }
        });

        towerReviveShopButton.setOnAction(event -> {
            if ("revive".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "revive";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                towerReviveShopButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                updateLabels();
            }
        });

        towerUpgradeShopButton.setOnAction(event -> {
            if ("upgrade".equals(selectedItem)) {
                resetItemSelection();
            } else {
                selectedItem = "upgrade";
                selectedTowerIndex = -1;
                resetTowerButtonStyles();
                resetItemButtonStyles();
                towerUpgradeShopButton.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                updateLabels();
            }
        });

        buyButton.setOnAction(event -> onBuy());
        sellButton.setOnAction(event -> onSell());
    }

    /**
     * Updates the labels on the shop screen based on the selected tower or item.
     */
    private void updateLabels() {
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            amountOwnedLabel.setText(" " + tower.getOwned());
            buyPriceLabel.setText(" " + tower.getBuyPrice());
            selectedLabel.setText(" " + tower.getTowerName());
        } else if (selectedItem != null) {
            if (selectedItem.equals("heal")) {
                amountOwnedLabel.setText(" " + shopScreenGameManager.getAvailableHeals());
                buyPriceLabel.setText(" " + ShopService.getItemCost(selectedItem));
                selectedLabel.setText(" Heal");
            } else if (selectedItem.equals("revive")) {
                amountOwnedLabel.setText(" " + shopScreenGameManager.getAvailableRevives());
                buyPriceLabel.setText(" " + ShopService.getItemCost(selectedItem));
                selectedLabel.setText(" Revive");
            } else if (selectedItem.equals("upgrade")) {
                amountOwnedLabel.setText(" " + shopScreenGameManager.getAvailableUpgrades());
                buyPriceLabel.setText(" " + ShopService.getItemCost(selectedItem));
                selectedLabel.setText(" Upgrade");
            }

        } else {
            amountOwnedLabel.setText("");
            buyPriceLabel.setText("");
            selectedLabel.setText("");
        }
        moneyLabel.setText("Money: " + shopScreenGameManager.getMoneyAmount());
    }

    /**
     * Resets the selected tower.
     */
    private void resetTowerSelection() {
        selectedTowerIndex = -1;
        resetTowerButtonStyles();
        updateLabels();
    }

    /**
     * Resets the selected item.
     */
    private void resetItemSelection() {
        selectedItem = null;
        resetItemButtonStyles();
        updateLabels();
    }

    /**
     * Resets the styles of item buttons.
     */
    private void resetItemButtonStyles() {
        towerHealShopButton.setStyle("");
        towerReviveShopButton.setStyle("");
        towerUpgradeShopButton.setStyle("");
    }

    /**
     * Resets the styles of tower buttons.
     */
    private void resetTowerButtonStyles() {
        List<Button> availableTowerButtons = List.of(coalTower1ShopButton, coalTower2ShopButton, ironTower1ShopButton, ironTower2ShopButton, goldTower1ShopButton, goldTower2ShopButton, gemTower1ShopButton, gemTower2ShopButton);
        availableTowerButtons.forEach(button -> button.setStyle(""));
    }

    /**
     * Launches the inventory screen.
     */
    @FXML
    private void onInventory() {
        shopScreenGameManager.launchInventoryScreen();
    }

    /**
     * Launches the between rounds screen.
     */
    @FXML
    private void onMenu() {
        shopScreenGameManager.launchBetweenRoundsScreen();
    }

    /**
     * Sells the selected tower or item.
     */
    @FXML
    private void onSell() {
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            shopScreenGameManager.sellTower(tower);
        } else if (selectedItem != null) {
            shopScreenGameManager.sellItem(selectedItem);
        }
        updateLabels();
    }

    /**
     * Buys the selected tower or item.
     */
    @FXML
    private void onBuy() {
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            shopScreenGameManager.buyTower(tower);
        } else if (selectedItem != null) {
            shopScreenGameManager.buyItem(selectedItem);
        }
        updateLabels();
    }
}
