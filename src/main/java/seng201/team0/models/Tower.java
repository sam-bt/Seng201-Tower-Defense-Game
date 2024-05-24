package seng201.team0.models;

import java.util.Random;

/**
 * The Tower model represents a tower in the game, implementing various properties
 * and actions that can be performed on or by the tower.
 */
public class Tower implements Purchasable {

    /**
     * The current health of the tower.
     */
    private int health;

    /**
     * The maximum health of the tower.
     */
    private int maxHealth;

    /**
     * Indicates if the tower is owned.
     */
    private boolean owned;

    /**
     * The towers level.
     */
    private int level;

    /**
     * The chance of the tower breaking.
     */
    private int breakChance;

    /**
     * The type of resource the tower fills.
     */
    private final String fillType;

    /**
     * The amount of resource the tower can fill.
     */
    private int fillAmount;

    /**
     * The reload speed of the tower.
     */
    private final int reloadSpeed;

    /**
     * The price to buy the tower.
     */
    private final double buyPrice;

    /**
     * The sell price of the tower.
     */
    private final double sellPrice;

    /**
     * Indicates if the tower is broken.
     */
    private boolean broken;

    /**
     * The name of the tower.
     */
    private final String towerName;

    /**
     * The random number generator used for tower actions.
     */
    private final Random rnd;

    /**
     * Indicates if the tower is usable.
     */
    private boolean isUsable;

    /**
     * The number of actions until the tower is usable again.
     */
    private int actionsUntilUsable;

    /**
     * Constructs a Tower object.
     *
     * @param initialHealth The initial health of the tower.
     * @param owned Indicates if the tower is owned.
     * @param fillType The type of resource the tower fills.
     * @param fillAmount The amount of resource the tower can fill.
     * @param reloadSpeed The reload speed of the tower.
     * @param towerName The name of the tower.
     * @param price The price of the tower.
     */
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

    /**
     * Breaks the tower, setting its broken status to true.
     */
    public void breakTower() {
        broken = true;
    }

    /**
     * Sets the tower as owned.
     */
    public void setOwned() {
        owned = true;
    }

    /**
     * Sets the tower as not owned.
     */
    public void setNotOwned() {
        owned = false;
    }

    /**
     * Buys the tower, setting its owned status to true.
     */
    public void buy() {
        owned = true;
    }

    /**
     * Sells the tower, setting its owned status to false.
     */
    public void sell() {
        owned = false;
    }

    /**
     * Uses an upgrade on the tower, increasing its level, maximum health, and fill amount.
     */
    public void useUpgrade() {
        level += 1;
        maxHealth += 5;
        fillAmount += 3;
    }

    /**
     * Gets the current health of the tower.
     *
     * @return The current health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the maximum health of the tower.
     *
     * @return The maximum health.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Gets the owned status of the tower.
     *
     * @return true if the tower is owned, false otherwise.
     */
    public boolean getOwned() {
        return owned;
    }

    /**
     * Gets the level of the tower.
     *
     * @return The level of the tower.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the break chance of the tower.
     *
     * @return The break chance.
     */
    public int getBreakChance() {
        return breakChance;
    }

    /**
     * Gets the type of resource the tower fills.
     *
     * @return The fill type.
     */
    public String getFillType() {
        return fillType;
    }

    /**
     * Gets the amount of resource the tower can fill.
     *
     * @return The fill amount.
     */
    public int getFillAmount() {
        return fillAmount;
    }

    /**
     * Gets the reload speed of the tower.
     *
     * @return The reload speed.
     */
    public int getReloadSpeed() {
        return reloadSpeed;
    }

    /**
     * Gets the buy price of the tower.
     *
     * @return The buy price.
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * Gets the sell price of the tower.
     *
     * @return The sell price.
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * Gets the broken status of the tower.
     *
     * @return true if the tower is broken, false otherwise.
     */
    public boolean getBroken() {
        return broken;
    }

    /**
     * Revives the tower, resetting its broken status and break chance.
     */
    public void useRevive() {
        broken = false;
        breakChance = 0;
        if (health == 0) {
            health = 5;
        }
    }

    /**
     * Gets the name of the tower.
     *
     * @return The name of the tower.
     */
    public String getTowerName() {
        return towerName;
    }

    /**
     * Heals the tower, increasing its health by a set amount.
     */
    public void useHeal() {
        if (health + 5 >= maxHealth) {
            health = maxHealth;
        } else {
            health += 5;
        }
    }

    /**
     * Uses the tower, updating its usability status, break chance, and health.
     */
    public void use() {
        actionsUntilUsable = reloadSpeed;
        breakChance += rnd.nextInt(4);
        health -= rnd.nextInt(10);
        if (health <= 0) {
            health = 0;
            breakTower();
        }
        isUsable = false;
    }

    /**
     * Gets the number of actions until the tower is usable again.
     *
     * @return The number of actions until usable.
     */
    public int getActionsUntilUsable() {
        return actionsUntilUsable;
    }

    /**
     * Updates the actions used.
     */
    public void actionUsed() {
        if (actionsUntilUsable == 1) {
            isUsable = true;
            actionsUntilUsable = 0;
        } else if (actionsUntilUsable != 0) {
            actionsUntilUsable -= 1;
        }
    }

    /**
     * Gets the usability status of the tower.
     *
     * @return true if the tower is usable, false otherwise.
     */
    public boolean isUsable() {
        return isUsable;
    }

    /**
     * Sets the tower as usable.
     */
    public void setUsable() {
        actionsUntilUsable = 0;
        isUsable = true;
    }

    /**
     * Sets the health of the tower.
     *
     * @param health The health to be set.
     */
    public void setHealth(int health) {
        this.health = health;
    }
}