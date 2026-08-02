package com.ywp.Controller;

import com.ywp.DTO.YoutubeVideo;
import com.ywp.Service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/youtube")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://songwithfriend-1.vercel.app/")
public class YoutubeController {

    private final YoutubeService youtubeService;

    @GetMapping("/search")
    public List<YoutubeVideo> search(@RequestParam String query){

        return youtubeService.search(query);

    }

}