package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.CartItem;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItem,Long>{
    
}
