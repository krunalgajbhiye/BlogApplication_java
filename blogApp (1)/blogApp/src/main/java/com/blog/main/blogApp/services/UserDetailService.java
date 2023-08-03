package com.blog.main.blogApp.services;

import com.blog.main.blogApp.entity.User;
import com.blog.main.blogApp.exception.ResourceNotFoundException;
import com.blog.main.blogApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName= String.valueOf(userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("user Not found", HttpStatus.BAD_REQUEST.toString(),username)));
        if (username.equals(userName)) {
            System.out.println("access");
            return new User(userName, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            System.out.println("Failed");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
