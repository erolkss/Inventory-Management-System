package br.com.ero.InventoryManagementSystem.repository;

import br.com.ero.InventoryManagementSystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
