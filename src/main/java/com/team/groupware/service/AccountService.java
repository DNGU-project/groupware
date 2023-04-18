package com.team.groupware.service;

import com.team.groupware.dto.MyPageDTO;
import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

  public void employInfoUpdate(MyPageDTO dto) {
    Employ employ = employRepository.findByEmpId(dto.getEmpId());
    employ.update(dto.getEmpId(), dto.getName(), dto.getPhone(), dto.getPostcode(), dto.getAddress(), dto.getDetailAddress());
    log.info("회원정보 수정 완료");
  }
}
