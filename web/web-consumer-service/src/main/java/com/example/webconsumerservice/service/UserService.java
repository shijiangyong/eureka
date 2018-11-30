package com.example.webconsumerservice.service;

import com.example.webconsumerservice.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shijy
 * @Date 2018/11/30 14 : 26
 * @Descriprion
 */

public interface UserService {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 更新用户
     * @param id
     * @param user
     * @return
     */
    int updateUser(Integer id,User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
