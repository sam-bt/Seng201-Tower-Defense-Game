package seng201.team0.models;

import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

public class RoundOne {
    private final Cart CoalCart;
    private final Cart IronCart;
    private final Cart GoldCart;
    private int actionsLeft;
    private int numActions;
    public RoundOne(MoneyService money, double points, DifficultyService difficulty, int trackLength){
        this.CoalCart = new Cart("Coal","Coal");
        this.IronCart = new Cart("Iron","Iron");
        this.GoldCart = new Cart("Gold","Gold");
        this.numActions = 5 - (int) difficulty.getDifficulty();
        this.actionsLeft = numActions;
    }
    public void useAction(Tower usedTower, Cart usedCart){
        usedTower.nextFrame();
        usedTower.increaseBreakChance();
        usedCart.increaseFillAmount(usedTower.getFillAmount());
    }
    public void nextFrame() { //TODO take carts and towers, increase distance, reload etc
        actionsLeft = numActions;
    }

    public Cart getCoalCart() {
        return this.CoalCart;
    }

    public Cart getIronCart() {
        return this.IronCart;
    }

    public Cart getGoldCart() {
        return this.GoldCart;
    }
    public int getActionsLeft(){
        return this.actionsLeft;
    }
    public void useAction(){
        if (actionsLeft > 0) {
        this.actionsLeft -= 1; }
    }
    public int getNumActions(){
        return this.numActions;
    }
}
