package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
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
public class AuthenticationPage {

    private static final String AUTHENTICATION_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccount;

    @FindBy(id = "email")
    private WebElement emailExisting;

    @FindBy(id = "passwd")
    private WebElement passwordExisting;

    @FindBy(id = "SubmitLogin")
    private WebElement signIn;

    public AuthenticationPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public void authenticationPageIsOpened() {
        webDriverWait.until(ExpectedConditions.urlToBe(AUTHENTICATION_URL));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailCreate));
        Assert.assertEquals(AUTHENTICATION_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", AUTHENTICATION_URL);
    }

    public void enterRandomEmailCreateAccount() {
        String randomGeneratedEmail = RandomStringUtils.randomAlphabetic(10) + "@domain.com";
        log.info("Random generated email: {}", randomGeneratedEmail);
        emailCreate.sendKeys(randomGeneratedEmail);
    }

    public void clickCreateAnAccount() {
        createAnAccount.click();
    }

    public void enterEmailExistingAccount(String input) {
        emailExisting.sendKeys(input);
    }

    public void enterPasswordExistingAccount(String input) {
        passwordExisting.sendKeys(input);
    }

    public void clickSignIn() {
        signIn.click();
    }

}
