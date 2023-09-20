package Interface.impl;

import Interface.theLoggingInterface;
import Mapper.UserInfoMapper;
import Utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import pojo.UserInfo;

public class theLoggingImpl implements theLoggingInterface {
    @Override
    public boolean checkUserInfo(String username, String password) {
        boolean isEntry = false;
        try (SqlSession session = MybatisUtils.setSqlSession(true)){
            UserInfoMapper mapper =session.getMapper(UserInfoMapper.class);
            UserInfo userInfo = mapper.selectUserInfoName(username, password);
            String username1 = userInfo.getUsername();
            String password2=userInfo.getPassword();
            if (username.equals(username1) && password2.equals(password)){
                isEntry=true;
            }
        }
        return isEntry;
    }

    @Override
    public boolean checkUserName(String password) {
        boolean isEntry = false;
        try (SqlSession session = MybatisUtils.setSqlSession(true)){
            UserInfoMapper mapper =session.getMapper(UserInfoMapper.class);
            UserInfo userInfo = mapper.selectUserInfo(password);
            String password2 = userInfo.getUsername();
            if (password.equals(password2) ){
                isEntry=true;
            }
        }
        return isEntry;
    }
}
