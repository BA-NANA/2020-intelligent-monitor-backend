package com.tjut.monitor.repository;

import com.tjut.monitor.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    Staff findByStaffName(String staffName);

    Page<Staff> findAll(Pageable pageable);
}
