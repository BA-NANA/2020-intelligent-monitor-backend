package com.tjut.monitor.VO.monitorVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*第三层*/
@Data
public class MonitorDataListVO {

    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("monitor_item_list")
    private List<MonitorItemVO> monitorItemVOList;
}
