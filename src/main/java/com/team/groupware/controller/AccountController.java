package com.team.groupware.controller;

import com.team.groupware.dto.CreateEmployDTO;
import com.team.groupware.dto.MyPageDTO;
import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import com.team.groupware.service.AccountService;
import com.team.groupware.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
  // 생성자 주입
  private final AccountService accountService;
  private final MemberService memberService;
  private final EmployRepository employRepository;
  private final PasswordEncoder passwordEncoder; // 패스워드 암호화

  @GetMapping("/login")
  public String login(Model model) {
    return "account/login";
  }

  @PostMapping("/loginPost")
  public void loginPost() throws Exception {
  }

  @GetMapping("/register")
  public String register(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "account/register";
  }

  @PostMapping("/registerPost")
  public String registerPost(CreateEmployDTO createEmployDTO) {
    // 데이터가 제대로 들어왔나 확인하는 로그
    log.info("createEmployDTO={}", createEmployDTO);
    Employ employ = Employ.createEmploy(createEmployDTO, passwordEncoder);
    accountService.saveEmploy(employ);
    return "redirect:/account/login";
  }

  @GetMapping("/checkPwd")
  public String checkPwdView(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "account/checkPwd";
  }

  @GetMapping("/checkPassword")
  @ResponseBody
  public boolean checkPassword(Principal principal, @RequestParam String password, Model model) {
    log.info("checkPwd 진입");
    log.info(password);
    String empId = principal.getName();
    return memberService.checkPassword(empId, password);
  }

  @GetMapping("/myPage")
  public String myPage(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "account/myPage";
  }

  @PostMapping("/myPagePut")
  @ResponseBody
  public boolean myPagePut(@RequestBody MyPageDTO dto) {
    log.info("AccountController myPagePut.....");
    log.info("DTO: " + dto);
    accountService.employInfoUpdate(dto);
    return true;
  }

}
