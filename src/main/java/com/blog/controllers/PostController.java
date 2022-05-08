package com.blog.controllers;

import com.blog.entitites.Post;
import com.blog.payloads.PostDTO;
import com.blog.services.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    //TODO: Controller returning incorrect response but db getting populated correctly

    @PostMapping("/user/{userId}/category/{categoryId}/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId){

        PostDTO postDTO1 = this.postService.createPost(postDTO,userId,categoryId);

        return new ResponseEntity<>(postDTO1, HttpStatus.CREATED);

    }

    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){

        List<PostDTO> postDTOList = this.postService.getAllPosts();

        return new ResponseEntity<>(postDTOList,HttpStatus.OK);

    }





}
