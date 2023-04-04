package com.team.groupware.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
@Getter
@Setter
@ToString
@Builder
public class Department {

  @Id
  @Column(name = "dept_no", nullable = false)
  private Integer deptNo;
  @Column(nullable = false, length = 30)
  private String deptName;

  public Department() {

  }

  public Department(Integer deptNo, String deptName) {
    this.deptNo = deptNo;
    this.deptName = deptName;
  }
}
