package com.tjut.monitor.VO.departmentVO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeptInfoVO {
    @JsonProperty("dept_id")
    private Integer deptId;
    @JsonProperty("dept_name")
    private String deptName;
    @JsonProperty("dept_phone")
    private String deptPhone;
    @JsonProperty("dept_leader")
    private String deptLeader;
    @JsonProperty("leader_phone")
    private String leaderPhone;
    @JsonProperty("dept_remark")
    private String deptRemark;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("create_time")
    private String createTime;
}
