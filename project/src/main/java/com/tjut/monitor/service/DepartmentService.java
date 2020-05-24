package com.tjut.monitor.service;

import com.tjut.monitor.entity.Department;
import org.springframework.data.domain.Page;

public interface DepartmentService {

    /**
     * 1.添加一个部门
     * @param department
     * @return
     */
    public Department createDepartment(Department department);

    /**
     * 2.修改部门信息
     * @param department
     * @return
     */
    public Department updateDepartment(Department department);

    /**
     * 3.通过ID删除一个部门
     * @param departmentId
     */
    public void deleteByDepartmentId(Integer departmentId);

    /**
     * 4.获取所有部门信息
     * @return
     */
    public Page<Department> getAllDepartment(Integer pageNum, Integer pageSize);
}
