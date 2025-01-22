package br.com.ero.InventoryManagementSystem.service;

import br.com.ero.InventoryManagementSystem.dto.LoginRequest;
import br.com.ero.InventoryManagementSystem.dto.RegisterRequest;
import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.dto.UserDTO;
import br.com.ero.InventoryManagementSystem.entity.User;

public interface UserService {

    Response registerUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    Response getAllUsers();

    User getCurrentLoggeddInUser();

    Response updateUser(Long id, UserDTO userDTO);

    Response deleteUser(Long id);

    Response getUserTransactions(Long id);

}
