package com.blog.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity  // creates a table with this name and attributes in the db
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name", nullable = false,length = 100)
    private String name;

    private String email;

    private String password;

    private String about;

    // More fields will be added while authenticating



}
