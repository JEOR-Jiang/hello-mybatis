import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * mybatis使用
 *  1。创建数据库链接
 *  2。访问数据
 *
 *  todo
 *      1。数据源配置
 *      2。提交到github上
 */
public class TestMybatis {

    public SqlSessionFactory getSqlSessionFactiory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test(){
        System.out.println("test");
    }

    // 1。创建数据库链接
    @Test
    public void testConnect() throws IOException {
        SqlSessionFactory sessionFactory =  getSqlSessionFactiory();
        System.out.println(sessionFactory);
    }

    // 2。访问数据
    @Test
    public void testSelectData() throws IOException {
        SqlSessionFactory sessionFactory =  getSqlSessionFactiory();
        SqlSession sqlSession = sessionFactory.openSession();
        try{
            BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlog(1);
            System.out.println(blog);

            List<Blog> blogs = blogDao.selectBlogs();
            System.out.println(blogs);
        }finally {
            sqlSession.close();
        }
    }


}
