package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.DeliveryAddress;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress,Long>{
    
}
