package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.Maintenance;
import com.tjut.monitor.repository.MaintenanceRepository;
import com.tjut.monitor.service.MaintenanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository repository;

    @Override
    public Maintenance createMaintenance(Maintenance maintenance) {
        repository.save(maintenance);
        log.info("【创建检修记录成功】检修名: {}",maintenance.getMaintName());
        return maintenance;
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        Maintenance maintenanceTemp = repository.findById(maintenance.getMaintId()).orElse(null);
        if(maintenanceTemp==null){
            log.error("【修改检修记录失败】找不到检修记录 id={}",maintenance.getMaintId());
        }
        maintenanceTemp.setMaintName(maintenance.getMaintName());
        maintenanceTemp.setUseTime(maintenance.getUseTime());
        maintenanceTemp.setMaintName(maintenance.getMaintName());
        maintenanceTemp.setMaintStatus(maintenance.getMaintStatus());
        maintenanceTemp.setReportStatus(maintenance.getReportStatus());
        maintenanceTemp.setMaintPerson(maintenance.getMaintPerson());
        repository.save(maintenanceTemp);
        log.info("【修改检修记录成功】ID：{}",maintenanceTemp.getMaintId());
        return maintenanceTemp;
    }

    @Override
    public void deleteByMaintenanceId(Integer maintenanceId) {
        repository.deleteById(maintenanceId);
        log.info("【删除检修记录成功】ID: {}",maintenanceId);
    }

    @Override
    public Page<Maintenance> getAllMaintenance(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Maintenance> page = repository.findAll(pageable);
        return page;
    }
}
