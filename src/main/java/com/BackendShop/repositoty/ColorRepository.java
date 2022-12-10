package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
