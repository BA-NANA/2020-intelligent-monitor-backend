package com.tjut.monitor.service;

import com.tjut.monitor.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    /**
     * 1.通过用户名查找
     * @param username
     * @return User
     */
    public User getByUsername(String username);

    /**
     * 2.添加一个用户
     * @param user
     * @return
     */
    public User createUser(User user);

    /**
     * 3.修改用户信息
     * @param user
     * @return
     */
    public User updateUser(User user);

    /**
     * 4.删除一个用户
     * @param username
     */
    public void deleteByUsername(String username);

    /**
     * 5.登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);

    /**
     * 6.获取所有用户
     * @return
     */
    public Page<User> getAllUser(Integer pageNum, Integer pageSize);

}
