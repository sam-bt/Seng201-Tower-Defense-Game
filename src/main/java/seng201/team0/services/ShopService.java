package seng201.team0.services;

import seng201.team0.GameManager;
import seng201.team0.models.Tower;


/**
 * Service class for managing transactions in the game's shop.
 */
public class ShopService {

    /**
     * The GameManager object representing the game's state.
     */
    private final GameManager gameManager;

    /**
     * Constructs a ShopService object with the given GameManager.
     *
     * @param gameManager The GameManager object representing the game's state.
     */
    public ShopService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Allows the player to buy a tower from the shop.
     *
     * @param tower The Tower object representing the tower to be bought.
     */
    public void buyTower(Tower tower) {
        if (gameManager.getMoneyAmount() >= tower.getBuyPrice() && !tower.getOwned()) {
            gameManager.getMoneyService().editMoney(-tower.getBuyPrice());
            tower.setOwned();
        }
    }

    /**
     * Allows the player to sell a tower to the shop.
     *
     * @param tower The Tower object representing the tower to be sold.
     */
    public void sellTower(Tower tower) {
        if (tower.getOwned()) {
            gameManager.getMoneyService().editMoney(tower.getSellPrice());
            tower.setNotOwned();
        }

    }
    /**
     * Allows the player to buy an item from the shop.
     *
     * @param item The Item to be bought
     */
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
        }
    }
    /**
     * Allows the player to sell an item to the shop.
     *
     * @param item The Item to be sold
     */
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
    }
    /**
     * Gets the cost of a specifiec item.
     *
     * @param item The Item to return the cost of
     * @return the cost of the specified item
     */
    public static int getItemCost(String item) {
        switch (item) {
            case "heal":
                return 200;
            case "revive":
                return 500;
            case "upgrade":
                return 150;
            default:
                return 0;
        }
    }
    /**
     * Gets the sell value of a specifiec item.
     *
     * @param item The Item to return the sell value of
     * @return the sell value of the specified item
     */
    public static int getItemSellValue(String item) {
        switch (item) {
            case "heal":
                return 200;
            case "revive":
                return 500;
            case "upgrade":
                return 150;
            default:
                return 0;
        }
    }
}
