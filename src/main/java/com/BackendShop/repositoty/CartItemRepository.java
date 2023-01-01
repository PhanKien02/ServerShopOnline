package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.CartItem;


public interface CartItemRepository  extends JpaRepository<CartItem,Long>{
    
}
