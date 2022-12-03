package com.BackendShop.repositoty;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import com.BackendShop.domain.User;

public interface UserRepositoty extends JpaAttributeConverter<User, Long> {

}
