package com.team.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageDTO {

  private String empId;
  private String name;
  private String phone;
  private String postcode;
  private String address;
  private String detailAddress;

}
