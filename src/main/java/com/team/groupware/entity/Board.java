package com.team.groupware.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Board")
@Data
@Builder
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
  @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
  private Timestamp writeDate;
  @ColumnDefault("0")
  private int views;
  @Column(columnDefinition = "CHAR(1) DEFAULT 'F'")
  private String type;
  @ColumnDefault("0")
  private int grate;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "emp_id", nullable = false)
  private Employ empId;

  public void update(String title, String name, String content, String type, String empId) {
    this.title = title;
    this.name = name;
    this.content = content;
    this.type = type;
    this.empId = Employ.builder().empId(empId).build();
  }

}
