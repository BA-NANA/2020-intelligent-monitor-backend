package com.tjut.monitor.VO.userVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjut.monitor.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDataVO {

    @JsonProperty("total_num")
    private Integer totalNum;
    @JsonProperty("user_list")
    private List<UserInfoVO> userInfoVOList;
}
