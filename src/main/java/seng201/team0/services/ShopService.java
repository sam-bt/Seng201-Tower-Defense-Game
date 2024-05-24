package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;

public class ShopService {
    private GameManager gameManager;

    public ShopService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void buyTower(Tower tower) {
        System.out.println(gameManager.getMoneyAmount());
        System.out.println(tower.getBuyPrice());
        System.out.println(tower.getOwned());
        if (gameManager.getMoneyAmount() >= tower.getBuyPrice() && !tower.getOwned()) {
            gameManager.getMoneyService().editMoney(-tower.getBuyPrice());
            tower.setOwned();
            System.out.println("Bought tower: " + tower.getTowerName());
        } else {
            System.out.println("Not enough currency to buy the tower, or tower already owned");
        }
    }

    public void sellTower(Tower tower) {
        if (tower.getOwned()) {
            gameManager.getMoneyService().editMoney(tower.getSellPrice());
            tower.setNotOwned();
            System.out.println("Sold tower: " + tower.getTowerName());
        }

    }

    public void buyItem(String item) {
        int itemCost = getItemCost(item);
        if (gameManager.getMoneyAmount() >= itemCost) {
            gameManager.getMoneyService().editMoney(-itemCost);
            if (item.equals("heal")) {
                gameManager.incrementHeals();
            } else if (item.equals("revive")) {
                gameManager.incrementRevives();
            } else if (item.equals("upgrade")) {
                gameManager.incrementUpgrades();
            }
            System.out.println("Bought item: " + item);
        } else {
            System.out.println("Not enough currency to buy the item.");
        }
    }

    public void sellItem(String item) {
        int itemSellValue = getItemSellValue(item);
        if (item.equals("heal") && gameManager.getAvailableHeals() > 0) {
            gameManager.decrementHeals();
            gameManager.getMoneyService().editMoney(itemSellValue);
        } else if (item.equals("revive") && gameManager.getAvailableRevives() > 0) {
            gameManager.decrementRevives();
            gameManager.getMoneyService().editMoney(itemSellValue);
        } else if (item.equals("upgrade") && gameManager.getAvailableUpgrades() > 0) {
            gameManager.decrementUpgrades();
            gameManager.getMoneyService().editMoney(itemSellValue);
        }
        // Remove item from inventory (example)
        System.out.println("Sold item: " + item);
    }

    public int getItemCost(String item) {
        switch (item) {
            case "heal":
                return 50;
            case "revive":
                return 500;
            case "upgrade":
                return 150;
            default:
                return 0;
        }
    }

    public int getItemSellValue(String item) {
        switch (item) {
            case "heal":
                return 50;
            case "revive":
                return 500;
            case "upgrade":
                return 150;
            default:
                return 0;
        }
    }
}
