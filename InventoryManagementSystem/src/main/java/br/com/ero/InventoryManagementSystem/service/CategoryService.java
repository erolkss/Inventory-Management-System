package br.com.ero.InventoryManagementSystem.service;

import br.com.ero.InventoryManagementSystem.dto.CategoryDTO;
import br.com.ero.InventoryManagementSystem.dto.Response;

public interface CategoryService {

    Response createCategory(CategoryDTO categoryDTO);

    Response getAllCategories();

    Response getCategoryById(Long id);

    Response updateCategory(Long id, CategoryDTO categoryDTO);

    Response deleteCategory(Long id);

}
