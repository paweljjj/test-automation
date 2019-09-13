package com.pawel.automation.jsonplaceholder;

import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JsonplaceholderService {

    private final JsonplaceholderClient jsonplaceholderClient;
    private ResponseEntity<List<Posts>> postsResponse;
    private ResponseEntity<Comments> commentResponse;

    public void getPosts() {
        postsResponse = jsonplaceholderClient.getPosts();
    }

    public void getUserPosts(int userId) {
        postsResponse = jsonplaceholderClient.getPosts(userId);
    }

    private Posts getLastPost() {
        List<Posts> posts = postsResponse.getBody();
        Assert.assertNotNull("Posts not found in the response", posts);
        return posts.get(posts.size() - 1);
    }

    public void postCommentsForReturnedPostId(String name, String email, String body) {
        List<Posts> posts = postsResponse.getBody();
        Assert.assertNotNull("Posts not found in the response", posts);
        int postId = postsResponse.getBody().get(posts.size() - 1).getId();
        Comments comments = Comments.builder()
                .postId(postId)
                .name(name)
                .email(email)
                .body(body)
                .build();
        commentResponse = jsonplaceholderClient.postComments(comments);
    }

    public void assertHttpStatusIs200OK() {
        Assert.assertEquals(HttpStatus.OK, postsResponse.getStatusCode());
    }

    public void assertHttpStatusIs201CREATED() {
        Assert.assertEquals(HttpStatus.CREATED, postsResponse.getStatusCode());
    }

    public void assertLastPostUserId(int expectedResult) {
        Assert.assertEquals(expectedResult, getLastPost().getUserId());
    }

    public void assertLastPostId(int expectedResult) {
        Assert.assertEquals(expectedResult, getLastPost().getUserId());
    }

}
