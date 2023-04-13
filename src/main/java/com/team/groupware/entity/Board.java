package com.team.groupware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long bno;
  @Column(nullable = false, length = 100)
  private String title;
  @Column(nullable = false, length = 50)
  private String name;
  @Column(nullable = false)
  private String content;
  @CreationTimestamp
  @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
  private Timestamp writeDate;
  @Column(nullable = false)
  @ColumnDefault("0")
  private Integer views;
  @Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'F'")
  private String type;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id", nullable = false)
  private Employ empId;

}
