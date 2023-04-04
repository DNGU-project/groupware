package com.team.groupware.dao;

import com.team.groupware.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployDAO extends JpaRepository<Employ, String> {
  Optional<Employ> findByEmpId(String empId);
}
