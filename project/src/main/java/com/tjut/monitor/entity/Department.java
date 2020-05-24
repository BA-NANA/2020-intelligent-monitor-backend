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
/**部门表*/
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deptId;
  private String deptName;
  private String deptPhone;
  private String deptLeader;
  private String leaderPhone;
  private String deptRemark;
  private Date updateTime;
  private Date createTime;
}
