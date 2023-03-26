package com.team.groupware.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("list", "dddd");
    return "member/login";
  }
}
