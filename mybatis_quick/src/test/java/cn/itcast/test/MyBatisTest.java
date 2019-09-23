package cn.itcast.test;

import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    // 删
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.delete("userMapper.delete", 50);
        sqlSession.close();
    }

    @Test
    // 改
    public void test3() throws IOException {
        User user = new User();
        user.setId(8);
        user.setUsername("wangba");
        user.setPassword("123");
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.update("userMapper.update",user);
        sqlSession.close();
    }

    @Test
    // 增
    public void test2() throws IOException {
        User user = new User();
        user.setUsername("zhangmanyu");
        user.setPassword("123");
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        int insert = sqlSession.insert("userMapper.add", user);
        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    // 查All
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<User> userList = sqlSession.selectList("userMapper.findAll");// 参数：namespace+id
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    // 查One
    public void test0() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        User user = sqlSession.selectOne("userMapper.findOne", 1);// 参数：namespace+id
        System.out.println(user);
        sqlSession.close();
    }

}
