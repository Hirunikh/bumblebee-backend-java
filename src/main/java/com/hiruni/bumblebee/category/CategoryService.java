package com.hiruni.bumblebee.category;

import com.hiruni.bumblebee.config.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    public void deleteCategory(Integer categoryID) {
        boolean exists = categoryRepository.existsById(categoryID);
        if(!exists){
            throw new ApiError("Category with this ID does not exist", HttpStatus.BAD_REQUEST);
        }
        categoryRepository.deleteById(categoryID);
    }
    @Transactional
    public void updateCategory(Integer categoryID, String newCategoryName) {
        Category category = categoryRepository.findByCategoryID(categoryID)
                .orElseThrow( () -> new ApiError("This Category does not exist.", HttpStatus.BAD_REQUEST));
        if (newCategoryName != null && newCategoryName.length() > 0 && !newCategoryName.equals(category.getCategoryName())){
            category.setCategoryName(newCategoryName);
            categoryRepository.save(category);
        }

    }
}
