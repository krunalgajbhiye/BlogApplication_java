package com.blog.main.blogApp.repo;

import com.blog.main.blogApp.entity.Blogs;
import com.blog.main.blogApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blogs,Long> {

     public List<Blogs> findByUser(User user);
}
