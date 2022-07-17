package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User selectById(int id);

    @Select("select * from user where username = #{name}")
    User selectByName(String name);

    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    @Insert("insert into user values(null, #{username}, #{password}, #{salt}, #{email}, #{type}, #{status}, #{activationCode}, #{headerUrl}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertUser(User user);

    @Update("update user set status = #{status} where id = #{id}")
    int updateStatus(int id, int status);

    @Update("update user set header_url = #{headerUrl} where id = #{id}")
    int updateHeader(int id, String headerUrl);

    @Update("update user set password = #{password} where id = #{id}")
    int updatePassword(int id, String password);
}
