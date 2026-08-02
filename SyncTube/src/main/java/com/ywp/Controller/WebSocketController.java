package com.ywp.Controller;

import com.ywp.DTO.PlaybackMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sync")
    public void sync(PlaybackMessage message){

        messagingTemplate.convertAndSend(

                "/topic/playback/" + message.getRoomCode(),

                message

        );

    }

}