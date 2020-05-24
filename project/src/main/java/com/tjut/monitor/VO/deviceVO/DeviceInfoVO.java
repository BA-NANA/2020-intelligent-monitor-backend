package com.tjut.monitor.VO.deviceVO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceInfoVO {
    @JsonProperty("device_id")
    private Integer deviceId;
    @JsonProperty("device_code")
    private String deviceCode;
    @JsonProperty("device_name")
    private String deviceName;
    @JsonProperty("device_size")
    private String deviceSize;
    @JsonProperty("device_category")
    private String deviceCategory;
    @JsonProperty("device_item")
    private String deviceItem;
    @JsonProperty("check_frequency")
    private String checkFrequency;
    @JsonProperty("device_producer")
    private String deviceProducer;
    @JsonProperty("create_time")
    private String createTime;
}
