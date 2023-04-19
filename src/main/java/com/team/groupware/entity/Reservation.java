package com.team.groupware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;    // 예약 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;  // 예약된 회의실

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employ empId;   // 예약한 사용자

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;    // 예약 시작 시간

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;  // 예약 종료 시간

    @PrePersist
    @PreUpdate
    private void validateTime() {
        if (startTime != null && endTime != null && startTime.after(endTime)) {
            throw new IllegalArgumentException("예약 시작 시간이 예약 종료 시간보다 이전일 수 없습니다.");
        }
    }
}
