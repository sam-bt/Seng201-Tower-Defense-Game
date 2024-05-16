package seng201.team0.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundOneInventoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private int selectedTowerIndex = -1;

    GameManager roundOneInventoryScreenGameManager;

    RoundOneInventoryScreenController(GameManager tempRoundOneInventoryScreenGameManager){
        roundOneInventoryScreenGameManager = tempRoundOneInventoryScreenGameManager;
    }
    public void initialize() {
        List<Button> towerButtons = List.of(heavyCoalButton,lightCoalButton,heavyIronButton,lightIronButton,heavyGoldButton,lightGoldButton);
        List<Button> selectedTowerButtons = List.of(selectedTowerButtonOne,selectedTowerButtonTwo,selectedTowerButtonThree);
        RoundOneInventoryService roundOneInventory = new RoundOneInventoryService(roundOneInventoryScreenGameManager);
        List<Tower> towers = roundOneInventory.getTowerList();

        for (int i = 0; i < towerButtons.size(); i++) {
            int finalI = i;
            towerButtons.get(i).setOnAction(event -> {
                updateDisplayedStats(towers.get(finalI));
                selectedTowerIndex = finalI;
                towerButtons.forEach(button -> {
                    if (button == towerButtons.get(finalI)) {
                        button.setStyle("-fx-background-color: #b3b3b3; -fx-background-radius: 5;");
                    } else {
                        button.setStyle("");
                    }
                });
            });
        }
        for (int i = 0; i < selectedTowerButtons.size(); i++) {
            int finalI = i; //TODO stop multiple of the same tower being added
            selectedTowerButtons.get(i).setOnAction(event -> {
                if (selectedTowerIndex != -1) {
                    selectedTowerButtons.get(finalI).setText(towers.get(selectedTowerIndex).getTowerName());
                    selectedTowers[finalI] = towers.get(selectedTowerIndex);
                }
            });
        }

    }
    private void updateDisplayedStats(Tower tower) {
        towerNameLabel.setText("Name: "+tower.getTowerName());
        towerHealthLabel.setText("Health: "+tower.getHealth());
        towerTypeLabel.setText("Resource Fill Type: "+tower.getFillType());
        towerReloadLabel.setText("Reload Speed: "+tower.getReloadSpeed());

    }
    @FXML
    private void onConfirm() {
        // TODO save selected towers
        roundOneInventoryScreenGameManager.closeRoundOneInventoryScreen();
    }
}