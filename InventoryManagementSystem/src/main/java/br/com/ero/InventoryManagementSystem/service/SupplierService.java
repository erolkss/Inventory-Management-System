package br.com.ero.InventoryManagementSystem.service;

import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.dto.SupplierDTO;

public interface SupplierService {

    Response addSupplier(SupplierDTO supplierDTO);

    Response updateSupplier(Long id, SupplierDTO supplierDTO);

    Response getAllSuppliers();

    Response getSupplierById(Long id);

    Response deleteSupplier(Long id);
}
