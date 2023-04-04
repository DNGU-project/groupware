package com.team.groupware.controller;

import com.team.groupware.dao.EmployDAO;
import com.team.groupware.dto.LoginDTO;
import com.team.groupware.dto.CreateEmployDTO;
import com.team.groupware.entity.Employ;
import com.team.groupware.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
  private final EmployDAO employDAO;

  private final AccountService accountService;

  private final PasswordEncoder passwordEncoder; // 패스워드 암호화

  @GetMapping("/login")
  public String login(Model model) {
    return "account/login";
  }

  @PostMapping("/loginPost")
  public void loginPost(LoginDTO dto) throws Exception {

  }

  @GetMapping("/login/error")
  public String loginError(Model model) {
    model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
    return "account/login";
  }

  @GetMapping("/register")
  public String register(Model model) {
    return "account/register";
  }

  @PostMapping("/registerPost")
  public String registerPost(CreateEmployDTO createEmployDTO) {
    // 데이터가 제대로 들어왔나 확인하는 로그
    log.info("createEmployDTO={}",createEmployDTO);
    Employ employ = Employ.createEmploy(createEmployDTO, passwordEncoder);
    accountService.saveEmploy(employ);
    return "redirect:/account/login";
  }

}
