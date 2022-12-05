package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    
}
