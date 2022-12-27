package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.District;

public interface DistrictRepository extends JpaRepository<District,Long> {
    
}
