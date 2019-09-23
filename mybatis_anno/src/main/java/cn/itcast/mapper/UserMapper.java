package cn.itcast.mapper;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(int id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id = #{id}")
    public User findById(int id);

    // 一对多
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "cn.itcast.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();


    // 多对多
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "cn.itcast.mapper.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRole();

}
