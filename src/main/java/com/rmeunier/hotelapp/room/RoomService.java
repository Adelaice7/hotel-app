package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.Room;
import com.rmeunier.hotelapp.room.model.RoomStatus;
import com.rmeunier.hotelapp.room.model.RoomType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));
    }

    public Room saveNewRoom(Room room) {
        if (roomRepository.findRoomByRoomNumber(room.getRoomNumber()).isPresent()) {
            throw new IllegalArgumentException("Room already exists with number: " + room.getRoomNumber());
        }

        return roomRepository.save(room);
    }

    @Transactional
    public void updateRoom(Long id, String roomNumber, RoomType roomType, RoomStatus status) {
        Room roomInDb = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + id));

        if (roomNumber != null && !Objects.equals(roomInDb.getRoomNumber(), roomNumber)) {
            roomInDb.setRoomNumber(roomNumber);
        }

        if (roomType != null && !Objects.equals(roomInDb.getRoomType(), roomType)) {
            roomInDb.setRoomType(roomType);
        }

        if (status != null && !Objects.equals(roomInDb.getStatus(), status)) {
            roomInDb.setStatus(status);
        }
    }

    public void deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {

            roomRepository.deleteById(id);
        }
    }
}
