package com.tjut.monitor.VO.staffVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StaffDataVO {

    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("staff_list")
    private List<StaffInfoVO> staffInfoVOList;
}
