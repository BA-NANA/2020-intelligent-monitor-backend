package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.Clearance;
import com.tjut.monitor.repository.ClearanceRepository;
import com.tjut.monitor.service.ClearanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClearanceServiceImpl implements ClearanceService {

    @Autowired
    private ClearanceRepository repository;

    @Override
    public Clearance createClearance(Clearance clearance) {
        repository.save(clearance);
        log.info("【创建清算记录成功】清算名: {}",clearance.getCleName());
        return clearance;
    }

    @Override
    public Clearance updateClearance(Clearance clearance) {
        Clearance clearanceTemp = repository.findById(clearance.getCleId()).orElse(null);
        if(clearanceTemp==null){
            log.error("【修改清算记录失败】找不到清算记录 id={}",clearance.getCleId());
        }
        clearanceTemp.setCleName(clearance.getCleName());
        clearanceTemp.setCleLeader(clearance.getCleLeader());
        clearanceTemp.setLeaderPhone(clearance.getLeaderPhone());
        clearanceTemp.setClePlace(clearance.getClePlace());
        clearanceTemp.setCleRemark(clearance.getCleRemark());
        repository.save(clearanceTemp);
        log.info("【修改清算记录成功】ID：{}",clearanceTemp.getCleId());
        return clearanceTemp;
    }

    @Override
    public void deleteByClearanceId(Integer clearanceId) {
        repository.deleteById(clearanceId);
        log.info("【删除清算记录成功】ID: {}",clearanceId);
    }

    @Override
    public Page<Clearance> getAllClearance(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Clearance> page = repository.findAll(pageable);
        return page;
    }
}
