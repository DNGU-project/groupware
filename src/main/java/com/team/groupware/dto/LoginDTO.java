package com.team.groupware.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

  private String empId;
  private String password;
}
