package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderPage {

    private static final String ORDER_URL = "http://automationpractice.com/index.php?controller=order";
    private WebDriver webDriver;

    @FindBy(css = ".alert")
    private WebElement shoppingCardEmptyAlert;

    @Autowired
    public OrderPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void orderPageIsOpened() {
        Assert.assertEquals(ORDER_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", ORDER_URL);
    }

    public void errorMessageOrderEmptyIsVisible() {
        Assert.assertEquals("Your shopping cart is empty.", shoppingCardEmptyAlert.getText());
    }

}
