package com.apexion.service.impl;

import com.apexion.model.CartItems;
import com.apexion.model.User;
import com.apexion.repository.CartItemRepositiory;
import com.apexion.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepositiory cartItemRepositiory;

    @Override
    public CartItems updateCartItem(Long userId, Long id, CartItems cartItems) throws Exception {

        CartItems items = findCartItemById(id);

        User cartItemUser = items.getCart().getUser();

        if(cartItemUser.getId().equals(userId)){
            items.setQuantity(cartItems.getQuantity());
            items.setMrpPrice(items.getQuantity()*items.getProduct().getMrpPrice());
            items.setSellingPrice(items.getQuantity()*items.getProduct().getSellingPrice());
            return cartItemRepositiory.save(items);
        }
        throw new Exception("You cant update this Cart Item");
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws Exception {

        CartItems items = findCartItemById(cartItemId);

        User cartItemUser = items.getCart().getUser();

        if (cartItemUser.getId().equals(userId)){
            cartItemRepositiory.delete(items);
        }else {
            throw new Exception("Unable to delete Item");
        }
    }

    @Override
    public CartItems findCartItemById(Long id) throws Exception {
        return cartItemRepositiory.findById(id).orElseThrow(() ->
                new Exception("Cart Item not found"));
    }
}
