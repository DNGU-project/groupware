package com.team.groupware.repository;

import com.team.groupware.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

  List<Board> findByTypeOrderByBnoDesc(String type);

  Board findByBno(Long bno);
}
