package com.smart.parking.service;

import com.smart.parking.dto.ChangePasswordRequest;
import com.smart.parking.dto.UserRequest;
import com.smart.parking.dto.UserRequestDto;
import com.smart.parking.entity.User;
import com.smart.parking.exception.BadRequest;
import com.smart.parking.repository.SellerRepository;
import com.smart.parking.repository.TokenRepository;
import com.smart.parking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final SellerRepository carRepository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }

    public UserRequest user(User user) {
        return UserRequest.builder()
                .id(user.getId())
                .phoneNumber(user.getPhoneNumber())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .role(user.getRole())
                .build();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateUser(Long id, UserRequestDto userRequest) {
        User user = repository.findById(id).get();
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setRole(userRequest.getRole());
        repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        Optional<User> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new BadRequest("User not found");
        } else {
            carRepository.deleteByUserId(id);
            tokenRepository.deleteByUserId(id);
            repository.delete(byId.get());
        }
    }

    
}
