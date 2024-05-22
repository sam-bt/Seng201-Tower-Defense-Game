package seng201.team0.models;

import seng201.team0.services.InventoryService;

import java.util.Random;
public class Tower implements Purchasable {
    private int health;
    private int maxHealth;
    private boolean owned;
    private int level;
    private int breakChance;
    private String fillType;
    private int fillAmount;
    private int reloadSpeed;
    private double buyPrice;
    private double sellPrice;
    private boolean broken;
    private String towerName;
    private Random rnd;
    private boolean isUsable;
    private int actionsUntilUsable;

    public Tower(int initialHealth, boolean owned, String fillType, int fillAmount, int reloadSpeed, String towerName, double difficulty) {
        this.health = initialHealth;
        this.maxHealth = initialHealth;
        this.owned = owned;
        this.level = 1;
        this.breakChance = 0;
        this.fillType = fillType;
        this.fillAmount = fillAmount;
        this.reloadSpeed = reloadSpeed;
        this.broken = false;
        this.towerName = towerName;
        this.isUsable = true;
        this.actionsUntilUsable = 0;
        rnd = new Random();
        double buyRandomInt = rnd.nextInt(1000)+100 * difficulty; // buy price scales with difficulty
        this.buyPrice = Math.round(buyRandomInt*100.0)/100.0;
        this.sellPrice = Math.round((buyRandomInt/2)*100.0)/100.0;
    }
    public void setHealth(int amount) {
        if (health + amount > maxHealth) {
            health = maxHealth; }
        else if (health + amount < 0) {
            health = 0;
            }
        else { health += amount; }
    }
    public void breakTower() {
        broken = true;
    }
    public void setOwned() {owned = true;}
    public void setNotOwned() {owned = false;}
    public void buy(){
        owned = true;
    } //TODO decrease money
    public void sell(){
        owned = false;
    } //TODO increase money
    public void useUpgrade(InventoryService inventoryService){
        level += 1;
        maxHealth += 5;
        inventoryService.consumeUpgrade();
    }
    public void increaseBreakChance(int amount) {
        breakChance += amount;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() { return maxHealth; }
    public boolean getOwned(){
        return owned;
    }
    public int getLevel(){
        return level;
    }
    public int getBreakChance(){
        return breakChance;
    }
    public void increaseBreakChance(){
        breakChance += 1;
    }
    public String getFillType(){
        return fillType;
    }
    public int getFillAmount(){
        return fillAmount;
    }
    public int getReloadSpeed(){
        return reloadSpeed;
    }
    public double getBuyPrice(){
        return buyPrice;
    }
    public double getSellPrice(){
        return sellPrice;
    }
    public boolean getBroken(){
        return broken;
    }
    public void setBroken() { broken = true; }
    public void useRevive(InventoryService inventoryService) {
        broken = false;
        if (health == 0) {
            health = 5;
        }
        inventoryService.consumeRevive();
    }
    public String getTowerName(){
        return towerName;
    }
    public void useHeal(InventoryService inventoryService) { // TODO: health item currently heals 5 as stand in value so update later on
        if (health + 5 >= maxHealth) {
            health = maxHealth;
        } else {
            health += 5;
        }
        inventoryService.consumeHeal();
    }
    public void use(){
        actionsUntilUsable = reloadSpeed;
        health -= rnd.nextInt(10);
        this.isUsable = false;
    }
    public int getActionsUntilUsable(){
        return this.actionsUntilUsable;
    }
    public void actionUsed(){
        if (actionsUntilUsable == 1) {
            this.isUsable = true;
            this.actionsUntilUsable = 0;
        }
        else if (actionsUntilUsable != 0) {
            this.actionsUntilUsable -= 1; }
    };
    public boolean isUsable(){

        return isUsable;
    }
}
