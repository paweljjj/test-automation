package com.pawel.automation.automationPractice.pageObjects;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationPage {

    private static final String AUTHENTICATION_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver webDriver;

    @FindBy(id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccount;

    @Autowired
    public AuthenticationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void myAccountPageIsOpened() {
        Assert.assertEquals(AUTHENTICATION_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", AUTHENTICATION_URL);
    }

    public void enterRandomEmailCreateAccount() {
        emailCreate.sendKeys(RandomStringUtils.randomAlphabetic(10) + "@domain.com");
    }

    public void clickCreateAnAccount() {
        createAnAccount.click();
    }

}
