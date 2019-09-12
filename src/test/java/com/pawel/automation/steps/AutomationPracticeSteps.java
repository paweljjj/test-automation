package com.pawel.automation.steps;

import com.pawel.automation.ContextLoader;
import com.pawel.automation.service.AutomationPracticeService;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import org.springframework.test.context.ContextConfiguration;

@RequiredArgsConstructor
@ContextConfiguration(classes = {ContextLoader.class})
public class AutomationPracticeSteps {

    private final AutomationPracticeService automationPracticeService;

    @Given("Automation Practice page is opened")
    public void openBrowser() {
        automationPracticeService.openApplicationPracticePage();
    }

}
