package Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.UserInfo;

public interface UserInfoMapper {
    @Select("select * from userinfo where password=#{password}")
    UserInfo selectUserInfo(String password);


    @Select("SELECT * FROM theuserinfo WHERE username=#{Name} AND PASSWORD=#{password}")
    UserInfo selectUserInfoName(@Param("Name") String Name
            ,@Param("password") String password);
}
