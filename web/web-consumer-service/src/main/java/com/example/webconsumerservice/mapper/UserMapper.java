package com.example.webconsumerservice.mapper;

import com.example.webconsumerservice.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shijy
 * @Date 2018/11/29 10 : 57
 * @Descriprion
 */
@Repository
public interface UserMapper {

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
    int updateUser(@Param("id") Integer id, @Param("user") User user);

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
