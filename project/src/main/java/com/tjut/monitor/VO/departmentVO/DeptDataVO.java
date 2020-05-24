package com.tjut.monitor.VO.departmentVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeptDataVO {

    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("device_list")
    private List<DeptInfoVO> deptInfoVOList;
}
