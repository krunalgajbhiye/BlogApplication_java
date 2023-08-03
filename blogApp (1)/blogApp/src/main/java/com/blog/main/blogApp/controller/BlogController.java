package com.blog.main.blogApp.controller;


import com.blog.main.blogApp.entity.Blogs;
import com.blog.main.blogApp.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping(value = "/{userId}")
    public ResponseEntity<Blogs> SaveBlogs(@RequestBody Blogs blogs, @PathVariable Long userId ){

        Blogs saveBlogs = this.blogService.SaveBlogs(blogs,userId);
        return new ResponseEntity<>(saveBlogs, HttpStatus.CREATED);
    }

    @PutMapping(value="/{blogId}")
    public ResponseEntity<Blogs> UpdateBlogs(@RequestBody Blogs blogs,@PathVariable Long blogId){
        Blogs saveBlogs = this.blogService.updateBlogs(blogs,blogId);
        return new ResponseEntity<>(saveBlogs, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}")
    public  ResponseEntity<List<Blogs>> getBlogsByUser(@RequestBody Blogs blogs,@PathVariable Long userId){

        List<Blogs> getBlogsByUser = this.blogService.findByUserId(userId);
        return new ResponseEntity<List<Blogs>>(getBlogsByUser,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Blogs>> getAllBlogs(){
        List<Blogs> allBlogs = this.blogService.getAllBlogs();
        return new ResponseEntity<List<Blogs>>(allBlogs,HttpStatus.OK);
    }
}
