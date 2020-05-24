package com.tjut.monitor.controller;

import com.tjut.monitor.VO.ResultVO;
import com.tjut.monitor.VO.clearanceVO.CleDataVO;
import com.tjut.monitor.VO.clearanceVO.CleInfoVO;
import com.tjut.monitor.entity.Clearance;
import com.tjut.monitor.service.ClearanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clearance")
public class ClearanceController {

    @Autowired
    private ClearanceService clearanceService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 1.创建一个新清算记录
     */
    @PostMapping("/add")
    public ResultVO createClearance(@RequestParam("name") String name,String leader,String phone,String place, String remark){
        Clearance clearance = new Clearance();
        clearance.setCleName(name);
        clearance.setCleLeader(leader);
        clearance.setLeaderPhone(phone);
        clearance.setClePlace(place);
        clearance.setCleRemark(remark);

        clearanceService.createClearance(clearance);
        return new ResultVO(0,"success");
    }

    /**
     * 2.通过id删除清算记录
     */
    @PostMapping("/delete")
    public ResultVO deleteClearance(@RequestParam("id")Integer id){
        clearanceService.deleteByClearanceId(id);
        return new ResultVO(0,"success");
    }

    /**
     * 3.更新清算信息
     */
    @PostMapping("/update")
    public ResultVO updateClearance(@RequestParam("id")Integer id,@RequestParam("name") String name,String leader,String phone,String place, String remark){
        Clearance clearance = new Clearance();
        clearance.setCleId(id);
        clearance.setCleName(name);
        clearance.setCleLeader(leader);
        clearance.setLeaderPhone(phone);
        clearance.setClePlace(place);
        clearance.setCleRemark(remark);

        clearanceService.updateClearance(clearance);
        return new ResultVO(0,"success");
    }

    /**
     * 4.获取所有清算信息
     */
    @GetMapping("/getAll")
    public ResultVO getAllClearance(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        Page<Clearance> page = clearanceService.getAllClearance(pageNum,pageSize);
        List<Clearance> clearanceList = page.getContent();

        List<CleInfoVO> cleInfoVOList = new ArrayList<>();

        for(Clearance clearance : clearanceList ){
            CleInfoVO cleInfoVO = new CleInfoVO();
            cleInfoVO.setCleId(clearance.getCleId());
            cleInfoVO.setCleName(clearance.getCleName());
            cleInfoVO.setCleLeader(clearance.getCleLeader());
            cleInfoVO.setLeaderPhone(clearance.getLeaderPhone());
            cleInfoVO.setClePlace(clearance.getClePlace());
            cleInfoVO.setCleRemark(clearance.getCleRemark());
            cleInfoVO.setUpdateTime(sdf.format(clearance.getUpdateTime()));
            cleInfoVO.setCreateTime(sdf.format(clearance.getCreateTime()));

            cleInfoVOList.add(cleInfoVO);
        }

        CleDataVO cleDataVO = new CleDataVO();
        cleDataVO.setTotalNum((int) page.getTotalElements());
        cleDataVO.setCleInfoVOList(cleInfoVOList);

        ResultVO resultVO = new ResultVO(0,"success");
        resultVO.setData(cleDataVO);
        return resultVO;
    }
}
