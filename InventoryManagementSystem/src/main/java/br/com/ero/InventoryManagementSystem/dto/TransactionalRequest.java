package br.com.ero.InventoryManagementSystem.dto;

import br.com.ero.InventoryManagementSystem.entity.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionalRequest {

    @Positive(message = "Product id is required")
    private Long productId;
    @Positive(message = "Product id is required")
    private Integer quantity;
    private Long supplierId;
    private String description;

}
