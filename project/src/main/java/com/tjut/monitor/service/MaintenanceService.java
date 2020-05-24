package com.tjut.monitor.service;

import com.tjut.monitor.entity.Maintenance;
import org.springframework.data.domain.Page;

public interface MaintenanceService {

    /**
     * 1.添加一条维修记录
     * @param maintenance
     * @return
     */
    public Maintenance createMaintenance(Maintenance maintenance);

    /**
     * 2.修改设备信息
     * @param maintenance
     * @return
     */
    public Maintenance updateMaintenance(Maintenance maintenance);

    /**
     * 3.通过ID删除一个设备
     * @param maintenanceId
     */
    public void deleteByMaintenanceId(Integer maintenanceId);

    /**
     * 4.获取所有设备信息
     * @return
     */
    public Page<Maintenance> getAllMaintenance(Integer pageNum, Integer pageSize);
}
