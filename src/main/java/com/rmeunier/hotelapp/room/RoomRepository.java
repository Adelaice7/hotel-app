package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findRoomByRoomNumber(String roomNumber);
}
