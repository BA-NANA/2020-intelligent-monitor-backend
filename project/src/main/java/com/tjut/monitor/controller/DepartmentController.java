package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.departmentVO.DeptDataVO;
import com.tjut.monitor.VO.departmentVO.DeptInfoVO;
import com.tjut.monitor.entity.Department;
import com.tjut.monitor.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 1.创建一个新部门
     */
    @PostMapping("/add")
    public ResultVO createDepartment(@RequestParam("name") String name, @RequestParam("dept_phone") String deptPhone, @RequestParam("leader")String leader,
                                 @RequestParam("leader_phone")String leaderPhone, String remark){
        Department department = new Department();
        department.setDeptName(name);
        department.setDeptPhone(deptPhone);
        department.setDeptLeader(leader);
        department.setLeaderPhone(leaderPhone);
        department.setDeptRemark(remark);

        departmentService.createDepartment(department);
        return new ResultVO(0,"success");
    }

    /**
     * 2.通过部门编号删除
     */
    @PostMapping("/delete")
    public ResultVO deleteDepartment(@RequestParam("id")Integer id){
        departmentService.deleteByDepartmentId(id);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更新一条部门信息
     */
    @PostMapping("/update")
    public ResultVO updateDepartment(@RequestParam("id")Integer id,@RequestParam("name") String name, @RequestParam("dept_phone") String deptPhone, @RequestParam("leader")String leader,
                                     @RequestParam("leader_phone")String leaderPhone, String remark){

        Department department = new Department();
        department.setDeptId(id);
        department.setDeptName(name);
        department.setDeptPhone(deptPhone);
        department.setDeptLeader(leader);
        department.setLeaderPhone(leaderPhone);
        department.setDeptRemark(remark);

        departmentService.updateDepartment(department);
        return new ResultVO(0,"success");
    }

    /**
     * 4.获取所有部门信息
     */
    @GetMapping("/getAll")
    public ResultVO getAllDevice(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<Department> page = departmentService.getAllDepartment(pageNum,pageSize);
        List<Department> departmentList = page.getContent();

        List<DeptInfoVO> deptInfoVOList = new ArrayList<>();

        for(Department department : departmentList ){
            DeptInfoVO deptInfoVO = new DeptInfoVO();
            deptInfoVO.setDeptId(department.getDeptId());
            deptInfoVO.setDeptName(department.getDeptName());
            deptInfoVO.setDeptPhone(department.getDeptPhone());
            deptInfoVO.setDeptLeader(department.getDeptLeader());
            deptInfoVO.setLeaderPhone(department.getLeaderPhone());
            deptInfoVO.setDeptRemark(department.getDeptRemark());
            deptInfoVO.setUpdateTime(sdf.format(department.getUpdateTime()));
            deptInfoVO.setCreateTime(sdf.format(department.getCreateTime()));

            deptInfoVOList.add(deptInfoVO);
        }

        DeptDataVO deptDataVO = new DeptDataVO();
        deptDataVO.setTotalNum((int) page.getTotalElements());
        deptDataVO.setDeptInfoVOList(deptInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(deptDataVO);

        return resultVO;
    }


}
