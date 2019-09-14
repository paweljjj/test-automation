package com.pawel.automation.steps;

import com.pawel.automation.automationPractice.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AutomationPracticeSteps {

    private final MainPage mainPage;
    private final AuthenticationPage authenticationPage;
    private final CreateAnAccountPage createAnAccountPage;
    private final MyAccountPage myAccountPage;
    private final OrderPage orderPage;

    @Before
    public void clearCookies() {
        mainPage.clearBrowserCookies();
    }

    @Given("Automation Practice page is opened")
    public void openApplicationPracticePage() {
        mainPage.openApplicationPracticePage();
        mainPage.applicationPageIsOpened();
    }

    @When("I click Sign in button on the Main Page")
    public void clickSignIn() {
        mainPage.clickSignInButton();
    }

    @Then("I can see Authentication Page")
    public void authenticationPageIsOpened() {
        authenticationPage.authenticationPageIsOpened();
    }

    @When("I enter random email address in Create an account panel")
    public void enterEmailAdress() {
        authenticationPage.enterRandomEmailCreateAccount();
    }

    @When("I click Create an account button")
    public void clickCreateAnAccountButton() {
        authenticationPage.clickCreateAnAccount();
    }

    @Then("I can see Create an account page")
    public void createAnAccountPageIsOpened() {
        createAnAccountPage.createAnAccountPageIsOpened();
    }

    @When("I enter firstName: {string}")
    public void enterFirstName(String input) {
        createAnAccountPage.enterFirstName(input);
    }

    @When("I enter lastName: {string}")
    public void enterLastName(String input) {
        createAnAccountPage.enterLastName(input);
    }

    @When("I enter password: {string}")
    public void enterPassword(String input) {
        createAnAccountPage.enterPassword(input);
    }

    @When("I enter firstNameAdress: {string}")
    public void enterFirstNameAdress(String input) {
        createAnAccountPage.enterFirstNameAdress(input);
    }

    @When("I enter lastNameAdress: {string}")
    public void enterLastNameAdress(String input) {
        createAnAccountPage.enterLastNameAdress(input);
    }

    @When("I enter addressLine1: {string}")
    public void enterAdressLine1(String input) {
        createAnAccountPage.enterAdressLine1(input);
    }

    @When("I enter city: {string}")
    public void enterCity(String input) {
        createAnAccountPage.enterCity(input);
    }

    @When("I select state: {string}")
    public void selectState(String input) {
        createAnAccountPage.selectState(input);
    }

    @When("I enter zipPostalCode: {string}")
    public void enterZipPostalCode(String input) {
        createAnAccountPage.enterZipPostalCode(input);
    }

    @When("I select country: {string}")
    public void selectCountry(String input) {
        createAnAccountPage.selectCountry(input);
    }

    @When("I enter mobilePhone: {string}")
    public void enterMobilePhone(String input) {
        createAnAccountPage.enterMobilePhone(input);
    }

    @When("I enter addressAlias: {string}")
    public void enterAdressAlias(String input) {
        createAnAccountPage.enterAdressAlias(input);
    }

    @When("I click Register button")
    public void enterAdressAlias() {
        createAnAccountPage.clickRegister();
    }

    @Then("I can see My Account page")
    public void myAccountPageIsOpened() {
        myAccountPage.myAccountPageIsOpened();
    }

    @When("I enter email: {string} for an existing account")
    public void enterEmailExistingAccount(String input) {
        authenticationPage.enterEmailExistingAccount(input);
    }

    @When("I enter password: {string} for an existing account")
    public void enterPasswordExistingAccount(String input) {
        authenticationPage.enterPasswordExistingAccount(input);
    }

    @When("I click Sign in button on the Authentication Page")
    public void authenticationClickSignIn() {
        authenticationPage.clickSignIn();
    }

    @When("I click Cart on the Main Page")
    public void clickCard() {
        mainPage.clickCard();
    }

    @Then("I can see Order Page")
    public void orderPageIsOpened() {
        orderPage.orderPageIsOpened();
    }

    @Then("I can see error message Your shopping cart is empty")
    public void errorMessageOrderEmptyIsVisible() {
        orderPage.errorMessageOrderEmptyIsVisible();
    }

}
