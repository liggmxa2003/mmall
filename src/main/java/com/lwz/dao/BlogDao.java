package com.lwz.dao;

import com.lwz.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BlogDao {
    Blog getBlog(Long id);  //后台展示博客

    int saveBlog(Blog blog);
}

