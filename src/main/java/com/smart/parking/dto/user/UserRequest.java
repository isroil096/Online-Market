package com.smart.parking.dto.user;

import com.smart.parking.entity.constants.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {

    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;
    private Role role;
}
