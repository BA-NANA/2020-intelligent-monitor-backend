package com.tjut.monitor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
/**设备表*/
public class Device {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deviceId;
  private String deviceCode;
  private String deviceName;
  private String deviceSize;
  private String deviceCategory;
  private String item;
  private String checkFrequency;
  private String deviceProducer;
  private String createTime;
}
