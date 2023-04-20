package com.team.groupware.repository;

import com.team.groupware.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  Department findByDeptNo(Integer deptNo);
}
