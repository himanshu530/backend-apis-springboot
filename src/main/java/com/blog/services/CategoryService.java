package com.blog.services;

import com.blog.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    //update
    CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer categoryId);

    //get by Id
    CategoryDTO getCategoryById(Integer categoryId);

    // get all
    List<CategoryDTO> getAllCategory();

    //deleteById
    void deleteCategoryById(Integer categoryId);

}
