package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.InventoryService;
import seng201.team0.services.ShopService;

import java.util.List;

public class ShopScreenController {
    @FXML
    private Label amountOwnedLabel;
    @FXML
    private Label buyPriceLabel;
    @FXML
    private Label sellPriceLabel;
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
    private int selectedTowerIndex = -1;
    private String selectedItem = null;
    private InventoryService currentInventory;
    private ShopService shopService;

    public ShopScreenController(GameManager tempShopScreenGameManager) {
        shopScreenGameManager = tempShopScreenGameManager;
    }

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
                        int buttonIndex = availableTowerButtons.indexOf(button);
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

    private void updateLabels() {
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            amountOwnedLabel.setText("Owned: " + tower.getOwned());
            buyPriceLabel.setText("Buy Price: " + tower.getBuyPrice());
            sellPriceLabel.setText("Sell Price: " + tower.getSellPrice());
        } else if (selectedItem != null) {
            if (selectedItem.equals("heal")) {
                amountOwnedLabel.setText("Amount Owned: " + shopScreenGameManager.getAvailableHeals());
                buyPriceLabel.setText("Buy Price: " + shopService.getItemCost(selectedItem));
                sellPriceLabel.setText("Sell Price: " + shopService.getItemSellValue(selectedItem));
            } else if (selectedItem.equals("revive")) {
                amountOwnedLabel.setText("Amount Owned: " + shopScreenGameManager.getAvailableRevives());
                buyPriceLabel.setText("Buy Price: " + shopService.getItemCost(selectedItem));
                sellPriceLabel.setText("Sell Price: " + shopService.getItemSellValue(selectedItem));
            } else if (selectedItem.equals("upgrade")) {
                amountOwnedLabel.setText("Amount Owned: " + shopScreenGameManager.getAvailableUpgrades());
                buyPriceLabel.setText("Buy Price: " + shopService.getItemCost(selectedItem));
                sellPriceLabel.setText("Sell Price: " + shopService.getItemSellValue(selectedItem));
            }

        } else {
            amountOwnedLabel.setText("");
            buyPriceLabel.setText("");
            sellPriceLabel.setText("");
        }
        moneyLabel.setText("Money: " + shopScreenGameManager.getMoneyAmount());
    }

    private void resetTowerSelection() {
        selectedTowerIndex = -1;
        resetTowerButtonStyles();
        updateLabels();
    }

    private void resetItemSelection() {
        selectedItem = null;
        resetItemButtonStyles();
        updateLabels();
    }

    private void resetItemButtonStyles() {
        towerHealShopButton.setStyle("");
        towerReviveShopButton.setStyle("");
        towerUpgradeShopButton.setStyle("");
    }

    private void resetTowerButtonStyles() {
        List<Button> availableTowerButtons = List.of(coalTower1ShopButton, coalTower2ShopButton, ironTower1ShopButton, ironTower2ShopButton, goldTower1ShopButton, goldTower2ShopButton, gemTower1ShopButton, gemTower2ShopButton);
        availableTowerButtons.forEach(button -> button.setStyle(""));
    }

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
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            shopScreenGameManager.sellTower(tower);
        } else if (selectedItem != null) {
            shopScreenGameManager.sellItem(selectedItem);
        }
        updateLabels();
//        resetSelections();
    }

    @FXML
    private void onBuy() {
        if (selectedTowerIndex >= 0) {
            Tower tower = shopScreenGameManager.getGenericRoundTowerList().get(selectedTowerIndex);
            shopScreenGameManager.buyTower(tower);
            System.out.println("ShopSCreenController onBuy:");
            for (int i = 0; i < shopScreenGameManager.getGenericRoundTowerList().size(); i++) {
                System.out.println(shopScreenGameManager.getGenericRoundTowerList().get(i).getTowerName() + ": " + shopScreenGameManager.getGenericRoundTowerList().get(i).getOwned());
            }

        } else if (selectedItem != null) {
            shopScreenGameManager.buyItem(selectedItem);
        }
        updateLabels();
//        resetSelections();
    }

    private void resetSelections() {
        selectedTowerIndex = -1;
        selectedItem = null;
        resetTowerButtonStyles();
        resetItemButtonStyles();
        updateLabels();
    }
}
