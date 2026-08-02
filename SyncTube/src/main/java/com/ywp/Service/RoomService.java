package com.ywp.Service;


import com.ywp.DTO.ChangeVideoRequest;
import com.ywp.DTO.CreateRoomRequest;
import com.ywp.DTO.RoomResponse;

public interface RoomService {

    RoomResponse createRoom(CreateRoomRequest request);

    RoomResponse getRoom(String roomCode);
    RoomResponse changeVideo(ChangeVideoRequest request);

}