package seng201.team0.models;

/**
 * Interface that defines the attributes of a purchasable tower.
 */
public interface Purchasable {
    /**
     * A purchasable item must also be able to be sold.
     */
    void sell();
    /**
     * A purchasable item must be able to be bought.
     */
    void buy();
    /**
     * A purchasable item must have a sell price.
     *
     * @return the sell price of the purchasable item
     */
    double getSellPrice();
    /**
     * A purchasable item must have a buy price.
     *
     * @return the buy price of the purchasable item
     */
    double getBuyPrice();
}
