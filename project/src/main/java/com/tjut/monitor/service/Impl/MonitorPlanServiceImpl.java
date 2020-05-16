package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.MonitorPlan;
import com.tjut.monitor.repository.MonitorPlanRepository;
import com.tjut.monitor.service.MonitorPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MonitorPlanServiceImpl implements MonitorPlanService {

    @Autowired
    private MonitorPlanRepository repository;

    @Override
    public MonitorPlan getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<MonitorPlan> getAll(Integer pageNum, Integer pageSize) {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<MonitorPlan> page = repository.findAll(pageable);
        return page;
    }
}
