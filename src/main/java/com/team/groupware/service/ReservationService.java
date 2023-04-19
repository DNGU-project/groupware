package com.team.groupware.service;

import com.team.groupware.entity.Reservation;
import com.team.groupware.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        System.out.println("test111");
    }

    public List<Reservation> getAllReservations() {
        System.out.println("tes222");
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        System.out.println("test333");
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        System.out.println("test444");
        return reservationRepository.save(reservation);
    }

    public void deleteReservationById(Long id) {
        System.out.println("test555");
        reservationRepository.deleteById(id);
    }
}