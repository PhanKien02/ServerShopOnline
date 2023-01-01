package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Color;

public interface ColorRepository extends JpaRepository<Color, Long>{

}
