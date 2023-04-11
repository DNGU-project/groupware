package com.team.groupware.repository;

import com.team.groupware.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

// CURD 함수를 JpaRepository가 들고 있음
// @Repository라는 어노테이션이 없어도 loC 됨. 이유는 JpaRepository를 상속했기 때문에
public interface EmployRepository extends JpaRepository<Employ, String> {

  // Jpa Query 메서드
  // findBy 규칙 => Employ 문법
  // select * from employ where emp_id = ?
  Employ findByEmpId(String empId);
}
