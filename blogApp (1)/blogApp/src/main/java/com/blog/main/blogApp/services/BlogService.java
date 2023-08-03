package com.blog.main.blogApp.services;

import com.blog.main.blogApp.entity.Blogs;
import com.blog.main.blogApp.entity.User;

import java.util.List;

public interface BlogService {

    public Blogs SaveBlogs(Blogs blogs,Long user_id);

    public Blogs updateBlogs(Blogs blogs,Long blog_id);

    public List<Blogs> getAllBlogs();

    public Blogs getBlogById(Long id);

    public List<Blogs> findByUserId(Long user_id);

}
