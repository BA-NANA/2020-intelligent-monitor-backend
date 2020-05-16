package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.monitorVO.MonitorDataListVO;
import com.tjut.monitor.VO.monitorVO.MonitorDataVO;
import com.tjut.monitor.VO.monitorVO.MonitorItemVO;
import com.tjut.monitor.entity.MonitorPlan;
import com.tjut.monitor.entity.RealTimeData;
import com.tjut.monitor.service.MonitorPlanService;
import com.tjut.monitor.service.RealTimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private RealTimeDataService realTimeDataService;
    @Autowired
    private MonitorPlanService monitorPlanService;

    @GetMapping("/getAll")
    public ResultVO getAll(@RequestParam("type")String type, @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Page<MonitorPlan> monitorPlanPage = monitorPlanService.getAll(0,50);

        List<MonitorPlan> monitorPlanList = monitorPlanPage.getContent();

        Page<RealTimeData> realPage = realTimeDataService.getAll(pageNum,pageSize);

        List<RealTimeData> realList = realPage.getContent();

        /*第二层*/
        List<MonitorDataListVO> monitorDataListVOList = new ArrayList<>();

        /*视图拼装*/
        for(int i=realList.size()-1; i>=0; i--) {

            ArrayList list = new ArrayList();

            RealTimeData realTimeData = realList.get(i);
            addToArray(realTimeData, list);

            /*第三层*/
            MonitorDataListVO monitorDataListVO = new MonitorDataListVO();

            /*第四层*/
            List<MonitorItemVO> monitorItemVOList = new ArrayList<>();

            int tag=1;
            for(MonitorPlan monitorPlan : monitorPlanList){
                if(!monitorPlan.getMonitorType().equals(type)){
                    continue;
                }
                MonitorItemVO monitorItemVO = new MonitorItemVO();
                monitorItemVO.setMonitorId(monitorPlan.getId());
                monitorItemVO.setMonitorPlace(monitorPlan.getMonitorPlace());
                monitorItemVO.setMonitorType(monitorPlan.getMonitorType());
                monitorItemVO.setMonitorName(monitorPlan.getMonitorName());
                monitorItemVO.setMinValue(monitorPlan.getMinValue());
                monitorItemVO.setMaxValue(monitorPlan.getMaxValue());
                monitorItemVO.setRealValue((BigDecimal) list.get(tag-1));
                monitorItemVO.setMonitorUnit(monitorPlan.getMonitorUnit());
                monitorItemVO.setMonitorFrequency(monitorPlan.getMonitorFrequency());
                monitorItemVOList.add(monitorItemVO);
                tag++;
            }
            monitorDataListVO.setUpdateTime(sdf.format(realTimeData.getMonitorTime()));
            monitorDataListVO.setMonitorItemVOList(monitorItemVOList);
            monitorDataListVOList.add(monitorDataListVO);
        }

        /*第一层*/
        MonitorDataVO monitorDataVO = new MonitorDataVO();
        monitorDataVO.setTotalNum(monitorDataListVOList.size());
        monitorDataVO.setMonitorDataListVOList(monitorDataListVOList);

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(monitorDataVO);

        return resultVO;
    }

    private void addToArray(RealTimeData realTimeData, ArrayList list) {
        list.add(realTimeData.getMonitor1());
        list.add(realTimeData.getMonitor2());
        list.add(realTimeData.getMonitor3());
        list.add(realTimeData.getMonitor4());
        list.add(realTimeData.getMonitor5());
        list.add(realTimeData.getMonitor6());
        list.add(realTimeData.getMonitor7());
        list.add(realTimeData.getMonitor8());
        list.add(realTimeData.getMonitor9());
        list.add(realTimeData.getMonitor10());
        list.add(realTimeData.getMonitor11());
        list.add(realTimeData.getMonitor12());
        list.add(realTimeData.getMonitor13());
        list.add(realTimeData.getMonitor14());
        list.add(realTimeData.getMonitor15());
        list.add(realTimeData.getMonitor16());
        list.add(realTimeData.getMonitor17());
        list.add(realTimeData.getMonitor18());
        list.add(realTimeData.getMonitor19());
        list.add(realTimeData.getMonitor20());
        list.add(realTimeData.getMonitor21());
        list.add(realTimeData.getMonitor22());
        list.add(realTimeData.getMonitor23());
        list.add(realTimeData.getMonitor24());
        list.add(realTimeData.getMonitor25());
        list.add(realTimeData.getMonitor26());
        list.add(realTimeData.getMonitor27());
        list.add(realTimeData.getMonitor28());
        list.add(realTimeData.getMonitor29());
        list.add(realTimeData.getMonitor30());
        list.add(realTimeData.getMonitor31());
    }
}
