package com.team.groupware.repository;

import com.team.groupware.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository를 상속받아 Reservation 엔티티와 ID의 타입인 Long을 제네릭으로 사용
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}