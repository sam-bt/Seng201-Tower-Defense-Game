package seng201.team0.models;

import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

import java.util.List;
import java.util.Objects;

public class RoundOne {
    private final Cart CoalCart;
    private final Cart IronCart;
    private final Cart GoldCart;
    private int actionsLeft;
    boolean roundWon;
    boolean roundEnded;
    private final int numActions = 2;
    public RoundOne(MoneyService money, double points, DifficultyService difficulty, int trackLength){
        this.CoalCart = new Cart("Coal","Coal", difficulty.getDifficulty(),trackLength);
        this.IronCart = new Cart("Iron","Iron",difficulty.getDifficulty(),trackLength);
        this.GoldCart = new Cart("Gold","Gold",difficulty.getDifficulty(),trackLength);
        this.actionsLeft = numActions;
    }
    public void useAction(Tower usedTower, List<Cart> cartList, Tower[] towerList){
        for (Tower tower:towerList) {
            tower.actionUsed();
        }
        usedTower.use();
        for (Cart cart: cartList) {
            if (Objects.equals(cart.getResourceType(), usedTower.getFillType())) {
            cart.increaseFillAmount(usedTower.getFillAmount());
            }
        }
        this.actionsLeft -= 1;
    }
    public void nextFrame(List<Cart> cartList, Tower[] towerList) {
        for (Tower tower:towerList) {
            tower.actionUsed();
        }
        for (Cart cart: cartList) {
            cart.increaseDistance();
        }
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

    public int getNumActions(){
        return this.numActions;
    }
    public boolean roundEnded(List<Cart> cartList){
        System.out.println(cartList.size());
        for (Cart cart: cartList) {
            if (cart.isEndReached() && !cart.isFull()) {
                return true;
            }
        }
        for (Cart cart: cartList) {
            System.out.println("end reached? "+cart.isEndReached());
            System.out.println("full? "+cart.isFull());
            if (!cart.isEndReached() && !cart.isFull()){
                return false;
            }
        }
        return true;
    }
    public boolean isCartFillable(List<Cart> cartList, Tower selectedTower) {
        for (Cart cart: cartList) {
            if (Objects.equals(cart.getResourceType(), selectedTower.getFillType())) {
                if (!cart.isFull()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean roundWon(List<Cart> cartList) {
        for (Cart cart: cartList) {
            System.out.println("success? "+cart.isCartSuccess());
            if (!cart.isCartSuccess()){
                return false;
            }
        }
        return true;
    }
}
