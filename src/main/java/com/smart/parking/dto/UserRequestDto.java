package com.smart.parking.dto;

import com.smart.parking.entity.constants.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;
    private Role role;
}
