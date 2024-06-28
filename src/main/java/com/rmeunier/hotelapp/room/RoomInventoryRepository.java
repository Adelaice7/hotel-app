package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.RoomInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomInventoryRepository extends JpaRepository<RoomInventory, Long> {
    Optional<RoomInventory> findRoomInventoryByRoomType(String roomType);
}
