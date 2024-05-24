package seng201.team0.models;

import seng201.team0.services.DifficultyService;

import java.util.List;
import java.util.Objects;

/**
 * The RoundOne class representing the first round in the game, handling the actions performed within the round
 * and tracking the state of various carts and towers.
 */
public class RoundOne {
    /**
     * The cart for coal.
     */
    private final Cart coalCart;

    /**
     * The cart for iron.
     */
    private final Cart ironCart;

    /**
     * The cart for gold.
     */
    private final Cart goldCart;

    /**
     * The number of actions left in the round.
     */
    private int actionsLeft;

    /**
     * The total number of actions available in the round.
     */
    private final int numActions = 2;

    /**
     * Constructs a RoundOne object with the specified difficulty and track length.
     *
     * @param difficulty The difficulty service providing the difficulty level.
     * @param trackLength The length of the track for the carts.
     */
    public RoundOne(final DifficultyService difficulty, final int trackLength) {
        coalCart = new Cart("Coal", "Coal", difficulty.getDifficulty(), trackLength);
        ironCart = new Cart("Iron", "Iron", difficulty.getDifficulty(), trackLength);
        goldCart = new Cart("Gold", "Gold", difficulty.getDifficulty(), trackLength);
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
    public void useAction(final Tower usedTower, final List<Cart> cartList, final Tower[] towerList) {
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
     * Advances the game to the next frame, updating the distance traveled by the carts
     * and resetting the number of actions left.
     *
     * @param cartList The list of carts to be updated.
     * @param towerList The list of towers to be updated.
     */
    public void nextFrame(final List<Cart> cartList, final Tower[] towerList) {
        for (Tower tower : towerList) {
            tower.actionUsed();
        }
        for (Cart cart : cartList) {
            cart.increaseDistance();
        }
        actionsLeft = numActions;
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
    public boolean roundEnded(final List<Cart> cartList) {
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
    public boolean isCartFillable(final List<Cart> cartList, final Tower selectedTower) {
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
    public boolean roundWon(final List<Cart> cartList) {
        for (Cart cart : cartList) {
            if (!cart.isCartSuccess()) {
                return false;
            }
        }
        return true;
    }
}
