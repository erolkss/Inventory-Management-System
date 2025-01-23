package br.com.ero.InventoryManagementSystem.service.impl;

import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.dto.SupplierDTO;
import br.com.ero.InventoryManagementSystem.entity.Supplier;
import br.com.ero.InventoryManagementSystem.exceptions.NotFoundException;
import br.com.ero.InventoryManagementSystem.repository.SupplierRepository;
import br.com.ero.InventoryManagementSystem.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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
        Supplier existingCategory = supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("Supplier Not Found"));

        if (supplierDTO.getName() != null) existingCategory.setName(supplierDTO.getName());
        if (supplierDTO.getAddress() != null) existingCategory.setAddress(supplierDTO.getAddress());

        supplierRepository.save(existingCategory);

        return Response.builder()
                .status(200)
                .message("Supplier Successfully Updated")
                .build();
    }

    @Override
    public Response getAllSuppliers() {
        List<Supplier> categories = supplierRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<SupplierDTO> supplierDTOS = modelMapper.map(categories, new TypeToken<List<SupplierDTO>>() {
        }.getType());

        return Response.builder()
                .status(200)
                .message("Success")
                .suppliers(supplierDTOS)
                .build();
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
