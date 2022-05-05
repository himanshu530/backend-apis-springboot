package com.blog.services.Impl;

import com.blog.entitites.User;
import com.blog.payloads.UserDTO;
import com.blog.repositories.UserRepo;
import com.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = this.DTOtoUser(userDTO);   // convert to user for saving into the db

        User savedUser =  this.userRepo.save(user);
        return this.UserToDTO(savedUser);    // convert back to dto for transferring it to controller
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {

            User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setAbout(userDTO.getAbout());

            this.userRepo.save(user);

            return this.UserToDTO(user);


    }

    @Override
    public UserDTO getUserById(Integer userId) {


            //User user = this.userRepo.getById(userId);
            User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
            return this.UserToDTO(user);


    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        List<UserDTO> userDTOS =  users.stream().map(user->this.UserToDTO(user)).collect(Collectors.toList());
        return userDTOS;

    }

    @Override
    public void deleteUser(Integer userId) {

        User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        this.userRepo.delete(user);

    }

    private User DTOtoUser(UserDTO userDTO){

//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setAbout(userDTO.getAbout());

        User user = this.modelMapper.map(userDTO,User.class);

        return user;


    }

    private UserDTO UserToDTO(User user){

//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setAbout(user.getAbout());

        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);

        return userDTO;

    }
}
