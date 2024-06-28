package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.RoomInventory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomInventoryService {

    private final RoomInventoryRepository roomInventoryRepository;

    public RoomInventoryService(RoomInventoryRepository roomInventoryRepository) {
        this.roomInventoryRepository = roomInventoryRepository;
    }

    public List<RoomInventory> getAllRoomInventory() {
        return roomInventoryRepository.findAll();
    }

    public RoomInventory getRoomInventoryById(Long id) throws RoomInventoryNotFoundException {
        return roomInventoryRepository.findById(id)
               .orElseThrow(() -> new RoomInventoryNotFoundException("RoomInventory of " + id + " not found."));
    }

    public RoomInventory createRoomInventory(RoomInventory roomInventory) {
        return roomInventoryRepository.save(roomInventory);
    }

    public RoomInventory updateRoomInventory(String roomType, LocalDate date, int totalInventory) throws RoomInventoryNotFoundException {
        RoomInventory roomInventory = roomInventoryRepository.findRoomInventoryByRoomType(roomType)
                .orElseThrow(() -> new RoomInventoryNotFoundException("RoomInventory not found with roomType: " + roomType));

        roomInventory.setTotalInventory(totalInventory);
        roomInventory.setDate(date);

        return roomInventoryRepository.save(roomInventory);
    }

    public void deleteRoomInventoryById(Long id) {
        if (roomInventoryRepository.existsById(id)) {
            roomInventoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("RoomInventory not found with id: " + id);
        }
    }
}
