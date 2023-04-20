package com.team.groupware.service;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final EmployRepository employRepository;
  private final PasswordEncoder passwordEncoder;

  public boolean checkPassword(String empId, String checkPwd) {
    log.info("MemberService checkPassword.....");
    Employ employ = employRepository.findByEmpId(empId);
    String realPassword = employ.getPassword();
    return passwordEncoder.matches(checkPwd, realPassword);
  }
}
