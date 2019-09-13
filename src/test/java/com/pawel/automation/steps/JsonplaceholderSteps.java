package com.pawel.automation.steps;

import com.pawel.automation.jsonplaceholder.JsonplaceholderService;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonplaceholderSteps {

    private final JsonplaceholderService jsonplaceholderService;

    @When("I send get request")
    public void openApplicationPracticePage() {
        jsonplaceholderService.addFunctionality();
    }

}
