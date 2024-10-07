package com.nimapinfotech.ecommerce.nEcommerce.services;

import com.nimapinfotech.ecommerce.nEcommerce.errorhandler.ResourceNotFoundException;
import com.nimapinfotech.ecommerce.nEcommerce.models.Category;
import com.nimapinfotech.ecommerce.nEcommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails)
    {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + id));
        category.setName(categoryDetails.getName());
        // Update other fields as necessary
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id)
    {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for id: " + id));
        categoryRepository.delete(category);
    }

    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
}

