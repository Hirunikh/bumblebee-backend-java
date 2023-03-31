package com.hiruni.bumblebee.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/Category")
public class CategoryController {

    private  final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @PostMapping
    public void CreateNewCategory(@RequestBody Category category) {
        categoryService.addNewCategory(category);
    }
}

