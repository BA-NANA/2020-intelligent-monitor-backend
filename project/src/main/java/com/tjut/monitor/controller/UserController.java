package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.userVO.UserDataVO;
import com.tjut.monitor.VO.userVO.UserInfoVO;
import com.tjut.monitor.entity.User;
import com.tjut.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 1.用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/regist")
    public ResultVO createUser(@RequestParam("username")String username, @RequestParam("password")String password){

        //验证用户名是否重复及长度
        if(username.length()<5 || userService.getByUsername(username)!=null){
            return new ResultVO(1,"用户名不可用");
        }
        //验证密码长度
        if(password.length()<6){
            return new ResultVO(2,"密码长度小于6位");
        }

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        userService.createUser(user);
        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(username);
        return resultVO;
    }

    /**
     * 2.用户删除
     * @param username
     * @return
     */
    @PostMapping("/delete")
    public ResultVO deleteUser(@RequestParam("username")String username){
        userService.deleteByUsername(username);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更改用户名或密码
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/update")
    public ResultVO updateUser(@RequestParam("username")String username, @RequestParam("password")String password,@RequestParam("id")Integer id){

        if(password.length()<6){
            return new ResultVO(1,"密码长度小于6位");
        }

        User user = new User();
        user.setUserId(id);
        user.setUserName(username);
        user.setUserPassword(password);
        userService.updateUser(user);
        return new ResultVO(0,"success");
    }

    /**
     * 4.登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultVO login(@RequestParam("username")String username, @RequestParam("password")String password){

        if(userService.login(username,password)==null){
            return new ResultVO(1,"用户名或密码错误");
        }

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(username);
        return resultVO;
    }

    /**
     * 5.获取所有用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAll")
    public ResultVO getAllUser(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<User> page = userService.getAllUser(pageNum,pageSize);
        List<User> userList = page.getContent();

        List<UserInfoVO> userInfoVOList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(User user : userList ){
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUserId(user.getUserId());
            userInfoVO.setUserName(user.getUserName());
            userInfoVO.setUserPassword(user.getUserPassword());
            userInfoVO.setUpdateTime(sdf.format(user.getUpdateTime()));
            userInfoVO.setCreateTime(sdf.format(user.getCreateTime()));
            userInfoVOList.add(userInfoVO);
        }

        UserDataVO userDataVO = new UserDataVO();
        userDataVO.setTotalNum((int) page.getTotalElements());
        userDataVO.setUserInfoVOList(userInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(userDataVO);

        return resultVO;
    }
}
