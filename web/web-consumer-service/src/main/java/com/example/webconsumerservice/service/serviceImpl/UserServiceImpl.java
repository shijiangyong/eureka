package com.example.webconsumerservice.service.serviceImpl;

import com.example.webconsumerservice.mapper.UserMapper;
import com.example.webconsumerservice.model.User;
import com.example.webconsumerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shijy
 * @Date 2018/11/30 14 : 28
 * @Descriprion
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(Integer id, User user) {
        return userMapper.updateUser(id,user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
