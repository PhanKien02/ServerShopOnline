package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.OrderDetail;

public interface OrderDetailRepository  extends JpaRepository<OrderDetail,Long>{
    
}
