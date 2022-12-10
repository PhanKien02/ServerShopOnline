package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
