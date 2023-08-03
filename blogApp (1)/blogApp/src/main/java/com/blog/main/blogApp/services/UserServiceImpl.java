package com.blog.main.blogApp.services;

import com.blog.main.blogApp.entity.User;
import com.blog.main.blogApp.exception.ResourceNotFoundException;
import com.blog.main.blogApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

     @Autowired
     private UserRepo userRepo;

    @Override
    public User Save(User user) {

        this.userRepo.save(user);
        return null;
    }

    @Override
    public List<User> getUser() {

        List<User> userList= this.userRepo.findAll();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not found", HttpStatus.BAD_REQUEST.toString(),id.toString()));
        return user;
    }
}
