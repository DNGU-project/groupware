package com.team.groupware.config.auth;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/*
* security 설정에서 loginProcessingUrl("/account/loginPost");
* /account/loginPost 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행
*/
@Service
public class PrincipalDetailsService implements UserDetailsService {

  @Autowired
  private EmployRepository employRepository;

  // security session(Authentication(UserDetails))
  @Override
  public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
    System.out.println("empId: " + empId);
    Employ employ = employRepository.findByEmpId(empId);
    if (employ != null) {
      return new PrincipalDetails(employ);
    }
    return null;
  }
}
