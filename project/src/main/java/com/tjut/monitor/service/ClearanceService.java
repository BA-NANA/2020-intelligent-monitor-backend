package com.tjut.monitor.service;

import com.tjut.monitor.entity.Clearance;
import org.springframework.data.domain.Page;

public interface ClearanceService {

    /**
     * 1.添加一个清算记录
     * @param clearance
     * @return
     */
    public Clearance createClearance(Clearance clearance);

    /**
     * 2.修改清算信息
     * @param clearance
     * @return
     */
    public Clearance updateClearance(Clearance clearance);

    /**
     * 3.通过ID删除一个清算记录
     * @param clearanceId
     */
    public void deleteByClearanceId(Integer clearanceId);

    /**
     * 4.获取所有设备信息
     * @return
     */
    public Page<Clearance> getAllClearance(Integer pageNum, Integer pageSize);
}
