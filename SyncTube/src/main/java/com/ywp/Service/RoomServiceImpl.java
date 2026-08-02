package com.ywp.Service;




import com.ywp.DTO.ChangeVideoRequest;
import com.ywp.DTO.CreateRoomRequest;
import com.ywp.DTO.RoomResponse;
import com.ywp.Entity.Room;
import com.ywp.Repositry.RoomRepository;
import com.ywp.Util.RoomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    @Override
    public RoomResponse createRoom(CreateRoomRequest request) {

        Room room=Room.builder()

                .roomCode(RoomCodeGenerator.generate())
                .videoId(request.getVideoId())
                .hostName(request.getHostName())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(room);

        return RoomResponse.builder()

                .id(room.getId())
                .roomCode(room.getRoomCode())
                .videoId(room.getVideoId())
                .hostName(room.getHostName())
                .build();

    }



    @Override
    public RoomResponse getRoom(String roomCode) {

        Room room = repository.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Room Not Found"));

        return RoomResponse.builder()
                .id(room.getId())
                .roomCode(room.getRoomCode())
                .videoId(room.getVideoId())
                .hostName(room.getHostName())
                .build();
    }

    @Override
    public RoomResponse changeVideo(ChangeVideoRequest request) {

        Room room = repository.findByRoomCode(request.getRoomCode())
                .orElseThrow(() -> new RuntimeException("Room Not Found"));

        room.setVideoId(request.getVideoId());

        repository.save(room);

        return RoomResponse.builder()
                .id(room.getId())
                .roomCode(room.getRoomCode())
                .videoId(room.getVideoId())
                .hostName(room.getHostName())
                .build();

    }
}
