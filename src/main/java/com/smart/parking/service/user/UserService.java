package com.smart.parking.service.user;

import com.smart.parking.dto.ChangePasswordRequest;
import com.smart.parking.dto.UserRequest;
import com.smart.parking.entity.User;

import java.security.Principal;

public interface UserService {

    void changePassword(ChangePasswordRequest request, Principal connectedUser);

    UserRequest user(User user);
}
