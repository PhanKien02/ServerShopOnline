package com.BackendShop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackendShop.domain.Trademark;

@Repository
public interface TrademarkRepository extends JpaRepository<Trademark, Long> {

}
