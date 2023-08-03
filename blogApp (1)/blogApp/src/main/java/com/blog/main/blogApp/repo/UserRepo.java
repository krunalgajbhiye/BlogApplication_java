package com.blog.main.blogApp.repo;

import com.blog.main.blogApp.entity.Blogs;
import com.blog.main.blogApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
