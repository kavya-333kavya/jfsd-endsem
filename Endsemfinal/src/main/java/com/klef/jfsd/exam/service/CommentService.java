package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Value("${api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public CommentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to get all comments from the API
    public List<Comment> getComments() {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                       .path("/comments")
                                       .toUriString();
        Comment[] commentsArray = restTemplate.getForObject(url, Comment[].class);
        return Arrays.asList(commentsArray);  // Convert the array to a list
    }

	 
}
