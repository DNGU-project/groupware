package com.team.groupware.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Job")
@Data
@Builder
public class Job {

  @Id
  @Column(name = "job_no", nullable = false)
  private Integer jobNo;
  @Column(nullable = false, length = 30)
  private String jobName;

  public Job() {

  }

  public Job(Integer jobNo, String jobName) {
    this.jobNo = jobNo;
    this.jobName = jobName;
  }
}
