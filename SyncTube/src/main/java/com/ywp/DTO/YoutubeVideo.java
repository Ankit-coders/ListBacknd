package com.ywp.DTO;



import lombok.*;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YoutubeVideo {

    private String title;
    private String videoId;
    private String thumbnail;

}