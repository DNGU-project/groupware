package com.team.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployDTO {

  private String empId;
  private String password;
  private String name;
  private String email;
  private String phone;
  private String postcode;
  private String address;
  private String detailAddress;
  private Integer jobNo;
  private Integer deptNo;

}
