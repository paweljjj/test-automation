package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyAccountPage {

    private static final String MY_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Autowired
    public MyAccountPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void myAccountPageIsOpened() {
//        webDriverWait.until(ExpectedConditions.urlToBe(MY_ACCOUNT_URL));
        Assert.assertEquals(MY_ACCOUNT_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", MY_ACCOUNT_URL);
    }

}
