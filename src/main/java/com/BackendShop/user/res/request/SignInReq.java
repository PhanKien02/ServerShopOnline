package com.BackendShop.user.res.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInReq {
    
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    @NotBlank
    private String password;

}
