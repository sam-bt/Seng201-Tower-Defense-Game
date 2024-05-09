package seng201.team0.models;

public class Money {
    private int money;

    /**
     * Constructor
     */
    public Money() {
        money = 0;
    }

    /**
     * Get current counter count
     * @return Current count
     */
    public int getAmount() {
        return money;
    }


    /**
     * Set current counter count
     * @param value Value of counter
     */
    public void setMoney(int value) {
        money += value;
    }
}
