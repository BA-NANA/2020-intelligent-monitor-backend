package com.tjut.monitor.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*实时数据表*/
@Entity
@Data
@DynamicUpdate
public class RealTimeData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private BigDecimal monitor1;
  private BigDecimal monitor2;
  private BigDecimal monitor3;
  private BigDecimal monitor4;
  private BigDecimal monitor5;
  private BigDecimal monitor6;
  private BigDecimal monitor7;
  private BigDecimal monitor8;
  private BigDecimal monitor9;
  private BigDecimal monitor10;
  private BigDecimal monitor11;
  private BigDecimal monitor12;
  private BigDecimal monitor13;
  private BigDecimal monitor14;
  private BigDecimal monitor15;
  private BigDecimal monitor16;
  private BigDecimal monitor17;
  private BigDecimal monitor18;
  private BigDecimal monitor19;
  private BigDecimal monitor20;
  private BigDecimal monitor21;
  private BigDecimal monitor22;
  private BigDecimal monitor23;
  private BigDecimal monitor24;
  private BigDecimal monitor25;
  private BigDecimal monitor26;
  private BigDecimal monitor27;
  private BigDecimal monitor28;
  private BigDecimal monitor29;
  private BigDecimal monitor30;
  private BigDecimal monitor31;
  private Date monitorTime;

}
