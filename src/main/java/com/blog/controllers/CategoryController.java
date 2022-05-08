package com.blog.controllers;


import com.blog.entitites.Category;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDTO;
import com.blog.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {



    @Autowired
    private CategoryServiceImpl categoryService;

    //create
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){

        CategoryDTO categoryDTO1 = this.categoryService.createCategory(categoryDTO);

        return new ResponseEntity<>(categoryDTO1, HttpStatus.CREATED);

    }

    // update existing category
    //TODO: Fix issue in update category endpoint
    @PutMapping("/update")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @RequestParam Integer categoryId){

        CategoryDTO categoryDTO1 = this.categoryService.updateCategory(categoryDTO,categoryId);

        return new ResponseEntity<>(categoryDTO1,HttpStatus.OK);

    }

    // get categorybyId

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "id") Integer categoryId){
        CategoryDTO categoryDTO = this.categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    // get all categories

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> categoryDTOList = this.categoryService.getAllCategory();

        return new ResponseEntity<>(categoryDTOList,HttpStatus.OK);
    }

    //delete category
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteCategory(@RequestParam Integer categoryId){

        this.categoryService.deleteCategoryById(categoryId);

        return new ResponseEntity<>(new ApiResponse("Category deleted",true),HttpStatus.OK);

    }





}
