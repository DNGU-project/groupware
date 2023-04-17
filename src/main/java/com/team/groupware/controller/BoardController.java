package com.team.groupware.controller;

import com.team.groupware.dto.WriteBoardDTO;
import com.team.groupware.entity.Board;
import com.team.groupware.entity.BoardGrate;
import com.team.groupware.entity.Employ;
import com.team.groupware.repository.BoardGrateRepository;
import com.team.groupware.repository.BoardRepository;
import com.team.groupware.repository.EmployRepository;
import com.team.groupware.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;
  private final EmployRepository employRepository;
  private final BoardRepository boardRepository;

  @GetMapping("/freeBoard")
  public String freeBoard(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    List<Board> boardList = boardService.getBoardList();

    model.addAttribute("member", employ);
    model.addAttribute("freeBoard", boardList);
    return "board/freeBoard";
  }

  @GetMapping("/notice")
  public String notice(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/notice";
  }

  @GetMapping("/read")
  public String readBoard(Model model, Principal principal, @RequestParam Long bno) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    Board board = boardService.getBoardDetail(bno);

    model.addAttribute("member", employ);
    model.addAttribute("board", board);
    return "board/read";
  }

  @GetMapping("/write")
  public String writeBoard(Model model, Principal principal) {
    Employ employ = employRepository.findByEmpId(principal.getName());
    model.addAttribute("member", employ);
    return "board/write";
  }

  @PostMapping("/writePost")
  @ResponseBody
  public boolean writePost(@RequestBody WriteBoardDTO dto) {
    log.info("BoardController writePost.....");
    boardService.saveBoard(dto.toEntity());
    return true;
  }
}
