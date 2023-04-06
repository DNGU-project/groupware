package com.team.groupware.controller;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;

@Controller
@RequiredArgsConstructor
public class MainController {

  @Autowired
  private final EmployRepository employRepository;

  @GetMapping("/")
  public String main(Model model) {
    Employ employ = employRepository.findByEmpId("112233");
    model.addAttribute("member", employ);
    return "index";
  }
}
