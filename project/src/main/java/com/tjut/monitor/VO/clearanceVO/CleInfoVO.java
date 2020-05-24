package com.tjut.monitor.VO.clearanceVO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CleInfoVO {
    @JsonProperty("cle_id")
    private Integer cleId;
    @JsonProperty("cle_name")
    private String cleName;
    @JsonProperty("cle_leader")
    private String cleLeader;
    @JsonProperty("leader_phone")
    private String leaderPhone;
    @JsonProperty("cle_place")
    private String clePlace;
    @JsonProperty("cle_remark")
    private String cleRemark;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("create_time")
    private String createTime;
}
