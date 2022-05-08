package com.blog.repositories;

import com.blog.entitites.Category;
import com.blog.entitites.Post;
import com.blog.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    // implementation of this interface will be provided by spring at the run time
    // can add custom methods too


    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
