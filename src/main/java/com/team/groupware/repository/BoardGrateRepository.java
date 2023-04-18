package com.team.groupware.repository;

import com.team.groupware.entity.BoardGrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface BoardGrateRepository extends JpaRepository<BoardGrate, Integer> {

  @Query("SELECT COUNT(b) FROM BoardGrate b GROUP BY b.bno")
  ArrayList<Long> countByBno();
}
