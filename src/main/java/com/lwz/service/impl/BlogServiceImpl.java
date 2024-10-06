package com.lwz.service.impl;

import com.lwz.dao.BlogDao;
import com.lwz.pojo.Blog;
import com.lwz.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public Blog getDetailedBlog(Long id) {
        return null;
    }

    @Override
    public List<Blog> getAllBlog() {
        return null;
    }

    @Override
    public List<Blog> getByTypeId(Long typeId) {
        return null;
    }

    @Override
    public List<Blog> getByTagId(Long tagId) {
        return null;
    }

    @Override
    public List<Blog> getIndexBlog() {
        return null;
    }

    @Override
    public List<Blog> getAllRecommendBlog() {
        return null;
    }

    @Override
    public List<Blog> getSearchBlog(String query) {
        return null;
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        return null;
    }

    @Override
    public int countBlog() {
        return 0;
    }

    @Override  //添加内容
    public int saveBlog(Blog blog) {


        return 0;
    }

    @Override
    public int updateBlog(Blog blog) {
        return 0;
    }

    @Override
    public int deleteBlog(Long id) {
        return 0;
    }

    @Override
    public List<Blog> searchAllBlog(Blog blog) {
        return null;
    }
}
