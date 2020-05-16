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
public class Staff {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /**员工ID*/
  private Integer staffId;
  /**姓名*/
  private String staffName;
  /**性别*/
  private String sex;
  /**年龄*/
  private Integer age;
  /**手机*/
  private String phone;
  /**部门*/
  private String department;
  /**职位*/
  private String position;
  /**更新信息时间*/
  private Date updateTime;
  /**创建信息时间*/
  private Date createTime;

}
