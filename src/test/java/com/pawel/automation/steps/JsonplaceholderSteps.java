package com.pawel.automation.steps;

import com.pawel.automation.jsonplaceholder.JsonplaceholderService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonplaceholderSteps {

    private final JsonplaceholderService jsonplaceholderService;

    @When("I send GET request")
    public void getPosts() {
        jsonplaceholderService.getPosts();
    }

    @Then("Http response status is 200 (OK)")
    public void assertHttpStatusIs200() {
        jsonplaceholderService.assertHttpStatusIs200OK();
    }

    @Then("Last post has userId: {int}")
    public void assertLastPostUserId(int userId) {
        jsonplaceholderService.assertLastPostUserId(userId);
    }

    @When("I send GET request for userId={int}")
    public void openApplicationPracticePage(int userId) {
        jsonplaceholderService.getUserPosts(userId);
    }

    @Then("Last post for selected user has Id: {int}")
    public void assertLastPostId(int userId) {
        jsonplaceholderService.assertLastPostId(userId);
    }

    @When("I send POST request for returned Id with name: {string} email: {string} body: {string}")
    public void postCommentsForReturnedPostId(String name, String email, String body) {
        jsonplaceholderService.postCommentsForReturnedPostId(name, email, body);
    }

    @Then("Http response status is 201 (CREATED)")
    public void assertHttpStatusIs201() {
        jsonplaceholderService.assertHttpStatusIs201CREATED();
    }

}
