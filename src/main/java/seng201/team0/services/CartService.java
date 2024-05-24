package seng201.team0.services;

import seng201.team0.models.Cart;

import java.util.List;
import java.util.Objects;

/**
 * Class that provides methods for carts in the game.
 */
public class CartService {
    /**
     * Checks if all carts except the bonus cart are full.
     *
     * @param cartList The list of carts to be checked.
     * @return returns true if all carts except the bonus cart are full, false otherwise.
     */
    public static boolean areAllCartsFull(List<Cart> cartList) {
        for (Cart cart : cartList) {
            if (!cart.isFull() && !Objects.equals(cart.getCartName(), "Bonus")) {
                return false;
            }
        }
        return true;
    }
}
