package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainPage {

    private static final String APPLICATION_PRACTICE_URL = "http://automationpractice.com";
    private WebDriver webDriver;

    @FindBy(className = "login")
    private WebElement signIn;

    @FindBy(xpath = "//*[contains(@href,'http://automationpractice.com/index.php?controller=order')]")
    private WebElement cart;

    @Autowired
    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void clearBrowserCookies() {
        log.info("Clearing browser cookies");
        webDriver.manage().deleteAllCookies();
    }

    public void openApplicationPracticePage() {
        log.info("Opening {}", APPLICATION_PRACTICE_URL);
        webDriver.get(APPLICATION_PRACTICE_URL);
    }

    public void clickSignInButton() {
        signIn.click();
    }

    public void clickCard() {
        cart.click();
    }

}
