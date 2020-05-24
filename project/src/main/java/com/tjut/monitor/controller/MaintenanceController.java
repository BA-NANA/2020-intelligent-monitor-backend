package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.maintenanceVO.MaintDataVO;
import com.tjut.monitor.VO.maintenanceVO.MaintInfoVO;
import com.tjut.monitor.entity.Maintenance;
import com.tjut.monitor.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    /**
     * 1.创建一个新检修记录
     */
    @PostMapping("/add")
    public ResultVO createMaintenance(@RequestParam("name") String name, @RequestParam("use_time")String useTime, @RequestParam("maint_time") String maintTime,
                                      @RequestParam("maint_status")String maintStatus,@RequestParam("report_status")String reportStatus,@RequestParam("person")String person){

        Maintenance maintenance = new Maintenance();
        maintenance.setMaintName(name);
        maintenance.setUseTime(useTime);
        maintenance.setMaintTime(maintTime);
        maintenance.setMaintStatus(maintStatus);
        maintenance.setReportStatus(reportStatus);
        maintenance.setMaintPerson(person);

        maintenanceService.createMaintenance(maintenance);
        return new ResultVO(0,"success");
    }

    /**
     * 2.通过id删除检修记录
     */
    @PostMapping("/delete")
    public ResultVO deleteMaintenance(@RequestParam("id")Integer id){
        maintenanceService.deleteByMaintenanceId(id);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更新检修信息
     */
    @PostMapping("/update")
    public ResultVO updateMaintenance(@RequestParam("id")Integer id,@RequestParam("name") String name, @RequestParam("use_time")String useTime, @RequestParam("maint_time") String maintTime,
                                 @RequestParam("maint_status")String maintStatus,@RequestParam("report_status")String reportStatus,@RequestParam("person")String person){

        Maintenance maintenance = new Maintenance();
        maintenance.setMaintId(id);
        maintenance.setMaintName(name);
        maintenance.setUseTime(useTime);
        maintenance.setMaintTime(maintTime);
        maintenance.setMaintStatus(maintStatus);
        maintenance.setReportStatus(reportStatus);
        maintenance.setMaintPerson(person);

        maintenanceService.updateMaintenance(maintenance);
        return new ResultVO(0,"success");
    }

    /**
     * 4.获取所有检修记录
     */
    @GetMapping("/getAll")
    public ResultVO getAllMaintenance(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<Maintenance> page = maintenanceService.getAllMaintenance(pageNum,pageSize);
        List<Maintenance> maintenanceList = page.getContent();

        List<MaintInfoVO> maintInfoVOList = new ArrayList<>();

        for(Maintenance maintenance : maintenanceList ){
            MaintInfoVO maintInfoVO = new MaintInfoVO();
            maintInfoVO.setMaintId(maintenance.getMaintId());
            maintInfoVO.setMaintName(maintenance.getMaintName());
            maintInfoVO.setUserTime(maintenance.getUseTime());
            maintInfoVO.setMaintTime(maintenance.getMaintTime());
            maintInfoVO.setMaintStatus(maintenance.getMaintStatus());
            maintInfoVO.setReportStatus(maintenance.getReportStatus());
            maintInfoVO.setMaintPerson(maintenance.getMaintPerson());

            maintInfoVOList.add(maintInfoVO);
        }

        MaintDataVO maintDataVO = new MaintDataVO();
        maintDataVO.setTotalNum((int) page.getTotalElements());
        maintDataVO.setMaintInfoVOList(maintInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(maintDataVO);

        return resultVO;
    }

}
