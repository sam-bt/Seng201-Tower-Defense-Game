package seng201.team0.models;

import java.util.Random;
public class Tower {
    private int health;
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

    Tower(int initialHealth,boolean owned,String fillType, int fillAmount, int reloadSpeed, String towerName, double difficulty) {
        this.health = initialHealth;
        this.owned = owned;
        this.level = 1;
        this.breakChance = 0;
        this.fillType = fillType;
        this.fillAmount = fillAmount;
        this.reloadSpeed = reloadSpeed;
        this.broken = false;
        this.towerName = towerName;
        Random buyRND = new Random();
        double buyRandomInt = buyRND.nextInt(1000)+100 * difficulty; // buy price scales with difficulty
        this.buyPrice = Math.round(buyRandomInt*100.0)/100.0;
        this.sellPrice = Math.round((buyRandomInt/2)*100.0)/100.0;
    }
    public void setHealth(int amount) {
        if (health + amount > 100) {
            health = 100; }
        else if (health + amount < 0) {
            health = 0; }
        else { health += amount; }
    }
    public void breakTower() {
        broken = true;
    }
    public void buyTower(){
        owned = true;
    }
    public void sellTower(){
        owned = false;
    }
    public void levelUp(){ // TODO improve stats
        level += 1;
    }
    public void increaseBreakChance(int amount) {
        breakChance += amount;
    }
    public int getHealth() {
        return health;
    }
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
    public String getTowerName(){
        return towerName;
    }

}
