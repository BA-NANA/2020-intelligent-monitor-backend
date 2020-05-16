package com.tjut.monitor.service;

import com.tjut.monitor.entity.RealTimeData;
import org.springframework.data.domain.Page;

public interface RealTimeDataService {

    /**
     * 1.获取全部检测数据
     * @param pageNum  页数
     * @param pageSize  一页显示多少条
     * @return
     */
    public Page<RealTimeData> getAll(Integer pageNum, Integer pageSize);

    /**
     * 2.创建一条实时监测记录
     * @param realTimeData
     * @return
     */
    public RealTimeData create(RealTimeData realTimeData);

}
