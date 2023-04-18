package com.team.groupware.config;

import com.team.groupware.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity // spring security 필터가 spring 필터체인에 등록됨
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private AccountService accountService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("security config......");
    http
            .headers()
            .and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            // http 요청에 대한 보안 설정
            .authorizeRequests()
            .antMatchers("/account/login").authenticated() // 인증되지 않은 유저만 허용
//            .anyRequest().access("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
            .anyRequest().access("hasRole('ROLE_MEMBER')")
            .and()
            // 로그인 설정
            .formLogin()
            .loginPage("/account/login") // 로그인 인증 경로 등록
            .loginProcessingUrl("/account/loginPost")
            .usernameParameter("empId") // username대신 받을 아이디 파라미터
            .defaultSuccessUrl("/") // 로그인 인증을 성공하면 이동할 페이지 등록
            .permitAll()
            .and()
            // 로그아웃 설정
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/account/logout")) // 로그아웃 경로 설정
            .logoutSuccessUrl("/account/login") // 로그아웃 설공 시 이동할 경로 지정
            .invalidateHttpSession(true).deleteCookies("JSESSIONID")
            .and()
            .exceptionHandling();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
  }

  // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록
  @Bean
  public PasswordEncoder passwordencoder() {
    return new BCryptPasswordEncoder();
  }
  
}
