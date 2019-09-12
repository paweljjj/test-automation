package com.pawel.automation.steps;

import com.pawel.automation.ContextLoader;
import com.pawel.automation.automationPractice.pageObjects.AuthenticationPage;
import com.pawel.automation.automationPractice.pageObjects.CreateAnAccountPage;
import com.pawel.automation.automationPractice.pageObjects.MainPage;
import com.pawel.automation.automationPractice.pageObjects.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.test.context.ContextConfiguration;

@RequiredArgsConstructor
@ContextConfiguration(classes = {ContextLoader.class})
public class AutomationPracticeSteps {

    private final MainPage mainPage;
    private final AuthenticationPage authenticationPage;
    private final CreateAnAccountPage createAnAccountPage;
    private final MyAccountPage myAccountPage;

    @Given("Automation Practice page is opened")
    public void openBrowser() {
        mainPage.openApplicationPracticePage();
    }

    @When("I click Sign in button")
    public void clickSignIn() {
        mainPage.clickSignInButton();
    }

    @Then("I can see Authentication Page")
    public void AuthenticationPageIsOpened() {
        authenticationPage.myAccountPageIsOpened();
    }

    @When("I enter random email adress")
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

    @When("I enter adressLine1: {string}")
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

    @When("I enter adressAlias: {string}")
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

}
