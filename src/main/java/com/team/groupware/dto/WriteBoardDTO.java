package com.team.groupware.dto;

import com.team.groupware.entity.Board;
import com.team.groupware.entity.Employ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WriteBoardDTO {

  private String title;
  private String name;
  private String content;
  private String type;
  private String empId;

  public Board toEntity() {
    return Board.builder()
            .title(getTitle())
            .name(getName())
            .content(getContent())
            .type(getType())
            .empId(Employ.builder().empId(getEmpId()).build())
            .build();
  }
}
