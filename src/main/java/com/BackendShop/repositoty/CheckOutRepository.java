package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.CheckOut;

@Repository
public interface CheckOutRepository extends JpaRepository <CheckOut,Long> {
    
}
