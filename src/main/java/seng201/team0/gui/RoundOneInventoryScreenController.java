package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundOneInventoryService;

import java.util.List;

public class RoundOneInventoryScreenController {
    @FXML Button heavyCoalButton;
    @FXML Button lightCoalButton;
    @FXML Button heavyIronButton;
    @FXML Button lightIronButton;
    @FXML Button heavyGoldButton;
    @FXML Button lightGoldButton;
    @FXML Button selectedTowerButtonOne;
    @FXML Button selectedTowerButtonTwo;
    @FXML Button selectedTowerButtonThree;
    @FXML Label towerNameLabel;
    @FXML Label towerHealthLabel;
    @FXML Label towerTypeLabel;
    @FXML Label towerReloadLabel;
    private final Tower[] selectedTowers = new Tower[3];
    RoundOneInventoryService roundOneInventory;

    GameManager roundOneInventoryScreenGameManager;

    RoundOneInventoryScreenController(GameManager tempRoundOneInventoryScreenGameManager){
        roundOneInventoryScreenGameManager = tempRoundOneInventoryScreenGameManager;
    }
    public void initialize() {
        List<Button> towerButtons = List.of(heavyCoalButton,lightCoalButton,heavyIronButton,lightIronButton,heavyGoldButton,lightGoldButton);
        List<Button> selectedTowers = List.of(selectedTowerButtonOne,selectedTowerButtonTwo,selectedTowerButtonThree);
        RoundOneInventoryService roundOneInventory = new RoundOneInventoryService(roundOneInventoryScreenGameManager);

    }
    @FXML
    private void onConfirm() {
        roundOneInventoryScreenGameManager.closeRoundOneInventoryScreen();
    }
}