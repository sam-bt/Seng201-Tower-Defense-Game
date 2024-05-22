package seng201.team0.services;

import seng201.team0.models.Cart;

import java.util.List;

public class CartService {
    public static boolean areAllCartsFull(List<Cart> cartList) { //checks all but the bonus cart
        for (Cart cart: cartList) {
            if (cart.isFull() == false && cart.getCartName() != "Bonus") {
                return false;
            }
        }
        return true;
    }
}
