package com.pawel.automation.automationPractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateAnAccountPage {

    private static final String CREATE_AN_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "firstname")
    private WebElement firstNameAdress;

    @FindBy(id = "lastname")
    private WebElement lastNameAdress;

    @FindBy(id = "address1")
    private WebElement adressLine1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zipPostalCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement adressAlias;

    @FindBy(id = "submitAccount")
    private WebElement register;

    @Autowired
    public CreateAnAccountPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void createAnAccountPageIsOpened() {
//        webDriverWait.until(ExpectedConditions.urlToBe(CREATE_AN_ACCOUNT_URL));
        Assert.assertEquals(CREATE_AN_ACCOUNT_URL, webDriver.getCurrentUrl());
        log.info("Page with url: {} has been opened", CREATE_AN_ACCOUNT_URL);
    }

    public void enterFirstName(String input) {
        firstName.sendKeys(input);
    }

    public void enterLastName(String input) {
        lastName.sendKeys(input);
    }

    public void enterPassword(String input) {
        password.sendKeys(input);
    }

    public void enterFirstNameAdress(String input) {
        firstNameAdress.sendKeys(input);
    }

    public void enterLastNameAdress(String input) {
        lastNameAdress.sendKeys(input);
    }

    public void enterAdressLine1(String input) {
        adressLine1.sendKeys(input);
    }

    public void enterCity(String input) {
        city.sendKeys(input);
    }

    public void selectState(String visibleText) {
        new Select(state).selectByVisibleText(visibleText);
    }

    public void enterZipPostalCode(String input) {
        zipPostalCode.sendKeys(input);
    }

    public void selectCountry(String visibleText) {
        new Select(country).selectByVisibleText(visibleText);
    }

    public void enterMobilePhone(String input) {
        mobilePhone.sendKeys(input);
    }

    public void enterAdressAlias(String input) {
        adressAlias.sendKeys(input);
    }

    public void clickRegister() {
        register.click();
    }

}
