package com.team.groupware.controller;

import com.team.groupware.entity.Employ;
import com.team.groupware.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  private final EmployRepository employRepository;

  @GetMapping("/freeBoard")
  public String freeBoard(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/freeBoard";
  }

  @GetMapping("/notice")
  public String notice(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/notice";
  }

  @GetMapping("/read")
  public String readBoard(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/read";
  }

  @GetMapping("/write")
  public String writeBoard(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/write";
  }
}
