package br.com.ero.InventoryManagementSystem.dto;

import br.com.ero.InventoryManagementSystem.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    // Generic
    private int status;
    private String message;
    private String token;
    private UserRole role;
    private String expirationTime;

    // For pagination
    private Integer totalPages;
    private Long totalElement;

    // Data Output optional
    private UserDTO user;
    private List<UserDTO> users;

    private SupplierDTO supplier;
    private List<SupplierDTO> suppliers;

    private CategoryDTO category;
    private List<CategoryDTO> categories;

    private ProductDTO product;
    private List<ProductDTO> products;

    private TransactionalDTO transactional;
    private List<TransactionalDTO> transactions;

    private final LocalDateTime timeStamp = LocalDateTime.now();

}
