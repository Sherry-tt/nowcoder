package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated
public interface LoginTicketMapper {

    @Insert("insert into login_ticket values(null, #{userId},#{ticket},#{status},#{expired})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertLoginTicket(LoginTicket loginTicket);

    // use ticket number to check if logged in
    @Select("select * from login_ticket where ticket=#{ticket}")
    LoginTicket selectByTicket(String ticket);

    @Update( "update login_ticket set status=#{status} where ticket=#{ticket} ")
    int updateStatus(String ticket, int status);
}
