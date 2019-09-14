package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainPage {

    private static final String APPLICATION_PRACTICE_URL = "http://automationpractice.com/index.php";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(className = "login")
    private WebElement signIn;

    @FindBy(xpath = "//*[contains(@href,'http://automationpractice.com/index.php?controller=order')]")
    private WebElement cart;

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public void clearBrowserCookies() {
        log.info("Clearing browser cookies");
        webDriver.manage().deleteAllCookies();
    }

    public void openApplicationPracticePage() {
        log.info("Opening {}", APPLICATION_PRACTICE_URL);
        webDriver.get(APPLICATION_PRACTICE_URL);
    }

    public void applicationPageIsOpened() {
        webDriverWait.until(ExpectedConditions.urlToBe(APPLICATION_PRACTICE_URL));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signIn));
        Assert.assertEquals(APPLICATION_PRACTICE_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", APPLICATION_PRACTICE_URL);
    }

    public void clickSignInButton() {
        signIn.click();
    }

    public void clickCard() {
        cart.click();
    }

}
