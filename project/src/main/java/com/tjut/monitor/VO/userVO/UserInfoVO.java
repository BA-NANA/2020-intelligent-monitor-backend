package com.tjut.monitor.VO.userVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoVO {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_pass")
    private String userPassword;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("create_time")
    private String createTime;

}
