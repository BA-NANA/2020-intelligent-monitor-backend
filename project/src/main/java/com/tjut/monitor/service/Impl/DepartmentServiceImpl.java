package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.Department;
import com.tjut.monitor.repository.DepartmentRepository;
import com.tjut.monitor.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department createDepartment(Department department) {
        repository.save(department);
        log.info("【创建部门成功】部门名: {}",department.getDeptName());
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        Department departmentTemp = repository.findById(department.getDeptId()).orElse(null);
        if(departmentTemp==null){
            log.error("【修改部门信息失败】找不到部门：{} , id={}",department.getDeptName(),department.getDeptId());
        }
        departmentTemp.setDeptName(department.getDeptName());
        departmentTemp.setDeptPhone(department.getDeptPhone());
        departmentTemp.setDeptLeader(department.getDeptLeader());
        departmentTemp.setLeaderPhone(department.getLeaderPhone());
        departmentTemp.setDeptRemark(department.getDeptRemark());
        repository.save(departmentTemp);
        log.info("【修改部门信息成功】部门号：{}",departmentTemp.getDeptId());
        return departmentTemp;
    }

    @Override
    public void deleteByDepartmentId(Integer departmentId) {
        repository.deleteById(departmentId);
        log.info("【删除部门成功】部门ID: {}",departmentId);
    }

    @Override
    public Page<Department> getAllDepartment(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Department> page = repository.findAll(pageable);
        return page;
    }
}
