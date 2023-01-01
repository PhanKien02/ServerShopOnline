package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BackendShop.domain.Trademark;

public interface TrademarkRepository extends JpaRepository<Trademark, Long> {

}
