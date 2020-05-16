package com.tjut.monitor.VO.monitorVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*第二层*/
@Data
public class MonitorDataVO {

    @JsonProperty("total_num")
    public Integer totalNum;
    @JsonProperty("monitor_list")
    public List<MonitorDataListVO> monitorDataListVOList;
}
