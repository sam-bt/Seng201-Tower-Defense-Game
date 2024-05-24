package seng201.team0.services;

import seng201.team0.models.Money;

/**
 * Class that handles money related processes
 */
public class MoneyService {
    private final Money money;

    /**
     * Constructor
     */
    public MoneyService() {
        money = new Money();
    }

    /**
     * Increment our counter by one
     */
    public void editMoney(double amount) {
        if (amount <0) {
            if (money.getAmount() + amount < 0) {
                money.setMoney(-money.getAmount());
            }
            else {
                money.setMoney(amount);
            }
        }
        else {
            money.setMoney(amount);
        }
    }

    /**
     * Get the current count of the counter
     * @return Current count
     */
    public double getCurrentAmount() {
        return Math.round(money.getAmount());
    }
}
