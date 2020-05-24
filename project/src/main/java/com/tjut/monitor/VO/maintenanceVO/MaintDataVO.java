package com.tjut.monitor.VO.maintenanceVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjut.monitor.VO.clearanceVO.CleInfoVO;
import lombok.Data;

import java.util.List;

@Data
public class MaintDataVO {
    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("clearance_list")
    private List<MaintInfoVO> maintInfoVOList;
}
