package com.tjut.monitor.VO.staffVO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffInfoVO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("department")
    private String department;
    @JsonProperty("position")
    private String position;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("create_time")
    private String createTime;
}
