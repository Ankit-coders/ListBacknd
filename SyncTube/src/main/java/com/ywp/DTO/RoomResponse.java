package com.ywp.DTO;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomResponse {

    private Long id;

    private String roomCode;

    private String videoId;

    private String hostName;

}