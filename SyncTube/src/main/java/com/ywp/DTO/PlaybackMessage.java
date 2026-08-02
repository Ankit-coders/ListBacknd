package com.ywp.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaybackMessage {

    private String roomCode;

    private String action;

    private String videoId;

    private Double currentTime;

}