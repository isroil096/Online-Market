package com.smart.parking.service;

import com.smart.parking.dto.ChangePasswordRequest;
import com.smart.parking.dto.UserRequest;
import com.smart.parking.dto.UserRequestDto;
import com.smart.parking.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    void changePassword(ChangePasswordRequest request, Principal connectedUser);

    UserRequest user(User user);

    List<User>findAll();

    void updateUser(Long id , UserRequestDto userRequest);

    void deleteUser(Long id);
}
