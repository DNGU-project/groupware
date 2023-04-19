package com.team.groupware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "room")
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;    // 회의실 아이디

    @Column(name = "name")
    private String name;    // 회의실 이름

    @Column(name = "capacity")
    private int capacity;   // 수용인원

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    private List<Reservation> reservations = new ArrayList<>(); // 회의실에 예약된 목록
}
