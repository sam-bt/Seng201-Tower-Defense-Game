package seng201.team0.models;

public class Money {
    private double money;

    /**
     * Constructor
     */
    public Money() {
        money = 0;
    }

    /**
     * Get current counter count
     *
     * @return Current count
     */
    public double getAmount() {
        return money;
    }


    /**
     * Set current counter count
     *
     * @param value Value of counter
     */
    public void setMoney(double value) {
        money += value;
    }
}
