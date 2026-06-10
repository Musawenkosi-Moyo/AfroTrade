package com.apexion.controller;

// End Points for the Application Cart to Function

import com.apexion.model.Cart;
import com.apexion.model.CartItems;
import com.apexion.model.Product;
import com.apexion.model.User;
import com.apexion.request.AddItemRequest;
import com.apexion.response.ApiResponse;
import com.apexion.service.CartItemService;
import com.apexion.service.CartService;
import com.apexion.service.ProductService;
import com.apexion.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = cartService.findUserCart(user);

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);

    }

    @PutMapping ("/add")
    public ResponseEntity<CartItems> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        //Serching for the product that need to be added in the database
        Product product = productService.findProductById(req.getProductId());

        //Adding the product to the Cart when it has been found
        CartItems items = cartService.addCartItem(user, product, req.getSize(), req.getQuantity());

        ApiResponse res = new ApiResponse();
        res.setMessage("Item added to Cart");

        return new ResponseEntity<>(items, HttpStatus.ACCEPTED);

    }

    @DeleteMapping ("/item/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItemHandler(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        cartItemService.removeCartItem(user.getId(), cartItemId);

        ApiResponse res = new ApiResponse();
        res.setMessage("Item removed from the Cart");

        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);

    }

    @PutMapping ("/item/{cartItemId}")
    public ResponseEntity<CartItems> updateCartItemHander(@PathVariable Long cartItemId,@RequestBody CartItems cartItems, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);


        CartItems updateCartItems = null;
        if(cartItems.getQuantity()>0){
            updateCartItems = cartItemService.updateCartItem(user.getId(),cartItemId,cartItems);
        }


        return new ResponseEntity<>(updateCartItems, HttpStatus.ACCEPTED);

    }

}
