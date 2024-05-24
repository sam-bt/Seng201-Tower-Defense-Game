package seng201.team0.unittests.services;

import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Cart;
import seng201.team0.services.CartService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {
    @Test
    void testAllEmpty() {
        Cart coalCart = new Cart("Coal","Coal", 1.2,100);
        Cart ironCart = new Cart("Iron","Iron",1.2,100);
        Cart goldCart = new Cart("Gold","Gold",1.2,100);
        Cart gemCart = new Cart("Gem","Gem",1.2,100);
        Cart bonusCart = new Cart("Bonus","All",1.2,100);
        List<Cart> cartList = List.of(coalCart, ironCart, goldCart, gemCart, bonusCart);
        CartService.areAllCartsFull(cartList);
        assertFalse(CartService.areAllCartsFull(cartList));
    }
    @Test
    void testOneFull() {
        Cart coalCart = new Cart("Coal","Coal", 1.2,100);
        Cart ironCart = new Cart("Iron","Iron",1.2,100);
        Cart goldCart = new Cart("Gold","Gold",1.2,100);
        Cart gemCart = new Cart("Gem","Gem",1.2,100);
        Cart bonusCart = new Cart("Bonus","All",1.2,100);
        coalCart.increaseFillAmount(1000);
        List<Cart> cartList = List.of(coalCart, ironCart, goldCart, gemCart, bonusCart);
        CartService.areAllCartsFull(cartList);
        assertFalse(CartService.areAllCartsFull(cartList));
    }
    @Test
    void testAllFullWithBonus() {
        Cart coalCart = new Cart("Coal","Coal", 1.2,100);
        Cart ironCart = new Cart("Iron","Iron",1.2,100);
        Cart goldCart = new Cart("Gold","Gold",1.2,100);
        Cart gemCart = new Cart("Gem","Gem",1.2,100);
        Cart bonusCart = new Cart("Bonus","All",1.2,100);
        coalCart.increaseFillAmount(1000);
        ironCart.increaseFillAmount(1000);
        goldCart.increaseFillAmount(1000);
        gemCart.increaseFillAmount(1000);
        bonusCart.increaseFillAmount(1000);
        List<Cart> cartList = List.of(coalCart, ironCart, goldCart, gemCart, bonusCart);
        CartService.areAllCartsFull(cartList);
        assertTrue(CartService.areAllCartsFull(cartList));
    }
    @Test
    void testAllFullWithoutBonus() {
        Cart coalCart = new Cart("Coal","Coal", 1.2,100);
        Cart ironCart = new Cart("Iron","Iron",1.2,100);
        Cart goldCart = new Cart("Gold","Gold",1.2,100);
        Cart gemCart = new Cart("Gem","Gem",1.2,100);
        Cart bonusCart = new Cart("Bonus","All",1.2,100);
        coalCart.increaseFillAmount(1000);
        ironCart.increaseFillAmount(1000);
        goldCart.increaseFillAmount(1000);
        gemCart.increaseFillAmount(1000);
        List<Cart> cartList = List.of(coalCart, ironCart, goldCart, gemCart, bonusCart);
        CartService.areAllCartsFull(cartList);
        assertTrue(CartService.areAllCartsFull(cartList));
    }
}
