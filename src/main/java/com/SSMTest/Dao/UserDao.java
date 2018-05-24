package com.SSMTest.Dao;

import com.SSMTest.Model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/5/11.
 */
@Repository
public interface UserDao {
    public User getUserById(String id);
}
