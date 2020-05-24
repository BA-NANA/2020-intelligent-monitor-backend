package com.tjut.monitor.VO.clearanceVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjut.monitor.VO.departmentVO.DeptInfoVO;
import lombok.Data;

import java.util.List;

@Data
public class CleDataVO {
    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("clearance_list")
    private List<CleInfoVO> cleInfoVOList;
}
