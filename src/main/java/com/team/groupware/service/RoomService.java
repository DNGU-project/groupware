package com.team.groupware.service;

import com.team.groupware.entity.Room;
import com.team.groupware.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        System.out.println("test11");
    }

    public List<Room> getAllRooms() {
        System.out.println("test22");
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        System.out.println("test33");
        return roomRepository.findById(id);
    }

    public Room saveRoom(Room room) {
        System.out.println("test44");
        return roomRepository.save(room);
    }

    public void deleteRoomById(Long id) {
        System.out.println("test55");
        roomRepository.deleteById(id);
    }
}