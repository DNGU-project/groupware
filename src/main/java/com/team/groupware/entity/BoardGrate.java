package com.team.groupware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BoardGrate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BoardGrate.class)
public class BoardGrate implements Serializable {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bno", nullable = false)
  private Board bno;
  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id", nullable = false)
  private Employ empId;

}
