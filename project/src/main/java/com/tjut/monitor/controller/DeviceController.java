package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.deviceVO.DeviceDataVO;
import com.tjut.monitor.VO.deviceVO.DeviceInfoVO;
import com.tjut.monitor.entity.Device;
import com.tjut.monitor.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 1.创建一个新设备
     */
    @PostMapping("/add")
    public ResultVO createDevice(String code, @RequestParam("name") String name, String size, String category,
                                 String item, String frequency, @RequestParam("producer")String producer, String create_time){
        Device device = new Device();
        device.setDeviceCode(code);
        device.setDeviceName(name);
        device.setDeviceSize(size);
        device.setDeviceCategory(category);
        device.setItem(item);
        device.setCheckFrequency(frequency);
        device.setDeviceProducer(producer);
        device.setCreateTime(create_time);

        deviceService.createDevice(device);
        return new ResultVO(0,"success");
    }

    /**
     * 2.通过id删除设备
     */
    @PostMapping("/delete")
    public ResultVO deleteDevice(@RequestParam("id")Integer id){
        deviceService.deleteByDeviceId(id);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更新设备信息
     */
    @PostMapping("/update")
    public ResultVO updateDevice(@RequestParam("id")Integer id, String code, @RequestParam("name") String name, String size, String category,
                                 String item, String frequency, @RequestParam("producer")String producer, String create_time){
        Device device = new Device();
        device.setDeviceId(id);
        device.setDeviceCode(code);
        device.setDeviceName(name);
        device.setDeviceSize(size);
        device.setDeviceCategory(category);
        device.setItem(item);
        device.setCheckFrequency(frequency);
        device.setDeviceProducer(producer);
        device.setCreateTime(create_time);

        deviceService.updateDevice(device);
        return new ResultVO(0,"success");
    }

    /**
     * 4.获取所有设备信息
     */
    @GetMapping("/getAll")
    public ResultVO getAllDevice(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<Device> page = deviceService.getAllDevice(pageNum,pageSize);
        List<Device> deviceList = page.getContent();

        List<DeviceInfoVO> deviceInfoVOList = new ArrayList<>();

        for(Device device : deviceList ){
            DeviceInfoVO deviceInfoVO = new DeviceInfoVO();
            deviceInfoVO.setDeviceId(device.getDeviceId());
            deviceInfoVO.setDeviceName(device.getDeviceName());
            deviceInfoVO.setDeviceCode(device.getDeviceCode());
            deviceInfoVO.setDeviceSize(device.getDeviceSize());
            deviceInfoVO.setDeviceCategory(device.getDeviceCategory());
            deviceInfoVO.setDeviceItem(device.getItem());
            deviceInfoVO.setCheckFrequency(device.getCheckFrequency());
            deviceInfoVO.setDeviceProducer(device.getDeviceProducer());
            deviceInfoVO.setCreateTime(device.getCreateTime());

            deviceInfoVOList.add(deviceInfoVO);
        }

        DeviceDataVO deviceDataVO = new DeviceDataVO();
        deviceDataVO.setTotalNum((int) page.getTotalElements());
        deviceDataVO.setDeviceInfoVOList(deviceInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(deviceDataVO);

        return resultVO;
    }


}
