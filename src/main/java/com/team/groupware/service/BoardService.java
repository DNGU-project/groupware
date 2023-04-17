package com.team.groupware.service;

import com.team.groupware.entity.Board;
import com.team.groupware.repository.BoardGrateRepository;
import com.team.groupware.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final BoardGrateRepository boardGrateRepository;

  public List<Board> getBoardList() {
    return boardRepository.findByTypeOrderByBnoDesc("F");
  }
  public Board getBoardDetail(Long bno) {
    return boardRepository.findByBno(bno);
  }
  public void saveBoard(Board board) {
    boardRepository.save(board);
  }
}
