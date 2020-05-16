package com.tjut.monitor.service;

import com.tjut.monitor.entity.AnalogData;

public interface AnalogDataService {

    /**
     * 1.根据监测方案ID随机获取一条数据
     * @param id
     * @return
     */
    public AnalogData getByMonitorIdRandom(Integer id);

}
