package seng201.team0.models;

import seng201.team0.services.DifficultyService;

import java.util.List;
import java.util.Objects;

/**
 * The Round model representing a round in the game.
 * Handles the actions performed within the round and tracks the states of various carts and towers.
 */
public class Round {

    /**
     * Cart for coal.
     */
    private final Cart coalCart;
    /**
     * Cart for iron.
     */
    private final Cart ironCart;

    /**
     * Cart for gold.
     */
    private final Cart goldCart;

    /**
     * cart for gem.
     */
    private final Cart gemCart;

    /**
     * Bonus cart for any resource.
     */
    private final Cart bonusCart;

    /**
     * The number of actions left for the round.
     */
    private int actionsLeft;

    /**
     * The total number of actions available per round.
     */
    private final int numActions = 2;

    /**
     * Constructs a Round object with the specified difficulty and track length.
     *
     * @param difficulty The difficulty service providing the difficulty level.
     * @param trackLength The length of the track for the carts.
     */
    public Round(DifficultyService difficulty, int trackLength) {
        coalCart = new Cart("Coal", "Coal", difficulty.getDifficulty(), trackLength);
        ironCart = new Cart("Iron", "Iron", difficulty.getDifficulty(), trackLength);
        goldCart = new Cart("Gold", "Gold", difficulty.getDifficulty(), trackLength);
        gemCart = new Cart("Gem", "Gem", difficulty.getDifficulty(), trackLength);
        bonusCart = new Cart("Bonus", "All", difficulty.getDifficulty(), trackLength);
        actionsLeft = numActions;
    }

    /**
     * Uses an action with a specified tower, updating the fill amount of the carts
     * and reducing the number of actions left.
     *
     * @param usedTower The tower being used for the action.
     * @param cartList The list of carts to be filled.
     * @param towerList The list of towers to be updated.
     */
    public void useAction(Tower usedTower, List<Cart> cartList, Tower[] towerList) {
        for (Tower tower : towerList) {
            tower.actionUsed();
        }
        usedTower.use();
        for (Cart cart : cartList) {
            if (Objects.equals(cart.getResourceType(), usedTower.getFillType())) {
                cart.increaseFillAmount(usedTower.getFillAmount());
            }
        }
        actionsLeft -= 1;
    }

    /**
     * Uses a bonus action with a specified tower, updating the fill amount of the bonus cart
     * and reducing the number of actions left.
     *
     * @param usedTower The tower being used for the action.
     * @param cartList The list of carts to be filled.
     * @param towerList The list of towers to be updated.
     */
    public void useBonusAction(Tower usedTower, List<Cart> cartList, Tower[] towerList) {
        for (Tower tower : towerList) {
            tower.actionUsed();
        }
        usedTower.use();
        cartList.get(4).increaseFillAmount(usedTower.getFillAmount());
        actionsLeft -= 1;
    }

    /**
     * Advances the game to the next frame, updating the distance traveled by the carts
     * and resetting the number of actions left.
     *
     * @param cartList The list of carts to be updated.
     * @param towerList The list of towers to be updated.
     */
    public void nextFrame(List<Cart> cartList, Tower[] towerList) {
        for (Tower tower : towerList) {
            tower.actionUsed();
        }
        for (Cart cart : cartList) {
            cart.increaseDistance();
        }
        actionsLeft = numActions;
    }

    /**
     * Returns the number of actions left for the round.
     *
     * @return The number of actions left.
     */
    public int getActionsLeft() {
        return actionsLeft;
    }

    /**
     * Resets the number of actions left to zero.
     */
    public void resetActions() {
        actionsLeft = 0;
    }

    /**
     * Checks if the round has ended based on the state of the carts.
     *
     * @param cartList The list of carts to be checked.
     * @return true if the round has ended, false otherwise.
     */
    public boolean roundEnded(List<Cart> cartList) {
        for (Cart cart : cartList) {
            if (cart.isEndReached() && !cart.isFull()) {
                return true;
            }
        }
        for (Cart cart : cartList) {
            if (!cart.isEndReached() && !cart.isFull()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a cart can be filled with the resources from the selected tower.
     *
     * @param cartList The list of carts to be checked.
     * @param selectedTower The selected tower.
     * @return true if a cart can be filled, false otherwise.
     */
    public boolean isCartFillable(List<Cart> cartList, Tower selectedTower) {
        for (Cart cart : cartList) {
            if (Objects.equals(cart.getResourceType(), selectedTower.getFillType())) {
                if (!cart.isFull()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the round is won based on the success state of the carts.
     *
     * @param cartList The list of carts to be checked.
     * @return true if the round is won, false otherwise.
     */
    public boolean roundWon(List<Cart> cartList) {
        for (Cart cart : cartList) {
            if (!cart.isCartSuccess()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the coal cart.
     *
     * @return The coal cart.
     */
    public Cart getCoalCart() {
        return coalCart;
    }

    /**
     * Returns the iron cart.
     *
     * @return The iron cart.
     */
    public Cart getIronCart() {
        return ironCart;
    }

    /**
     * Returns the gold cart.
     *
     * @return The gold cart.
     */
    public Cart getGoldCart() {
        return goldCart;
    }

    /**
     * Returns the gem cart.
     *
     * @return The gem cart.
     */
    public Cart getGemCart() {
        return gemCart;
    }

    /**
     * Returns the bonus cart.
     *
     * @return The bonus cart.
     */
    public Cart getBonusCart() {
        return bonusCart;
    }
}
