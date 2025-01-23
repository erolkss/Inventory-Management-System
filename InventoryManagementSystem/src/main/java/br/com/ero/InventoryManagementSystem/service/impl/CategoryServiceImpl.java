package br.com.ero.InventoryManagementSystem.service.impl;

import br.com.ero.InventoryManagementSystem.dto.CategoryDTO;
import br.com.ero.InventoryManagementSystem.dto.Response;
import br.com.ero.InventoryManagementSystem.entity.Category;
import br.com.ero.InventoryManagementSystem.repository.CategoryRepository;
import br.com.ero.InventoryManagementSystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response createCategory(CategoryDTO categoryDTO) {
        Category categoryToSave = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(categoryToSave);

        return Response.builder()
                .status(200)
                .message("Category created successfully")
                .build();
    }

    @Override
    public Response getAllCategories() {
        return null;
    }

    @Override
    public Response getCategoryById(Long id) {
        return null;
    }

    @Override
    public Response updateCategory(Long id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public Response deleteCategory(Long id) {
        return null;
    }
}
