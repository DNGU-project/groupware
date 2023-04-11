package com.team.groupware.controller;

import com.team.groupware.entity.Employ;
import com.team.groupware.entity.Job;
import com.team.groupware.repository.EmployRepository;
import com.team.groupware.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

  private final EmployRepository employRepository;
  private final JobRepository jobRepository;

  @GetMapping("/")
  public String main(Model model, Principal principal) {
    // 로그인된 정보를 이용해서 정보 가져오기
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "index";
  }
}
