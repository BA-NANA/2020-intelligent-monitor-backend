package com.tjut.monitor.VO.deviceVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeviceDataVO {

    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("device_list")
    private List<DeviceInfoVO> deviceInfoVOList;

}
