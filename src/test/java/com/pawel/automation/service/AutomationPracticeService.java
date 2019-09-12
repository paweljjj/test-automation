package com.pawel.automation.service;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutomationPracticeService {

    private static final String APPLICATION_PRACTICE_URL = "http://automationpractice.com";

    private WebDriver webDriver;

    public void openApplicationPracticePage() {
        webDriver.get(APPLICATION_PRACTICE_URL);
    }

}
