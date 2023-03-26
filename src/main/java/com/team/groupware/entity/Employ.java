package com.team.groupware.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Employ")
@Getter
@Setter
@ToString
public class Employ {

  @Id
  @Column(name = "emp_no", nullable = false, length = 50)
  private String empNo;
  @Column(nullable = false, length = 50)
  private String password;
  @Column(nullable = false, length = 50)
  private String empName;
  @Column(unique = true, nullable = false, length = 100)
  private String email;
  @Column(nullable = false, length = 50)
  private String phone;
  @Column(nullable = false, length = 50)
  private String empPostcode;
  @Column(nullable = false, length = 100)
  private String address;
  @Column(nullable = false, length = 100)
  private String detailAddress;
  @Temporal(TemporalType.TIMESTAMP)
  @ColumnDefault("current_timestamp")
  private Date hireDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date leaveDate;
  @Column(nullable = false, length = 2)
  @ColumnDefault("'N'")
  private String isLeave;
  @Column(nullable = false)
  private int jobNo;
  @Column(nullable = false)
  private int deptNo;


}
