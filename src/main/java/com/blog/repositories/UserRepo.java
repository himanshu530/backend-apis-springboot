package com.blog.repositories;

import com.blog.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    //repository for user api

}
