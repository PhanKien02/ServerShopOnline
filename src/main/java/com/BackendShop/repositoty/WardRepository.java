package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Ward;

public interface WardRepository extends JpaRepository<Ward,Long> {
    
}
