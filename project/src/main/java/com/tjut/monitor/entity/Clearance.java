package com.tjut.monitor.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
/**清算表*/
public class Clearance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cleId;
  private String cleName;
  private String cleLeader;
  private String leaderPhone;
  private String clePlace;
  private String cleRemark;
  private Date updateTime;
  private Date createTime;
}
