package com.tjut.monitor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/*监测计划表*/
@Entity
@Data
public class MonitorPlan {

  @Id
  private Integer id;
  private String monitorType;
  private String monitorPlace;
  private String monitorName;
  private BigDecimal minValue;
  private BigDecimal maxValue;
  private String monitorUnit;
  private String monitorFrequency;

}
