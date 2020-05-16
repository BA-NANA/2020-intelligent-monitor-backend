package com.tjut.monitor.task;

import com.tjut.monitor.entity.RealTimeData;
import com.tjut.monitor.service.AnalogDataService;
import com.tjut.monitor.service.RealTimeDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@EnableScheduling
@Component
public class GetNewDataTask {

    @Autowired
    private AnalogDataService analogDataService;

    @Autowired
    private RealTimeDataService realTimeDataService;

    /**
     * 模拟获取实时监测数据任务，设定60秒获取一次
     */
    @Scheduled(cron = "*/60 * * * * ?")
    public void getNewData(){

        RealTimeData realTimeData = new RealTimeData();
        realTimeData.setMonitor1(analogDataService.getByMonitorIdRandom(1).getMonitorValue());
        realTimeData.setMonitor2(analogDataService.getByMonitorIdRandom(2).getMonitorValue());
        realTimeData.setMonitor3(analogDataService.getByMonitorIdRandom(3).getMonitorValue());
        realTimeData.setMonitor4(analogDataService.getByMonitorIdRandom(4).getMonitorValue());
        realTimeData.setMonitor5(analogDataService.getByMonitorIdRandom(5).getMonitorValue());
        realTimeData.setMonitor6(analogDataService.getByMonitorIdRandom(6).getMonitorValue());
        realTimeData.setMonitor7(analogDataService.getByMonitorIdRandom(7).getMonitorValue());
        realTimeData.setMonitor8(analogDataService.getByMonitorIdRandom(8).getMonitorValue());
        realTimeData.setMonitor9(analogDataService.getByMonitorIdRandom(9).getMonitorValue());
        realTimeData.setMonitor10(analogDataService.getByMonitorIdRandom(10).getMonitorValue());
        realTimeData.setMonitor11(analogDataService.getByMonitorIdRandom(11).getMonitorValue());
        realTimeData.setMonitor12(analogDataService.getByMonitorIdRandom(12).getMonitorValue());
        realTimeData.setMonitor13(analogDataService.getByMonitorIdRandom(13).getMonitorValue());
        realTimeData.setMonitor14(analogDataService.getByMonitorIdRandom(14).getMonitorValue());
        realTimeData.setMonitor15(analogDataService.getByMonitorIdRandom(15).getMonitorValue());
        realTimeData.setMonitor16(analogDataService.getByMonitorIdRandom(16).getMonitorValue());
        realTimeData.setMonitor17(analogDataService.getByMonitorIdRandom(17).getMonitorValue());
        realTimeData.setMonitor18(analogDataService.getByMonitorIdRandom(18).getMonitorValue());
        realTimeData.setMonitor19(analogDataService.getByMonitorIdRandom(19).getMonitorValue());
        realTimeData.setMonitor20(analogDataService.getByMonitorIdRandom(20).getMonitorValue());
        realTimeData.setMonitor21(analogDataService.getByMonitorIdRandom(21).getMonitorValue());
        realTimeData.setMonitor22(analogDataService.getByMonitorIdRandom(22).getMonitorValue());
        realTimeData.setMonitor23(analogDataService.getByMonitorIdRandom(23).getMonitorValue());
        realTimeData.setMonitor24(analogDataService.getByMonitorIdRandom(24).getMonitorValue());
        realTimeData.setMonitor25(analogDataService.getByMonitorIdRandom(25).getMonitorValue());
        realTimeData.setMonitor26(analogDataService.getByMonitorIdRandom(26).getMonitorValue());
        realTimeData.setMonitor27(analogDataService.getByMonitorIdRandom(27).getMonitorValue());
        realTimeData.setMonitor28(analogDataService.getByMonitorIdRandom(28).getMonitorValue());
        realTimeData.setMonitor29(analogDataService.getByMonitorIdRandom(29).getMonitorValue());
        realTimeData.setMonitor30(analogDataService.getByMonitorIdRandom(30).getMonitorValue());
        realTimeData.setMonitor30(analogDataService.getByMonitorIdRandom(31).getMonitorValue());

        realTimeDataService.create(realTimeData);
    }
}
