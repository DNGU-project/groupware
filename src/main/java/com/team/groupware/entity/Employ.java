package com.team.groupware.entity;

import com.team.groupware.dto.CreateEmployDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name="Employ")
@NoArgsConstructor
@AllArgsConstructor
public class Employ {

  @Id
  @Column(name = "emp_id", nullable = false, length = 50)
  private String empId;
  @Column(nullable = false, length = 200)
  private String password;
  @Column(nullable = false, length = 50)
  private String name;
  @Column(unique = true, nullable = false, length = 100)
  private String email;
  @Column(unique = true, nullable = false, length = 50)
  private String phone;
  @Column(nullable = false, length = 50)
  private String postcode;
  @Column(nullable = false, length = 100)
  private String address;
  @Column(nullable = false, length = 100)
  private String detailAddress;
  @CreationTimestamp
  @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
  private Timestamp hireDate;
  @Temporal(TemporalType.DATE)
  private Date leaveDate;
  @Column(length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
  private String isLeave;
  @Column(nullable = false)
  private String role;
  @ManyToOne
  @JoinColumn(name = "job_no", nullable = false)
  private Job jobNo;
  @ManyToOne
  @JoinColumn(name = "dept_no", nullable = false)
  private Department deptNo;

  // 사원등록 페이지에서 데이터를 받아 employ에 저장
  public static Employ createEmploy(CreateEmployDTO createEmployDTO, PasswordEncoder passwordEncoder) {
    Employ employ = new Employ();
    employ.setEmpId(createEmployDTO.getEmpId());
    String password = passwordEncoder.encode(createEmployDTO.getPassword());
    employ.setPassword(password);
    employ.setName(createEmployDTO.getName());
    employ.setEmail(createEmployDTO.getEmail());
    employ.setPhone(createEmployDTO.getPhone());
    employ.setPostcode(createEmployDTO.getPostcode());
    employ.setAddress(createEmployDTO.getAddress());
    employ.setDetailAddress(createEmployDTO.getDetailAddress());
    employ.setIsLeave("N");
    employ.setRole("ROLE_MEMBER");
    employ.setDeptNo(Department.builder().deptNo(createEmployDTO.getDeptNo()).build());
    employ.setJobNo(Job.builder().jobNo(createEmployDTO.getJobNo()).build());
    return employ;
  }

  public void update(String empId, String name, String phone, String postcode, String address, String detailAddress) {
    this.empId = empId;
    this.name = name;
    this.phone = phone;
    this.postcode = postcode;
    this.address = address;
    this.detailAddress = detailAddress;
  }

}

