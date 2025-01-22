package br.com.ero.InventoryManagementSystem.service.impl;

import br.com.ero.InventoryManagementSystem.dto.LoginRequest;
import br.com.ero.InventoryManagementSystem.dto.RegisterRequest;
import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.dto.UserDTO;
import br.com.ero.InventoryManagementSystem.entity.User;
import br.com.ero.InventoryManagementSystem.enums.UserRole;
import br.com.ero.InventoryManagementSystem.exceptions.InvalidCredentialsException;
import br.com.ero.InventoryManagementSystem.exceptions.NotFoundException;
import br.com.ero.InventoryManagementSystem.repository.UserRepository;
import br.com.ero.InventoryManagementSystem.security.JwtUtils;
import br.com.ero.InventoryManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;

    @Override
    public Response registerUser(RegisterRequest registerRequest) {
        UserRole userRole = UserRole.MANAGER;
        if (registerRequest.getRole() != null) {
            userRole = registerRequest.getRole();
        }
        User userToSave = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(userRole)
                .build();

        userRepository.save(userToSave);

        return Response.builder()
                .status(200)
                .message("User created successfully")
                .build();
    }

    @Override
    public Response loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("Email Not Found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Password does not match");
        }

        String token = jwtUtils.generateToken(user.getEmail());

        return Response.builder()
                .status(200)
                .message("User logged in successfully")
                .role(user.getRole())
                .token(token)
                .expirationTime("6 months")
                .build();
    }

    @Override
    public Response getAllUsers() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));


        List<UserDTO> userDTOS = modelMapper.map(users, new TypeToken<List<UserDTO>>() {
        }.getType());

        userDTOS.forEach(user -> user.setTransactions(null));

        return Response.builder()
                .status(200)
                .message("Success")
                .users(userDTOS)
                .build();
    }

    @Override
    public User getCurrentLoggeddInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Email Not Found"));

        user.setTransactions(null);

        return user;
    }

    @Override
    public Response updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public Response deleteUser(Long id) {
        return null;
    }

    @Override
    public Response getUserTransactions(Long id) {
        return null;
    }
}
