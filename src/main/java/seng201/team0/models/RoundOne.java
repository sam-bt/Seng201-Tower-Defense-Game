package seng201.team0.models;

import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

import java.util.List;
import java.util.Objects;

public class RoundOne {
    private final Cart coalCart;
    private final Cart ironCart;
    private final Cart goldCart;
    private int actionsLeft;
    boolean roundWon;
    boolean roundEnded;
    private final int numActions = 2;
    public RoundOne(DifficultyService difficulty, int trackLength){
        coalCart = new Cart("Coal","Coal", difficulty.getDifficulty(),trackLength);
        ironCart = new Cart("Iron","Iron",difficulty.getDifficulty(),trackLength);
        goldCart = new Cart("Gold","Gold",difficulty.getDifficulty(),trackLength);
        actionsLeft = numActions;
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
        actionsLeft -= 1;
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
        return coalCart;
    }

    public Cart getIronCart() {
        return ironCart;
    }

    public Cart getGoldCart() {
        return goldCart;
    }
    public int getActionsLeft(){
        return actionsLeft;
    }

    public int getNumActions(){
        return numActions;
    }
    public void resetActions() {actionsLeft = 0; }
    public boolean roundEnded(List<Cart> cartList){
        System.out.println(cartList.size());
        for (Cart cart: cartList) {
            if (cart.isEndReached() && !cart.isFull()) {
                return true;
            }
        }
        for (Cart cart: cartList) {
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
            if (!cart.isCartSuccess()){
                return false;
            }
        }
        return true;
    }
}
