package com.BackendShop.user.res.response;

import java.util.Set;

import com.BackendShop.domain.Authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRes {
    
    private Long id;

    private String fullname;
    
    private String sex;
   
    private boolean activated;

    private String avatar;

    private String phone;
   
    private String email;
   
    private int age;

    Set<Authorization> role;
}
