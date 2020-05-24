package com.tjut.monitor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
/**维修表*/
public class Maintenance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer maintId;
  private String maintName;
  private String useTime;
  private String maintTime;
  private String maintStatus;
  private String reportStatus;
  private String maintPerson;
}
