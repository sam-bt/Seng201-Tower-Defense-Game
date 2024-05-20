package seng201.team0.models;

import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

public class RoundOne {
    private final Cart CoalCart;
    private final Cart IronCart;
    private final Cart GoldCart;
    public RoundOne(MoneyService money, double points, DifficultyService difficulty, int trackLength){
        this.CoalCart = new Cart("Coal","Coal");
        this.IronCart = new Cart("Iron","Iron");
        this.GoldCart = new Cart("Gold","Gold");
    }
    public void useAction(Tower usedTower){

    }

    public Cart getCoalCart() {
        return CoalCart;
    }

    public Cart getIronCart() {
        return IronCart;
    }

    public Cart getGoldCart() {
        return GoldCart;
    }
}
