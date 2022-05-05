package com.blog.services.Impl;

import com.blog.entitites.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDTO;
import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = this.DTOToCategory(categoryDTO);

        Category savedCategory = this.categoryRepo.save(category);

        return this.CategoryToDTO(savedCategory);

    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());

        //save again in the db

        this.categoryRepo.save(category);

        return this.CategoryToDTO(category);
    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));


        return this.CategoryToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {

        List<Category> categories = this.categoryRepo.findAll();

        List<CategoryDTO> categoryDTOList = categories.stream().map(category -> this.CategoryToDTO(category)).collect(Collectors.toList());

        return categoryDTOList;
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {

        // find by Id and then perform delete operation
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        this.categoryRepo.delete(category);

    }

    private CategoryDTO CategoryToDTO(Category category){
        CategoryDTO categoryDTO = this.modelMapper.map(category,CategoryDTO.class);

        return categoryDTO;
    }

    private Category DTOToCategory( CategoryDTO categoryDTO){
        Category category = this.modelMapper.map(categoryDTO,Category.class);

        return category;
    }
}


