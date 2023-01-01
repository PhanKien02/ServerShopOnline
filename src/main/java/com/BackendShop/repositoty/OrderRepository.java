package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
