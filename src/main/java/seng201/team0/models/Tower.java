package seng201.team0.models;

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

    public Tower(int initialHealth, boolean owned, String fillType, int fillAmount, int reloadSpeed, String towerName, double price) {
        health = initialHealth;
        maxHealth = initialHealth;
        this.owned = owned;
        level = 1;
        breakChance = 0;
        this.fillType = fillType;
        this.fillAmount = fillAmount;
        this.reloadSpeed = reloadSpeed;
        broken = false;
        this.towerName = towerName;
        isUsable = true;
        actionsUntilUsable = 0;
        rnd = new Random();
        buyPrice = price;
        sellPrice = price;
    }
    public void breakTower() {
        broken = true;
    }
    public void setOwned() {owned = true;}
    public void setNotOwned() {owned = false;}
    public void buy(){
        owned = true;
    }
    public void sell(){
        owned = false;
    }
    public void useUpgrade(){
        level += 1;
        maxHealth += 5;
        fillAmount += 2;
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
    public void useRevive() {
        broken = false;
        breakChance = 0;
        if (health == 0) {
            health = 5;
        }
    }
    public String getTowerName(){
        return towerName;
    }

    public void useHeal() {
        if (health + 5 >= maxHealth) {
            health = maxHealth;
        } else {
            health += 5;
        }
    }
    public void use(){
        actionsUntilUsable = reloadSpeed;
        breakChance += rnd.nextInt(4);
        health -= rnd.nextInt(10);
        if (health <=0) {
            health = 0;
            breakTower();
        }
        isUsable = false;
    }
    public int getActionsUntilUsable(){
        return actionsUntilUsable;
    }
    public void actionUsed(){
        if (actionsUntilUsable == 1) {
            isUsable = true;
            actionsUntilUsable = 0;
        }
        else if (actionsUntilUsable != 0) {
            actionsUntilUsable -= 1; }
    };
    public boolean isUsable(){
        return isUsable;
    }
    public void setUsable(){
        actionsUntilUsable = 0;
        isUsable = true;
    }
    public void setHealth(int health){
        this.health = health;
    }
}
