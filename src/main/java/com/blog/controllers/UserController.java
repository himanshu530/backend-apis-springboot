package com.blog.controllers;

import com.blog.entitites.User;
import com.blog.payloads.UserDTO;
import com.blog.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // TODO: Create controller endpoints
    @Autowired
    private UserServiceImpl userService;

    //create new user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        UserDTO userDTO1 =  this.userService.createUser(userDTO);

        return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);

    }

    // Update existing user
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@RequestParam Integer userId){

        UserDTO userDTO1 = this.userService.updateUser(userDTO,userId);

        return ResponseEntity.ok(userDTO1);
    }

    //Get user by Id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "userId") Integer userId){

        UserDTO userDTO = this.userService.getUserById(userId);

        return ResponseEntity.ok(userDTO);

    }

    //get all users
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        List<UserDTO> userDTOList = this.userService.getAllUsers();

        return  ResponseEntity.ok(userDTOList);

    }

    //delete user
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer userId){

        this.userService.deleteUser(userId);

        return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);

    }

}
