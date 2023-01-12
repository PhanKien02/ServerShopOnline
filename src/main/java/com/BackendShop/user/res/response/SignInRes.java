package com.BackendShop.user.res.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SignInRes {
    
    private String token;

    private UserRes user;
}
