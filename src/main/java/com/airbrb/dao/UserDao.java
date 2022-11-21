package com.airbrb.dao;


import com.airbrb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface UserDao {
    @Insert("insert into Users (name,email,password) values(#{name},#{email},#{password})")
    public void save(User user);
    @Select("select * from Users where email = #{email}")
    public User getByEmail(String email);
    @Select("select * from Users")
    public List<User> getAll();


}
