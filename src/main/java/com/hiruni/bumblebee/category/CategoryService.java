package com.hiruni.bumblebee.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }


    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

}
