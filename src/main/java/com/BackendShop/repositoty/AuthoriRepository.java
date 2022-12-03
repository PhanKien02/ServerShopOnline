package com.BackendShop.repositoty;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import com.BackendShop.domain.Authorization;

public interface AuthoriRepository extends JpaAttributeConverter<Authorization, Long> {

}
