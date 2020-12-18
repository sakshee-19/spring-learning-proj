package com.udacity.jwdnd.basic.mappers;

import com.udacity.jwdnd.basic.db.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("Select * FROM USERS where username=#{username}")
    User findByUsername(String username);

    @Insert("INSERT into USERS (username, firstname, lastname, salt, password) values (#{username}, #{firstname}, #{lastname}, #{salt}, #{password})")
    @Options(keyProperty = "userId", useGeneratedKeys = true)
    int insert(User user);

}
