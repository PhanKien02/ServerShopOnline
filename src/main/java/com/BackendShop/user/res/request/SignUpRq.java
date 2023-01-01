package com.BackendShop.user.res.request;

import com.BackendShop.domain.enumeration.RoleUser;

import lombok.Data;
@Data
public class SignUpRq {

    private String username;

    private String password;

    private String fullname;

    private String phone;

    private String email;

    private RoleUser[] roles = {RoleUser.ADMIN};
}
