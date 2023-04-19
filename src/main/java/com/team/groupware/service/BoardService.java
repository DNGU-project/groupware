package com.team.groupware.service;

import com.team.groupware.dto.ModifyBoard;
import com.team.groupware.entity.Board;
import com.team.groupware.repository.BoardGrateRepository;
import com.team.groupware.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
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

  public void boardUpdate(ModifyBoard dto) {
    Board board = boardRepository.findByBno(dto.getBno());
    board.update(dto.getTitle(), dto.getName(), dto.getContent(), dto.getType(), dto.getEmpId());
    log.info("BoardService... 글 수정 완료");
  }
}
