package com.rmeunier.hotelapp.room;

import com.rmeunier.hotelapp.room.model.Room;
import com.rmeunier.hotelapp.room.model.RoomStatus;
import com.rmeunier.hotelapp.room.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Room getRoomById(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room saveNewRoom(Room room) {
        return roomService.saveNewRoom(room);
    }

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable("id") Long id,
                           @RequestParam("roomNumber") String roomNumber,
                           @RequestParam("roomType") RoomType roomType,
                           @RequestParam("status") RoomStatus status) {
        roomService.updateRoom(id, roomNumber, roomType, status);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
    }
}
