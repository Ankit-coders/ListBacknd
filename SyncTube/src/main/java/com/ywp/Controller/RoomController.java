package com.ywp.Controller;


import com.ywp.DTO.ChangeVideoRequest;
import com.ywp.DTO.CreateRoomRequest;
import com.ywp.DTO.RoomResponse;
import com.ywp.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://songwithfriend-1.vercel.app/")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public RoomResponse createRoom(
            @RequestBody CreateRoomRequest request){

        return roomService.createRoom(request);

    }

    @GetMapping("/{roomCode}")
    public RoomResponse getRoom(
            @PathVariable String roomCode){

        return roomService.getRoom(roomCode);

    }


    @PostMapping("/change-video")
    public RoomResponse changeVideo(
            @RequestBody ChangeVideoRequest request){

        return roomService.changeVideo(request);

    }

}
