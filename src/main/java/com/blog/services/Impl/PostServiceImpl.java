package com.blog.services.Impl;

import com.blog.entitites.Category;
import com.blog.entitites.Post;
import com.blog.entitites.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.PostDTO;
import com.blog.payloads.UserDTO;
import com.blog.repositories.CategoryRepo;
import com.blog.repositories.PostRepo;
import com.blog.repositories.UserRepo;
import com.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;   // to convert postdto to post and vice versa during run time

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user Id",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category Id",categoryId));

        Post post = this.modelMapper.map(postDTO,Post.class);


        // get the userId and categoryId from client and validate them by autowiring userRepo and categoryRepo.
        // If valid , then create post else throw the required custom exception
        // id: auto generated. date being set here. title and content: mapped from dto. user and category fetched from client and validated

        post.setImageName("defaultImage.png");
        post.setDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost =  this.postRepo.save(post);
        return this.modelMapper.map(savedPost,PostDTO.class);
    }

    @Override
    public Post updatePost(PostDTO postDTO, Integer postId) {


        return null;
    }

    @Override
    public List<PostDTO> getAllPosts() {

        List<Post> postList = this.postRepo.findAll();

        // convert each to postDTO

        List<PostDTO> postDTOList = postList.stream().map(post -> this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());


        return postDTOList;


    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {


        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
