package com.tjut.monitor.service;

import com.tjut.monitor.entity.MonitorPlan;
import org.springframework.data.domain.Page;

public interface MonitorPlanService {

    /**
     * 1.通过方案ID获取
     * @return
     */
    public MonitorPlan getById(Integer id);

    /**
     * 2.获取全部方案
     * @param pageNum  页数
     * @param pageSize  一页显示多少条
     * @return
     */
    public Page<MonitorPlan> getAll(Integer pageNum, Integer pageSize);


}
