package com.tjut.monitor.VO.maintenanceVO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintInfoVO {
    @JsonProperty("maint_id")
    private Integer maintId;
    @JsonProperty("maint_name")
    private String maintName;
    @JsonProperty("user_time")
    private String userTime;
    @JsonProperty("maint_time")
    private String maintTime;
    @JsonProperty("maint_status")
    private String maintStatus;
    @JsonProperty("report_status")
    private String reportStatus;
    @JsonProperty("maint_person")
    private String maintPerson;
}
