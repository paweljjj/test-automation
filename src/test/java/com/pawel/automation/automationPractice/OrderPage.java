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
public class OrderPage {

    private static final String ORDER_URL = "http://automationpractice.com/index.php?controller=order";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = ".alert")
    private WebElement shoppingCardEmptyAlert;

    @FindBy(css = ".icon-home")
    private WebElement homeIconButton;

    public OrderPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public void orderPageIsOpened() {
        webDriverWait.until(ExpectedConditions.urlToBe(ORDER_URL));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(homeIconButton));
        Assert.assertEquals(ORDER_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", ORDER_URL);
    }

    public void errorMessageOrderEmptyIsVisible() {
        Assert.assertEquals("Your shopping cart is empty.", shoppingCardEmptyAlert.getText());
    }

}
