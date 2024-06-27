package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.Room;
import com.rmeunier.hotelapp.room.model.RoomStatus;
import com.rmeunier.hotelapp.room.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Room> saveNewRoom(Room room) {
        return ResponseEntity.ok(roomService.saveNewRoom(room));
    }

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable("id") Long id,
                           @RequestParam(value = "roomNumber", required = false) String roomNumber,
                           @RequestParam(value = "roomType", required = false) RoomType roomType,
                           @RequestParam( value = "status", required = false) RoomStatus status) {
        // TODO feedback after updating
        roomService.updateRoom(id, roomNumber, roomType, status);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") Long id) {
        // TODO feedback after deleting
        roomService.deleteRoom(id);
    }
}
