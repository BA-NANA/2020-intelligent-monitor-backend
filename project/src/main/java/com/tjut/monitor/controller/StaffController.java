package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.staffVO.StaffDataVO;
import com.tjut.monitor.VO.staffVO.StaffInfoVO;
import com.tjut.monitor.entity.Staff;
import com.tjut.monitor.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 1.添加一个新员工
     */
    @PostMapping("/add")
    public ResultVO createStaff(@RequestParam("name")String name, @RequestParam(value = "sex",required = false)String sex,
                                @RequestParam(value = "age",required = false)Integer age,@RequestParam(value = "phone",required = false)String phone,
                                @RequestParam(value = "department", required = false)String department, @RequestParam(value = "position",required = false)String position){

        Staff staff = new Staff();
        staff.setStaffName(name);
        staff.setSex(sex);
        staff.setAge(age);
        staff.setPhone(phone);
        staff.setDepartment(department);
        staff.setPosition(position);

        staffService.createStaff(staff);

        return new ResultVO(0,"success");
    }

    /**
     * 2.通过员工编号删除
     */
    @PostMapping("/delete")
    public ResultVO deleteStaff(@RequestParam("id")Integer staffId){
        staffService.deleteByStaffId(staffId);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更改员工信息
     */
    @PostMapping("/update")
    public ResultVO updateUser(@RequestParam("id")Integer id,@RequestParam("name")String name, @RequestParam(value = "sex",required = false)String sex,
                               @RequestParam(value = "age",required = false)Integer age,@RequestParam(value = "phone",required = false)String phone,
                               @RequestParam(value = "department", required = false)String department, @RequestParam(value = "position",required = false)String position){

        Staff staff = new Staff();
        staff.setStaffId(id);
        staff.setStaffName(name);
        staff.setSex(sex);
        staff.setAge(age);
        staff.setPhone(phone);
        staff.setDepartment(department);
        staff.setPosition(position);

        staffService.updateStaff(staff);

        return new ResultVO(0,"success");
    }


    /**
     * 5.获取所有员工信息
     */
    @GetMapping("/getAll")
    public ResultVO getAllStaff(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<Staff> page = staffService.getAllStaff(pageNum,pageSize);
        List<Staff> staffList = page.getContent();

        List<StaffInfoVO> staffInfoVOList = new ArrayList<>();

        for(Staff staff : staffList ){
            StaffInfoVO staffInfoVO = new StaffInfoVO();
            staffInfoVO.setId(staff.getStaffId());
            staffInfoVO.setName(staff.getStaffName());
            staffInfoVO.setSex(staff.getSex());
            staffInfoVO.setAge(staff.getAge());
            staffInfoVO.setPhone(staff.getPhone());
            staffInfoVO.setDepartment(staff.getDepartment());
            staffInfoVO.setPosition(staff.getPosition());
            staffInfoVO.setUpdateTime(sdf.format(staff.getUpdateTime()));
            staffInfoVO.setCreateTime(sdf.format(staff.getCreateTime()));

            staffInfoVOList.add(staffInfoVO);
        }

        StaffDataVO staffDataVO = new StaffDataVO();
        staffDataVO.setTotalNum((int) page.getTotalElements());
        staffDataVO.setStaffInfoVOList(staffInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(staffDataVO);

        return resultVO;
    }

    /**
     * 6.通过ID查找员工
     */
    @GetMapping("/getById")
    public ResultVO getById(@RequestParam("id")Integer id){
        Staff staff = staffService.getByStaffId(id);
        StaffInfoVO staffInfoVO = new StaffInfoVO();
        staffInfoVO.setId(staff.getStaffId());
        staffInfoVO.setName(staff.getStaffName());
        staffInfoVO.setSex(staff.getSex());
        staffInfoVO.setAge(staff.getAge());
        staffInfoVO.setPhone(staff.getPhone());
        staffInfoVO.setDepartment(staff.getDepartment());
        staffInfoVO.setPosition(staff.getPosition());
        staffInfoVO.setUpdateTime(sdf.format(staff.getUpdateTime()));
        staffInfoVO.setCreateTime(sdf.format(staff.getCreateTime()));

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(staffInfoVO);
        return resultVO;
    }
}
