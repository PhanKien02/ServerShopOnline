package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.OrderDetail;

@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail,Long>{
    
}
