package com.tjut.monitor.service.Impl;

import com.tjut.monitor.entity.Device;
import com.tjut.monitor.repository.DeviceRepository;
import com.tjut.monitor.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Override
    public Device createDevice(Device device) {
        repository.save(device);
        log.info("【创建设备成功】设备名: {}，编号:{}",device.getDeviceName(),device.getDeviceId());
        return device;
    }

    @Override
    public Device updateDevice(Device device) {
        Device deviceTemp = repository.findById(device.getDeviceId()).orElse(null);
        if(deviceTemp==null){
            log.error("【修改设备信息失败】找不到设备编号：{}",device.getDeviceId());
        }
        deviceTemp.setDeviceCode(device.getDeviceCode());
        deviceTemp.setDeviceName(device.getDeviceName());
        deviceTemp.setDeviceSize(device.getDeviceSize());
        deviceTemp.setDeviceCategory(device.getDeviceCategory());
        deviceTemp.setItem(device.getItem());
        deviceTemp.setCheckFrequency(device.getCheckFrequency());
        deviceTemp.setDeviceProducer(device.getDeviceProducer());
        deviceTemp.setCreateTime(device.getCreateTime());
        repository.save(deviceTemp);
        log.info("【修改设备信息成功】编号：{}",deviceTemp.getDeviceId());
        return deviceTemp;
    }

    @Override
    public void deleteByDeviceId(Integer deviceId) {
        repository.deleteById(deviceId);
        log.info("【删除设备成功】设备ID: {}",deviceId);
    }

    @Override
    public Page<Device> getAllDevice(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Device> page = repository.findAll(pageable);
        return page;
    }
}
