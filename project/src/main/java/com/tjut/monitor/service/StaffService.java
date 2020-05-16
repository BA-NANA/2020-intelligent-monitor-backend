package com.tjut.monitor.service;

import com.tjut.monitor.entity.Staff;
import org.springframework.data.domain.Page;

public interface StaffService {

    /**
     * 1.通过员工名查找
     * @param staffName
     * @return Staff
     */
    public Staff getByStaffName(String staffName);

    public Staff getByStaffId(Integer staffId);

    /**
     * 2.添加一个员工
     * @param staff
     * @return
     */
    public Staff createStaff(Staff staff);

    /**
     * 3.修改员工信息
     * @param staff
     * @return
     */
    public Staff updateStaff(Staff staff);

    /**
     * 4.通过ID删除一个员工
     * @param staffId
     */
    public void deleteByStaffId(Integer staffId);

    /**
     * 6.获取所有员工
     * @return
     */
    public Page<Staff> getAllStaff(Integer pageNum, Integer pageSize);


}
