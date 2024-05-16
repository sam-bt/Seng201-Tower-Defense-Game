package seng201.team0.gui;

import javafx.fxml.FXML;
import seng201.team0.GameManager;

public class RoundOneInventoryScreenController {
    GameManager roundOneInventoryScreenManager;

    RoundOneInventoryScreenController(GameManager tempRoundOneInventoryScreenManager){
        roundOneInventoryScreenManager = tempRoundOneInventoryScreenManager;
    }
    @FXML
    private void onConfirm() {
        roundOneInventoryScreenManager.closeRoundOneInventoryScreen();
    }
}