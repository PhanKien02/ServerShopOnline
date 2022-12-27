package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.CheckOut;

public interface CheckOutRepository extends JpaRepository <CheckOut,Long> {
    
}
