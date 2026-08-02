package com.ywp.Service;

import com.ywp.DTO.YoutubeVideo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeServiceImpl implements YoutubeService {

    @Value("${youtube.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public YoutubeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<YoutubeVideo> search(String query) {

        List<YoutubeVideo> list = new ArrayList<>();

        try {

            String url =
                    "https://www.googleapis.com/youtube/v3/search" +
                            "?part=snippet" +
                            "&maxResults=10" +
                            "&type=video" +
                            "&q=" + query +
                            "&key=" + apiKey;

            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response);

            JsonNode items = root.get("items");

            if (items != null) {

                for (JsonNode item : items) {

                    String videoId =
                            item.get("id").get("videoId").asText();

                    String title =
                            item.get("snippet").get("title").asText();

                    String thumbnail =
                            item.get("snippet")
                                    .get("thumbnails")
                                    .get("high")
                                    .get("url")
                                    .asText();

                    list.add(new YoutubeVideo(
                            title,
                            videoId,
                            thumbnail
                    ));

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

}