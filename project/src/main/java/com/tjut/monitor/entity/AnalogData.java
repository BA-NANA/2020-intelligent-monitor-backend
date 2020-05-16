package com.tjut.monitor.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*模拟数据*/
@Entity
@Data
@DynamicUpdate
public class AnalogData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer monitorId;
  private BigDecimal monitorValue;
  private Date monitorTime;
}
