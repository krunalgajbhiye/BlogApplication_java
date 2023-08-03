package com.blog.main.blogApp.services;

import com.blog.main.blogApp.entity.User;

import java.util.List;

public interface UserService {

    public User Save(User user);
    public List<User> getUser();
    public User getUserById(Long id);


}
