package org.mybatis.example;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BlogDao {

    @Select("select * from Blog where id = #{id}")
    public Blog selectBlog(Integer id);

    public List<Blog> selectBlogs();
}
