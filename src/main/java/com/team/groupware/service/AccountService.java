package com.team.groupware.service;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import com.team.groupware.repository.DepartmentRepository;
import com.team.groupware.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

  private final EmployRepository employRepository;
  private final DepartmentRepository departmentRepository;
  private final JobRepository jobRepository;

  public Employ saveEmploy(Employ employ) {
    validateDuplicateEmploy(employ);

    return employRepository.save(employ);
  }

  // 이미 등록된 사원번호인지 체크
  private void validateDuplicateEmploy(Employ employ) {
    Employ findEmploy = employRepository.findByEmpId(employ.getEmpId());
    if (findEmploy != null) {
      throw new IllegalStateException("이미 가입된 사원번호입니다.");
    }
  }

  @Override
  public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
    Employ employ = employRepository.findByEmpId(empId);

    if(employ == null) {
      throw new UsernameNotFoundException(empId);
    }

    return User.builder()
            .username(employ.getEmpId())
            .password(employ.getPassword())
            .build();
  }
}
