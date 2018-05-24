package com.SSMTest.Service;

import com.SSMTest.Model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/10.
 */
@Service
public interface UserService {
    public User getUserById(String id);
}
