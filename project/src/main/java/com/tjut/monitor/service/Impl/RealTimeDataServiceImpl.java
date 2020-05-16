package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.RealTimeData;
import com.tjut.monitor.repository.RealTimeDataRepository;
import com.tjut.monitor.service.RealTimeDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RealTimeDataServiceImpl implements RealTimeDataService {

    @Autowired
    private RealTimeDataRepository repository;

    @Override
    public Page<RealTimeData> getAll(Integer pageNum, Integer pageSize) {
        //按时间降序排序
        Sort sort = Sort.by(Sort.Order.desc("monitorTime"));
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<RealTimeData> page = repository.findAll(pageable);
        return page;
    }

    @Override
    public RealTimeData create(RealTimeData realTimeData) {
        log.info("【插入实时监测记录成功】");
        return repository.save(realTimeData);
    }
}
