package br.com.ero.InventoryManagementSystem.service.impl;

import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.dto.SupplierDTO;
import br.com.ero.InventoryManagementSystem.entity.Supplier;
import br.com.ero.InventoryManagementSystem.repository.SupplierRepository;
import br.com.ero.InventoryManagementSystem.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response addSupplier(SupplierDTO supplierDTO) {
        Supplier supplierToSave = modelMapper.map(supplierDTO, Supplier.class);
        supplierRepository.save(supplierToSave);

        return Response.builder()
                .status(200)
                .message("Supplier created successfully")
                .build();
    }

    @Override
    public Response updateSupplier(Long id, SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public Response getAllSuppliers() {
        return null;
    }

    @Override
    public Response getSupplierById(Long id) {
        return null;
    }

    @Override
    public Response deleteSupplier(Long id) {
        return null;
    }

}
