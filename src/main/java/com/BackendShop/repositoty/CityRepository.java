package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.City;

public interface CityRepository extends JpaRepository<City,Long> {
    
}
