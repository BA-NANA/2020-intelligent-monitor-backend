package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.AnalogData;
import com.tjut.monitor.repository.AnalogDataRepository;
import com.tjut.monitor.service.AnalogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalogDataServiceImpl implements AnalogDataService {

    @Autowired
    private AnalogDataRepository repository;

    @Override
    public AnalogData getByMonitorIdRandom(Integer monitorId) {
        return repository.findByMonitorIdRandom(monitorId);
    }
}
