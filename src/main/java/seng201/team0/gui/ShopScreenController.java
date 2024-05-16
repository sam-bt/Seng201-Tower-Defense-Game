package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team0.GameManager;

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
    GameManager shopScreenGameManager;

    ShopScreenController(GameManager tempShopScreenGameManager) {
        this.shopScreenGameManager = tempShopScreenGameManager;
    }

}
