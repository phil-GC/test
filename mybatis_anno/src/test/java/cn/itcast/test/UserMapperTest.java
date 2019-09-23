package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testFindUserAndRole(){
        List<User> userAndRole = userMapper.findUserAndRole();
        for (User user : userAndRole) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAndOrderAll(){
        List<User> userAndOrderAll = userMapper.findUserAndOrderAll();
        for (User user : userAndOrderAll) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");
        userMapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setUsername("jary");
        user.setPassword("qwer");
        userMapper.update(user);
    }

    @Test
    public void testDelete() {
        userMapper.delete(4);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(2);
        System.out.println(user);
    }
}