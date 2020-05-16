package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.User;
import com.tjut.monitor.repository.UserRepository;
import com.tjut.monitor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User getByUsername(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public User createUser(User user) {
        repository.save(user);
        log.info("【创建用户成功】用户名: {}",user.getUserName());
        return user;
    }

    @Override
    public User updateUser(User user) {
        User userTemp = repository.findById(user.getUserId()).orElse(null);
        if(userTemp==null){
            log.error("【修改用户信息失败】找不到用户：{}",user.getUserName());
        }
        userTemp.setUserName(user.getUserName());
        userTemp.setUserPassword(user.getUserPassword());
        repository.save(userTemp);
        log.info("【修改用户信息成功】新用户名：{}",userTemp.getUserName());
        return userTemp;
    }

    @Override
    public void deleteByUsername(String username) {
        repository.deleteByUserName(username);
        log.info("【删除用户成功】用户名: {}",username);
    }

    @Override
    public User login(String username, String password) {
        User user = repository.findByUserName(username);
        if(user!=null && password.equals(user.getUserPassword())){
            log.info("【登录成功】用户名：{}",username);
            return user;
        }else {
            log.error("【登录失败】用户名：{} ，密码：{} ",username,password);
        }
        return null;
    }

    @Override
    public Page<User> getAllUser(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<User> page = repository.findAll(pageable);
        return page;
    }
}
