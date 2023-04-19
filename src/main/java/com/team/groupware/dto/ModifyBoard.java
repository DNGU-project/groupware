package com.team.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyBoard {

  private Long bno;
  private String title;
  private String name;
  private String content;
  private String type;
  private String empId;
}
