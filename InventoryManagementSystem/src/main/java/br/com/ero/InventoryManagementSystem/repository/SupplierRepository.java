package br.com.ero.InventoryManagementSystem.repository;

import br.com.ero.InventoryManagementSystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
