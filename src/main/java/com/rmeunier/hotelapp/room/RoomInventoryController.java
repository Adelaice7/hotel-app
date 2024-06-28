package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.RoomInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room-inventory")
public class RoomInventoryController {

    private final RoomInventoryService roomInventoryService;

    @Autowired
    public RoomInventoryController(RoomInventoryService roomInventoryService) {
        this.roomInventoryService = roomInventoryService;
    }

    @GetMapping
    public List<RoomInventory> getAllRoomInventory() {
        return roomInventoryService.getAllRoomInventory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomInventory> getRoomInventoryById(@PathVariable("id") Long id) throws RoomInventoryNotFoundException {
        return ResponseEntity.ok(roomInventoryService.getRoomInventoryById(id));
    }

    @PostMapping
    public ResponseEntity<RoomInventory> createRoomInventory(RoomInventory roomInventory) {
        return ResponseEntity.ok(roomInventoryService.createRoomInventory(roomInventory));
    }

    @PutMapping
    public ResponseEntity<RoomInventory> updateRoomInventory(
            @RequestParam("roomType") String roomType,
            @RequestParam("date") LocalDate date,
            @RequestParam("totalInventory") int totalInventory) throws RoomInventoryNotFoundException {
        return ResponseEntity.ok(roomInventoryService.updateRoomInventory(roomType, date, totalInventory));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoomInventoryById(@PathVariable("id") Long id) {
        roomInventoryService.deleteRoomInventoryById(id);
        return ResponseEntity.ok().build();
    }

}
