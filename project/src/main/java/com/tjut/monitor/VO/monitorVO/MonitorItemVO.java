package com.tjut.monitor.VO.monitorVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/*第四层*/
@Data
public class MonitorItemVO {

    @JsonProperty("id")
    public Integer monitorId;
    @JsonProperty("place")
    public String monitorPlace;
    @JsonProperty("type")
    public String monitorType;
    @JsonProperty("name")
    public String monitorName;
    @JsonProperty("min_value")
    public BigDecimal minValue;
    @JsonProperty("max_value")
    public BigDecimal maxValue;
    @JsonProperty("real_value")
    public BigDecimal realValue;
    @JsonProperty("unit")
    public String monitorUnit;
    @JsonProperty("frequency")
    public String monitorFrequency;
}
