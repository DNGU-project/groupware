package com.team.groupware.repository;

import com.team.groupware.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {

  Job findByJobNo(Integer jobNo);
}
