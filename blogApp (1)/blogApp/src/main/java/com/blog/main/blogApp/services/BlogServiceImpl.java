package com.blog.main.blogApp.services;

import com.blog.main.blogApp.entity.Blogs;
import com.blog.main.blogApp.entity.User;
import com.blog.main.blogApp.exception.ResourceNotFoundException;
import com.blog.main.blogApp.repo.BlogRepo;
import com.blog.main.blogApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;



    @Override
    public Blogs SaveBlogs(Blogs blogs,Long user_id) {
        User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User Not found", HttpStatus.BAD_REQUEST.toString(),user_id.toString()));
        blogs.setUser(user);
        Blogs userBlogs = this.blogRepo.save(blogs);
        return userBlogs;
    }

    @Override
    public Blogs updateBlogs(Blogs blogs,Long blog_id) {
      //  User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User Not found", HttpStatus.BAD_REQUEST.toString(),user_id.toString()));
        Blogs userBlogs= this.blogRepo.findById(blog_id).orElseThrow(() -> new ResourceNotFoundException("Blogs Not found", HttpStatus.BAD_REQUEST.toString(),blog_id.toString()));
       // userBlogs.setUser(user);
        //userBlogs.setUser(blogs.getUser());
        userBlogs.setTitle(blogs.getTitle());
        userBlogs.setComment(blogs.getComment());
        Blogs userBlogsUpdate = this.blogRepo.save(userBlogs);
        return userBlogsUpdate;
    }

    @Override
    public List<Blogs> getAllBlogs() {
        List<Blogs> blogs = this.blogRepo.findAll();
        return blogs;
    }


    @Override
    public Blogs getBlogById(Long id) {
        return null;
    }

    @Override
    public List<Blogs> findByUserId(Long user_id) {
        User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("user Not found", HttpStatus.BAD_REQUEST.toString(),user_id.toString()));
        List<Blogs> blogs = this.blogRepo.findByUser(user);
        return blogs;
    }
}
