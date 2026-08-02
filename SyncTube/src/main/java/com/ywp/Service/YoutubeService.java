package com.ywp.Service;



import com.ywp.DTO.YoutubeVideo;

import java.util.List;



import com.ywp.DTO.YoutubeVideo;

import java.util.List;

public interface YoutubeService {

    List<YoutubeVideo> search(String query);

}