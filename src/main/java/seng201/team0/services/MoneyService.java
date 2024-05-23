package seng201.team0.services;

import seng201.team0.models.Money;

public class MoneyService {
    private final Money money;

    /**
     * Constructor
     */
    public MoneyService() {
        money = new Money();
        money.setMoney(10000);
    }

    /**
     * Increment our counter by one
     */
    public void editMoney(double amount) {
        if (amount <0) {
            if (money.getAmount() + amount < 0) {
                money.setMoney(0);
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
