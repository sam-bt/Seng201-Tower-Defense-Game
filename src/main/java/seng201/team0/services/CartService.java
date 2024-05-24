package seng201.team0.services;

import seng201.team0.models.Cart;

import java.util.List;

/**
 * Class that rovides methods for carts in the game.
 */
public class CartService {
    /**
     * Checks if all carts except the bonus cart are full.
     * @param cartList The list of carts to be checked.
     * @return {@code true} if all carts except the bonus cart are full, {@code false} otherwise.
     */
    public static boolean areAllCartsFull(List<Cart> cartList) { //checks all but the bonus cart
        for (Cart cart: cartList) {
            if (cart.isFull() == false && cart.getCartName() != "Bonus") {
                return false;
            }
        }
        return true;
    }
}
