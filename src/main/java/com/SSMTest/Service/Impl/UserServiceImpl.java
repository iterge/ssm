package com.SSMTest.Service.Impl;

import com.SSMTest.Dao.UserDao;
import com.SSMTest.Model.User;
import com.SSMTest.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/11.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }
}
