package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.GameManager;
import seng201.team0.models.Tower;
import seng201.team0.services.MoneyService;
import seng201.team0.services.ShopService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test ShopService implementation
 * @author Samuel Beattie
 */
public class ShopServiceTest {
    /**
     * Test heal price correct
     */
    @Test void healPriceTest(){
        assertEquals(ShopService.getItemCost("heal"), 200);
    }
    /**
     * Test revive price correct
     */
    @Test void revivePriceTest(){
        assertEquals(ShopService.getItemCost("revive"), 500);
    }
    /**
     * Test upgrade price correct
     */
    @Test void upgradePriceTest(){
        assertEquals(ShopService.getItemCost("upgrade"), 150);
    }
    /**
     * Test default price correct
     */
    @Test void defaultPriceTest(){
        assertEquals(ShopService.getItemCost(""), 0);
    }
    /**
     * Test heal sell price correct
     */
    @Test void healSellTest(){
        assertEquals(ShopService.getItemSellValue("heal"), 200);
    }
    /**
     * Test revive sell price correct
     */
    @Test void reviveSellTest(){
        assertEquals(ShopService.getItemSellValue("revive"), 500);
    }
    /**
     * Test upgrade sell price correct
     */
    @Test void upgradeSellTest(){
        assertEquals(ShopService.getItemSellValue("upgrade"), 150);
    }
    /**
     * Test default sell price correct
     */
    @Test void defaultSellTest(){
        assertEquals(ShopService.getItemSellValue(""), 0);
    }
    /**
     * Test buying a tower that is not owned
     */
    @Test void buyTowerNotOwnedTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        Tower tower = new Tower(100,false,"Coal",50,3,"Heavy Coal", 500);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyTower(tower);
        assertEquals(gameManager.getMoneyAmount(), 500.0);
        assertEquals(tower.getOwned(), true);
    }
    /**
     * Test buying a tower that is owned
     */
    @Test void buyTowerOwnedTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        Tower tower = new Tower(100,true,"Coal",50,3,"Heavy Coal", 500);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyTower(tower);
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(tower.getOwned(), true);
    }
    /**
     * Test selling a tower that is not owned
     */
    @Test void sellTowerNotOwnedTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        Tower tower = new Tower(100,false,"Coal",50,3,"Heavy Coal", 500);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.sellTower(tower);
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(tower.getOwned(), false);
    }
    /**
     * Test selling a tower that is owned
     */
    @Test void sellTowerOwnedTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        Tower tower = new Tower(100,true,"Coal",50,3,"Heavy Coal", 500);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.sellTower(tower);
        assertEquals(gameManager.getMoneyAmount(), 1500.0);
        assertEquals(tower.getOwned(), false);
    }
    /**
     * Test buying a heal with enough money
     */
    @Test void buyHealEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("heal");
        assertEquals(gameManager.getMoneyAmount(), 800.0);
        assertEquals(gameManager.getAvailableHeals(), 1);
    }
    /**
     * Test buying a heal without enough money
     */
    @Test void buyHealNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(25.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("heal");
        assertEquals(gameManager.getMoneyAmount(), 25.0);
        assertEquals(gameManager.getAvailableHeals(), 0);
    }
    /**
     * Test buying a revive with enough money
     */
    @Test void buyReviveEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("revive");
        assertEquals(gameManager.getMoneyAmount(), 500.0);
        assertEquals(gameManager.getAvailableRevives(), 1);
    }
    /**
     * Test buying a revive without enough money
     */
    @Test void buyReviveNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(250.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("revive");
        assertEquals(gameManager.getMoneyAmount(), 250.0);
        assertEquals(gameManager.getAvailableRevives(), 0);
    }
    /**
     * Test buying an upgrade with enough money
     */
    @Test void buyUpgradeEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("upgrade");
        assertEquals(gameManager.getMoneyAmount(), 850.0);
        assertEquals(gameManager.getAvailableUpgrades(), 1);
    }
    /**
     * Test buying an upgrade without enough money
     */
    @Test void buyUpgradeNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(100.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("upgrade");
        assertEquals(gameManager.getMoneyAmount(), 100.0);
        assertEquals(gameManager.getAvailableUpgrades(), 0);
    }
    /**
     * Test selling a heal with one
     */
    @Test void sellHealEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("heal");
        assertEquals(gameManager.getMoneyAmount(), 800.0);
        assertEquals(gameManager.getAvailableHeals(), 1);
        shopService.sellItem("heal");
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(gameManager.getAvailableHeals(), 0);
    }
    /**
     * Test selling a heal with none
     */
    @Test void sellHealNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.sellItem("heal");
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(gameManager.getAvailableHeals(), 0);
    }
    /**
     * Test selling a revive with one
     */
    @Test void sellReviveEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("revive");
        assertEquals(gameManager.getMoneyAmount(), 500.0);
        assertEquals(gameManager.getAvailableRevives(), 1);
        shopService.sellItem("revive");
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(gameManager.getAvailableRevives(), 0);
    }
    /**
     * Test selling a revive with none
     */
    @Test void sellReviveNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(250.0);
        gameManager.setMoney(moneyService);
        shopService.sellItem("revive");
        assertEquals(gameManager.getMoneyAmount(), 250.0);
        assertEquals(gameManager.getAvailableRevives(), 0);
    }
    /**
     * Test selling an upgrade with one
     */
    @Test void sellUpgradeEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(1000.0);
        gameManager.setMoney(moneyService);
        shopService.buyItem("upgrade");
        assertEquals(gameManager.getMoneyAmount(), 850.0);
        assertEquals(gameManager.getAvailableUpgrades(), 1);
        shopService.sellItem("upgrade");
        assertEquals(gameManager.getMoneyAmount(), 1000.0);
        assertEquals(gameManager.getAvailableUpgrades(), 0);
    }
    /**
     * Test selling an upgrade with none
     */
    @Test void sellUpgradeNotEnoughTest(){
        GameManager gameManager = new GameManager();
        ShopService shopService = new ShopService(gameManager);
        MoneyService moneyService = new MoneyService();
        moneyService.editMoney(100.0);
        gameManager.setMoney(moneyService);
        shopService.sellItem("upgrade");
        assertEquals(gameManager.getMoneyAmount(), 100.0);
        assertEquals(gameManager.getAvailableUpgrades(), 0);
    }

}
