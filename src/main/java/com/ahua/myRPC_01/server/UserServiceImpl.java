package com.ahua.myRPC_01.server;

import com.ahua.myRPC_01.common.User;
import com.ahua.myRPC_01.service.UserService;

public class UserServiceImpl implements UserService{
    @Override
    public User getUserByUserId(Integer id) {
        User user=new User();
        user.setId(id);
        return user;
    }
}
