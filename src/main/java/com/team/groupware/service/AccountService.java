package com.team.groupware.service;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
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
public class AccountService {

  private final EmployRepository employRepository;

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

}
