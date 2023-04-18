package com.team.groupware.config.auth;

import com.team.groupware.entity.Employ;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/*
  security가 /loginPost 주소 요청이 오면 낚아채서 로그인을 진행
  로그인 진행이 완료가 되면 security session을 만듬(Security ContextHolder)
  오브젝트 타입 => Authentication 타입 객체
  Authentication 안에 User 정보가 있어야 됨
  User 오브젝트 타입 => UserDetails 타입 객체

  Security Session => Authentication => UserDetails
*/
public class PrincipalDetails implements UserDetails {

  private final Employ employ; // 컴포지션

  public PrincipalDetails(Employ employ) {
    this.employ = employ;
  }

  // 해당 User의 권한을 리턴하는 장소
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collect = new ArrayList<>();
    collect.add((GrantedAuthority) employ::getRole);
    return collect;
  }

  @Override
  public String getPassword() {
    return employ.getPassword();
  }

  @Override
  public String getUsername() {
    return employ.getEmpId();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    /*
    * 사이트에서 1년동안 회원이 로그인을 하지 않으면 휴먼계정으로 돌리는것으로 정했다면,
    * entity에 Timestamp loginDate를 넣어 로그인 할때마다 날짜를 갱신
    * get.loginDate();
    * 현재시간 - 로그인시간 => 1년을 초과하면 return false;
    */
    return true;
  }
}
