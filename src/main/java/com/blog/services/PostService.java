package com.blog.services;

import com.blog.entitites.Post;
import com.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO,Integer userId,Integer categoryId);

    Post updatePost(PostDTO postDTO,Integer postId);

    List<PostDTO> getAllPosts();

    Post getPostById(Integer postId);

    void deletePost(Integer postId);

    // get all post by category
    List<PostDTO> getPostsByCategory(Integer categoryId);

    // get all posts by user

    List<Post> getPostsByUser(Integer userId);

    //search posts by particular keyword

    List<Post> searchPosts(String keyword);

}
