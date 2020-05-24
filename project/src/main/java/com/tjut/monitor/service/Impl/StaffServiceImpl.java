package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.Staff;
import com.tjut.monitor.repository.StaffRepository;
import com.tjut.monitor.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository repository;

    @Override
    public Staff getByStaffName(String staffName) {
        return repository.findByStaffName(staffName);
    }

    @Override
    public Staff getByStaffId(Integer staffId) {
        return repository.findById(staffId).orElse(null);
    }

    @Override
    public Staff createStaff(Staff staff) {
        repository.save(staff);
        log.info("【创建员工成功】姓名: {}",staff.getStaffName());
        return staff;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        Staff staffTemp = repository.findById(staff.getStaffId()).orElse(null);
        if(staffTemp==null){
            log.error("【修改员工信息失败】找不到员工 编号: {}, 姓名: {}",staff.getStaffId(),staff.getStaffName());
        }
        staffTemp.setStaffName(staff.getStaffName());
        staffTemp.setAge(staff.getAge());
        staffTemp.setPhone(staff.getPhone());
        staffTemp.setDepartment(staff.getDepartment());
        staffTemp.setSex(staff.getSex());
        staffTemp.setPosition(staff.getPosition());
        repository.save(staffTemp);
        log.info("【修改员工信息成功】员工编号：{}",staffTemp.getStaffId());
        return staffTemp;
    }

    @Override
    public void deleteByStaffId(Integer staffId) {
        repository.deleteById(staffId);
        log.info("【删除员工成功】员工编号: {}",staffId);
    }

    @Override
    public Page<Staff> getAllStaff(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Staff> page = repository.findAll(pageable);
        return page;
    }
}
