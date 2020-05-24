package com.tjut.monitor.service;

import com.tjut.monitor.entity.Device;
import org.springframework.data.domain.Page;

public interface DeviceService {

    /**
     * 1.添加一个设备
     * @param device
     * @return
     */
    public Device createDevice(Device device);

    /**
     * 2.修改设备信息
     * @param device
     * @return
     */
    public Device updateDevice(Device device);

    /**
     * 3.通过ID删除一个设备
     * @param deviceId
     */
    public void deleteByDeviceId(Integer deviceId);

    /**
     * 4.获取所有设备信息
     * @return
     */
    public Page<Device> getAllDevice(Integer pageNum, Integer pageSize);
}
