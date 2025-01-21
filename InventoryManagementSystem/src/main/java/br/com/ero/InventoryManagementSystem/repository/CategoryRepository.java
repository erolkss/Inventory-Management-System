package br.com.ero.InventoryManagementSystem.repository;

import br.com.ero.InventoryManagementSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
