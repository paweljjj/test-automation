package com.pawel.automation.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "jsonplaceholder", url = "${jsonplaceholder.ribbon-listOfServers}")
public interface JsonplaceholderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    ResponseEntity<List<Posts>> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts?userId")
    ResponseEntity<List<Posts>> getPosts(@RequestParam int userId);

    @RequestMapping(method = RequestMethod.POST, value = "/comments", consumes = "application/json")
    ResponseEntity<Comments> postComments(Comments comments);

}
