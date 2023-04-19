package com.team.groupware.repository;

import com.team.groupware.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository를 상속받아 Room 엔티티와 ID의 타입인 Long을 제네릭으로 사용
public interface RoomRepository extends JpaRepository<Room, Long> {
}