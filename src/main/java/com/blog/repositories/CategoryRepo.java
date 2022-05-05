package com.blog.repositories;

import com.blog.entitites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CategoryRepo  extends JpaRepository<Category,Integer> {

    // repository for category api
}
